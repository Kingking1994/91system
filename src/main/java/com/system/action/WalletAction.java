package com.system.action;

import com.system.entity.ErrorMsg;
import com.system.entity.UserInfo;
import com.system.entity.Wallet;
import com.system.enums.UserIdentifiedEnum;
import com.system.service.RefundService;
import com.system.service.TradeService;
import com.system.service.UserInfoService;
import com.system.service.WalletService;
import com.system.util.StrUtil;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by king on 2016/5/6.
 */
@Namespace("/wallets")
public class WalletAction extends SuperAction {

    private int rechargeAmount;//充值的金额

    private static final Logger LOGGER = Logger.getLogger(WalletAction.class);

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private WalletService walletService;



    /**
     * 钱包
     * @return
     */
    @Actions({
            //交易记录
            @Action(value = "trade",results = {
                    @Result(name = "success",location = "../trade.jsp"),
                    @Result(name = "failure",location = "../errorMsg.jsp"),
                    @Result(name = "loginError",location = "/home/welcomeUser",type = "redirect")
            }),
            //退款记录
            @Action(value = "refund",results = {
                    @Result(name = "success",location = "../refund.jsp"),
                    @Result(name = "failure",location = "../errorMsg.jsp"),
                    @Result(name = "loginError",location = "/home/welcomeUser",type = "redirect")
            })
    })
    public String wallet(){
        try {
            if(StrUtil.isNotBlank((String) session.getAttribute("userPhone"))){
                if((Integer)session.getAttribute("identify") == UserIdentifiedEnum.NO.index){
                    LOGGER.info("该用户还没有完善个人信息");
                    session.setAttribute("errorMsg",new ErrorMsg(103,"用户没有完善个人资料"));
                    return "failure";
                }else{
                    UserInfo u = userInfoService.findByPhone((String) session.getAttribute("userPhone"));
                    Wallet wallet = u.getWallet();
                    session.setAttribute("wallet",wallet);
                    return "success";
                }
            }else{
                LOGGER.warn("用户没有登录");
                session.setAttribute("errorMsg",new ErrorMsg(102,"用户没有登录"));
                return "loginError";
            }
        }catch (Exception e){
            LOGGER.error(e);
            session.setAttribute("errorMsg",new ErrorMsg(100,"系统内部异常"));
            return "failure";
        }
    }


    /**
     * 钱包充值
     * @return
     */
    @Action(value = "recharge",results = {
            @Result(name = "success",location = "/wallets/trade" ,type = "redirect"),
            @Result(name = "failure",location = "../errorMsg.jsp"),
            @Result(name = "loginError",location = "/home/welcomeUser",type = "redirect")
    })
    public String recharge(){
        try {
            if(StrUtil.isNotBlank((String) session.getAttribute("userPhone"))){
                if((Integer)session.getAttribute("identify") == UserIdentifiedEnum.NO.index){
                    LOGGER.info("该用户还没有完善个人信息");
                    session.setAttribute("errorMsg",new ErrorMsg(103,"用户没有完善个人资料"));
                    return "failure";
                }else{
                    UserInfo u = userInfoService.findByPhone((String) session.getAttribute("userPhone"));
                    Wallet wallet = u.getWallet();
                    wallet.setAccount(wallet.getAccount() + rechargeAmount);
                    walletService.saveOrUpdate(wallet);
                    session.setAttribute("wallet",wallet);
                    LOGGER.info("recharge : " + rechargeAmount);
                    return "success";
                }
            }else{
                LOGGER.warn("用户没有登录");
                session.setAttribute("errorMsg",new ErrorMsg(102,"用户没有登录"));
                return "loginError";
            }
        }catch (Exception e){
            LOGGER.error(e);
            session.setAttribute("errorMsg",new ErrorMsg(100,"系统内部异常"));
            return "failure";
        }
    }



    public int getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(int rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }
}
