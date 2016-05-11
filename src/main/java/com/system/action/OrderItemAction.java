package com.system.action;

import com.opensymphony.xwork2.ModelDriven;
import com.system.entity.*;
import com.system.enums.OrderItemStatusEnum;
import com.system.enums.RefundStatusEnum;
import com.system.enums.UserIdentifiedEnum;
import com.system.service.*;
import com.system.util.StrUtil;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by king on 2016/5/9.
 */
@Namespace("/orders")
public class OrderItemAction extends SuperAction implements ModelDriven<OrderItem>{

    private OrderItem orderItem = new OrderItem();

    private int sid;

    private String oid;

    private static final Logger LOGGER = Logger.getLogger(OrderItemAction.class);

    @Autowired
    private HospitalService hospitalService;

    @Autowired
    private OfficeService officeService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private WalletService walletService;

    @Autowired
    private TradeService tradeService;

    @Autowired
    private RefundService refundService;


    /**
     * step1
     * 下单页面
     * @return
     */
    @Action(value = "order",results = {
            @Result(name = "success",location = "../success.jsp"),
            @Result(name = "failure",location = "../failure.jsp")
    })
    public String order(){
        try {
            if(StrUtil.isNotBlank((String) session.getAttribute("userPhone"))){
                if((Integer)session.getAttribute("identify") == UserIdentifiedEnum.NO.index){
                    LOGGER.info("该用户还没有完善个人信息");
                    return "failure";
                }else{
                    Schedule schedule = scheduleService.get(sid);
                    if(schedule.getNum() > schedule.getOrdernum()){
                        LOGGER.info(schedule);
                        session.setAttribute("schedule",schedule);
                        Doctor doctor = doctorService.get(schedule.getDid());
                        LOGGER.info(doctor);
                        session.setAttribute("doctor",doctor);
                        Office office = officeService.get(doctor.getOid());
                        LOGGER.info(office);
                        session.setAttribute("office",office);
                        Hospital hospital = hospitalService.get(office.getHid());
                        LOGGER.info(hospital);
                        session.setAttribute("hospital",hospital);

                        UserInfo userInfo = userInfoService.findByPhone((String) session.getAttribute("userPhone"));
                        LOGGER.info(userInfo);
                        session.setAttribute("userInfo",userInfo);
                        return "success";
                    }else{
                        LOGGER.warn("没有多的预约号了，已经预约满了");
                        session.setAttribute("errorMsg","没有多的预约号了，已经预约满了");
                        return "failure";
                    }
                }
            }else{
                LOGGER.warn("用户没有登录");
                session.setAttribute("errorMsg","用户没有登录");
                return "failure";
            }
        }catch (Exception e){
            LOGGER.error(e);
            return "failure";
        }
    }


    /**
     * step2
     * 提交订单
     * 钱包有足够的钱支付就自动扣钱
     * 没有钱支付就失败
     * @return
     */
    @Action(value = "submit",results = {
            @Result(name = "success",location = "../success.jsp"),
            @Result(name = "failure",location = "../failure.jsp")
    })
    public String submit(){
        try {
            if(StrUtil.isNotBlank((String) session.getAttribute("userPhone"))){
                if((Integer)session.getAttribute("identify") == UserIdentifiedEnum.NO.index){
                    LOGGER.info("该用户还没有完善个人信息");
                    return "failure";
                }else{
                    //更新预约剩余数量
                    Schedule s = (Schedule)session.getAttribute("schedule");
                    s = scheduleService.get(s.getSid());
                    if(s.getNum() > s.getOrdernum()){
                        if(orderItem != null){
                            UserInfo u = (UserInfo)session.getAttribute("userInfo");
                            Wallet w = u.getWallet();
                            if(w.getAccount() >= s.getFee()){
                                orderItem.setCreated(new Timestamp(System.currentTimeMillis()));
                                orderItem.setPayed(new Timestamp(System.currentTimeMillis()));
                                orderItem.setStatus(OrderItemStatusEnum.SUCCESS.index);
                                orderItem.setSid(s.getSid());
                                orderItem.setUiid(u.getUiid());
                                orderItemService.save(orderItem);
                                LOGGER.info(orderItem);

                                s.setOrdernum(s.getOrdernum() + 1);
                                scheduleService.saveOrUpdate(s);
                                LOGGER.info(s);

                                w.setAccount(w.getAccount() - s.getFee());
                                walletService.saveOrUpdate(w);
                                LOGGER.info(w);

                                Trade trade = new Trade();
                                trade.setTime(orderItem.getCreated());
                                trade.setAmount(s.getFee());
                                trade.setOrderItem(orderItem);
                                trade.setWid(w.getWid());
                                tradeService.save(trade);
                                LOGGER.info(trade);

                                session.setAttribute("orderItem",orderItem);

                                return "success";

                            }else{
                                LOGGER.warn("没有足够的钱支付");
                                session.setAttribute("errorMsg","没有足够的钱支付");
                                return "failure";
                            }
                        }else{
                            LOGGER.warn("orderItem == null");
                            return "failure";
                        }
                    }else{
                        LOGGER.warn("没有多的预约号了，已经预约满了");
                        session.setAttribute("errorMsg","没有多的预约号了，已经预约满了");
                        return "failure";
                    }
                }
            }else{
                LOGGER.warn("用户没有登录");
                session.setAttribute("errorMsg","用户没有登录");
                return "failure";
            }
        }catch (Exception e){
            LOGGER.error(e);
            return "failure";
        }
    }


    /**
     * 取消订单，修改订单状态，修改schedule的订单数量，钱包加上返回金额，生成一条退款记录
     * 在就诊24小时之前就可以取消，否则失败
     * @return
     */
    @Action(value = "cancel",results = {
            @Result(name = "success",location = "../success.jsp"),
            @Result(name = "failure",location = "../failure.jsp")
    })
    public String cancel(){
        try {
            if(StrUtil.isNotBlank((String) session.getAttribute("userPhone"))){
                if((Integer)session.getAttribute("identify") == UserIdentifiedEnum.NO.index){
                    LOGGER.info("该用户还没有完善个人信息");
                    return "failure";
                }else{
                    OrderItem oTmp = orderItemService.get(oid);
                    Schedule sTmp = scheduleService.get(oTmp.getSid());
                    Date date = sTmp.getDate();
                    Time time = oTmp.getTiming();
                    if(this.checkTime(date,time)){
                        oTmp.setStatus(OrderItemStatusEnum.CANCEL.index);
                        orderItemService.saveOrUpdate(oTmp);
                        LOGGER.info(oTmp);

                        sTmp.setOrdernum(sTmp.getOrdernum() - 1);
                        scheduleService.saveOrUpdate(sTmp);
                        LOGGER.info(sTmp);

                        UserInfo uTmp = userInfoService.get(oTmp.getUiid());
                        Wallet wTmp = uTmp.getWallet();
                        wTmp.setAccount(wTmp.getAccount() + sTmp.getFee());
                        walletService.saveOrUpdate(wTmp);
                        LOGGER.info(wTmp);

                        Refund refund = new Refund();
                        refund.setApply(new Timestamp(System.currentTimeMillis()));
                        refund.setCompleted(new Timestamp(System.currentTimeMillis()));
                        refund.setOrderItem(oTmp);
                        refund.setAmount(sTmp.getFee());
                        refund.setWid(wTmp.getWid());
                        refund.setStatus(RefundStatusEnum.SUCCESS.index);
                        refundService.save(refund);
                        LOGGER.info(refund);

                        return "success";
                    }else{
                        LOGGER.warn("已经超出退款期限，请在就诊前24小时申请退款");
                        session.setAttribute("errorMsg","已经超出退款期限，请在就诊前24小时申请退款");
                        return "failure";
                    }
                }
            }else{
                LOGGER.warn("用户没有登录");
                session.setAttribute("errorMsg","用户没有登录");
                return "failure";
            }
        }catch (Exception e){
            LOGGER.error(e);
            return "failure";
        }
    }


    /**
     * 我的订单
     * @return
     */
    @Action(value = "list",results = {
            @Result(name = "success",location = "../success.jsp"),
            @Result(name = "failure",location = "../failure.jsp")
    })
    public String orderList(){
        try {
            if(StrUtil.isNotBlank((String) session.getAttribute("userPhone"))){
                if((Integer)session.getAttribute("identify") == UserIdentifiedEnum.NO.index){
                    LOGGER.info("该用户还没有完善个人信息");
                    return "failure";
                }else{
                    UserInfo uTmp = userInfoService.findByPhone((String) session.getAttribute("userPhone"));
                    session.setAttribute("userInfo",uTmp);
                    return "success";
                }
            }else{
                LOGGER.warn("用户没有登录");
                session.setAttribute("errorMsg","用户没有登录");
                return "failure";
            }
        }catch (Exception e){
            LOGGER.error(e);
            return "failure";
        }
    }


    /**
     * 订单详情
     * @return
     */
    @Action(value = "detail",results = {
            @Result(name = "success",location = "../success.jsp"),
            @Result(name = "failure",location = "../failure.jsp")
    })
    public String detail(){
        try {
            if(StrUtil.isNotBlank((String) session.getAttribute("userPhone"))){
                if((Integer)session.getAttribute("identify") == UserIdentifiedEnum.NO.index){
                    LOGGER.info("该用户还没有完善个人信息");
                    return "failure";
                }else{
                    OrderItem orderItem = orderItemService.get(oid);
                    LOGGER.info(orderItem);
                    session.setAttribute("orderItem",orderItem);
                    Schedule schedule = scheduleService.get(orderItem.getSid());
                    LOGGER.info(schedule);
                    session.setAttribute("schedule",schedule);
                    Doctor doctor = doctorService.get(schedule.getDid());
                    LOGGER.info(doctor);
                    session.setAttribute("doctor",doctor);
                    Office office = officeService.get(doctor.getOid());
                    LOGGER.info(office);
                    session.setAttribute("office",office);
                    Hospital hospital = hospitalService.get(office.getHid());
                    LOGGER.info(hospital);
                    session.setAttribute("hospital",hospital);

                    return "success";
                }
            }else{
                LOGGER.warn("用户没有登录");
                session.setAttribute("errorMsg","用户没有登录");
                return "failure";
            }
        }catch (Exception e){
            LOGGER.error(e);
            return "failure";
        }
    }



//    @Action(value = "test",results = {
//            @Result(name = "success",location = "../test.jsp")
//    })
//    public String test(){
//        session.setAttribute("userPhone","18814122697");
//        session.setAttribute("identify",1);
//        session.setAttribute("schedule",scheduleService.get(1));
//        session.setAttribute("userInfo",userInfoService.get(1));
//        return "success";
//    }


    /**
     * 判断订单是否在可以退款时间内，退款时间必须在就诊时间的24小时之前
     * @param date  排班表中的日期
     * @param time  订单中的具体时间点
     * @return
     */
    private boolean checkTime(Date date,Time time){
        String dateStr = date.toString()+" "+time.toString();

        long dayMillis = 86400000;

        java.util.Date d = new java.util.Date();
        //注意format的格式要与日期String的格式相匹配
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            d = sdf.parse(dateStr);
            if(d.getTime() >= (System.currentTimeMillis() + dayMillis)){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public OrderItem getModel() {
        return orderItem;
    }
}
