package com.system.action;

import com.opensymphony.xwork2.ModelDriven;
import com.system.entity.User;
import com.system.entity.UserInfo;
import com.system.entity.Wallet;
import com.system.enums.UserIdentifiedEnum;
import com.system.service.UserInfoService;
import com.system.service.UserService;
import com.system.service.WalletService;
import com.system.util.BeanUtil;
import com.system.util.StrUtil;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by king on 2016/5/6.
 */
@Namespace("/users")
public class UserInfoAction extends SuperAction implements ModelDriven<UserInfo>{

    private UserInfo userInfo = new UserInfo();

    private static final Logger LOGGER = Logger.getLogger(UserInfoAction.class);

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserService userService;

    @Autowired
    private WalletService walletService;


    /**
     * 完善个人信息
     * 或者修改个人信息
     * @return
     */
    @Action(value = "info_set",results = {
            @Result(name = "success",location = "../userInfo.jsp"),
            @Result(name = "failure",location = "../failure.jsp")
    })
    public String infoSet(){
        try {
            if(StrUtil.isNotBlank((String) session.getAttribute("userPhone"))){
                int identify = (Integer)session.getAttribute("identify");
                UserInfo tmp = new UserInfo();
                if(identify == UserIdentifiedEnum.NO.index){
                    tmp.setPhone((String) session.getAttribute("userPhone"));
                    LOGGER.info("完善个人信息");
                    session.setAttribute("userInfo",tmp);
                    return "success";
                }else{
                    tmp = userInfoService.findByPhone((String) session.getAttribute("userPhone"));
                    LOGGER.info("修改个人信息");
                    session.setAttribute("userInfo",tmp);
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
     * 保存或者更新个人信息
     * @return
     */
    @Action(value = "info_save",results = {
            @Result(name = "success",location = "/users/info" ,type = "redirect"),
            @Result(name = "failure",location = "../failure.jsp")
    })
    public String infoSaveOrUpdate(){
        try {
            if(StrUtil.isNotBlank((String) session.getAttribute("userPhone"))){
                if(BeanUtil.nonNull(userInfo)){
                    int identify = (Integer)session.getAttribute("identify");
                    if(identify == UserIdentifiedEnum.YES.index){//已经完善个人信息，只需要更新信息
                        /**
                         * org.hibernate.NonUniqueObjectException
                         * 设置userInfo的uiid，uid之后
                         * 直接saveOrUpdate（userInfo），
                         * 就会报NonUniqueObjectException，
                         * 所以在不改变其他代码的情况下，选了以下的解决方案
                         *
                         * 这个异常的原因是当前hibernate的session中已经存在一个相同标识符的po。
                         */
                        UserInfo tmp = (UserInfo)session.getAttribute("userInfo");
                        tmp.setName(userInfo.getName());
                        tmp.setPhone(userInfo.getPhone());
                        tmp.setGender(userInfo.getGender());
                        tmp.setBirthday(userInfo.getBirthday());
                        tmp.setIdcard(userInfo.getIdcard());
                        tmp.setAddress(userInfo.getAddress());
                        tmp.setEmail(userInfo.getEmail());
                        tmp.setBlood(userInfo.getBlood());
                        tmp.setCareer(userInfo.getCareer());
                        tmp.setMarried(userInfo.getMarried());
                        userInfoService.saveOrUpdate(tmp);
                        LOGGER.info("成功修改个人信息");
                        return "success";
                    }else{
                        //未完善信息，需要更新user表，插入userInfo表，插入wallet表，更新session中的identify
                        User u = userService.findByPhone((String) session.getAttribute("userPhone"));
                        u.setIdentified(UserIdentifiedEnum.YES.index);
                        userService.saveOrUpdate(u);
                        userInfo.setUser(u);
                        userInfoService.save(userInfo);
                        Wallet w = new Wallet(0);//完善信息后，初始化钱包，金额为0
                        w.setUserInfo(userInfo);
                        walletService.save(w);
                        session.setAttribute("identify",UserIdentifiedEnum.YES.index);
                        LOGGER.info("成功完善个人信息");
                        return "success";
                    }
                }else{
                    LOGGER.warn("userInfo == null");
                    return "failure";
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
     * 显示个人信息
     * @return
     */
    @Action(value = "info",results = {
            @Result(name = "success",location = "../userInfo.jsp"),
            @Result(name = "failure",location = "../failure.jsp")
    })
    public String infoShow(){
        try {
            if(StrUtil.isNotBlank((String) session.getAttribute("userPhone"))){
                if((Integer)session.getAttribute("identify") == UserIdentifiedEnum.NO.index){
                    LOGGER.info("该用户还没有完善个人信息");
                    return "failure";
                }else{
                    UserInfo tmp = userInfoService.findByPhone((String) session.getAttribute("userPhone"));
                    LOGGER.info(tmp);
                    session.setAttribute("userInfo",tmp);
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



    public UserInfo getModel() {
        return userInfo;
    }
}
