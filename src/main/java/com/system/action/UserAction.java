package com.system.action;

import com.opensymphony.xwork2.ModelDriven;
import com.system.entity.User;
import com.system.entity.UserInfo;
import com.system.enums.UserIdentifiedEnum;
import com.system.service.UserInfoService;
import com.system.service.UserService;
import com.system.util.BeanUtil;
import com.system.util.PatternUtil;
import com.system.util.StrUtil;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by king on 2016/5/5.
 */
@Namespace("/users")
public class UserAction extends SuperAction implements ModelDriven<User>{

    private User user = new User();

    private String newPassword;

    private static final Logger LOGGER = Logger.getLogger(UserAction.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserInfoService userInfoService;


    /**
     *
     * 注册
     * @return
     */
    @Action(value = "register",results = {
            @Result(name = "success",location = "/hospitals/list" ,type = "redirect"),
            @Result(name = "failure",location = "../login.jsp")
    })
    public String userRegister(){
        try{
            if(PatternUtil.checkPhone(user.getPhone())){
                User tmp = userService.findByPhone(user.getPhone());
                if(BeanUtil.isNull(tmp)){
                    if(PatternUtil.checkPassword(user.getPassword())){
                        int uid = userService.save(user);
                        LOGGER.info(uid);
                        session.setAttribute("userPhone",user.getPhone());
                        session.setAttribute("identify", UserIdentifiedEnum.NO.index);
                        return "success";
                    }else{
                        LOGGER.warn("密码长度不对或者包含特殊字符");
                        session.setAttribute("errorMsg","密码长度不对或者包含特殊字符");
                        return "failure";
                    }
                }else{
                    LOGGER.warn("电话号码已经被注册: " + user.getPhone());
                    session.setAttribute("errorMsg","电话号码已经被注册");
                    return "failure";
                }
            }else{
                LOGGER.warn("这不是一个手机号码");
                session.setAttribute("errorMsg","这不是一个手机号码");
                return "failure";
            }
        }catch (Exception e){
            LOGGER.error(e);
            return "failure";
        }
    }

    /**
     * 登录
     * @return
     */
    @Action(value = "login",results = {
            @Result(name = "success",location = "/hospitals/list" ,type = "redirect"),
            @Result(name = "failure",location = "../login.jsp")
    })
    public String userLogin(){
        try {
            User tmp = userService.findByPhone(user.getPhone());
            if (BeanUtil.isNull(tmp)){
                LOGGER.warn("该用户不存在： " + user.getPhone());
                session.setAttribute("errorMsg","该用户不存在");
                return "failure";
            }else{
                if (!tmp.getPassword().equals(user.getPassword())){
                    LOGGER.warn("密码不正确");
                    session.setAttribute("errorMsg","密码不正确");
                    return "failure";
                }else{
                    LOGGER.info("登录成功 ： " + user.getPhone());
                    session.setAttribute("userPhone",user.getPhone());
                    session.setAttribute("identify",tmp.getIdentified());
                    if(tmp.getIdentified() == UserIdentifiedEnum.YES.index){
                        UserInfo userInfo = userInfoService.findByPhone(user.getPhone());
                        session.setAttribute("userName",userInfo.getName());
                    }
                    return "success";
                }
            }
        }catch (Exception e){
            LOGGER.error(e);
            return "failure";
        }
    }

    /**
     * 注销
     * @return
     */
    @Action(value = "logout",results = {
            @Result(name = "success",location = "../login.jsp"),
            @Result(name = "failure",location = "../failure.jsp")
    })
    public String userLogout(){
        try {
            if(StrUtil.isNotBlank((String) session.getAttribute("userPhone"))){
                LOGGER.info("logout : " + session.getAttribute("userPhone"));
                session.removeAttribute("userPhone");
                if ((Integer)session.getAttribute("identify") == UserIdentifiedEnum.YES.index){
                    session.removeAttribute("identify");
                }
                session.invalidate();
            }
            return "success";
        }catch (Exception e){
            LOGGER.error(e);
            return "failure";
        }
    }


    /**
     * 修改密码
     * @return
     */
    @Action(value = "password",results = {
            @Result(name = "success",location = "../reset_pwd_success.jsp"),
            @Result(name = "failure",location = "../failure.jsp")
    })
    public String userPwd(){
        try {
            if(StrUtil.isNotBlank((String) session.getAttribute("userPhone"))){
                User tmp = userService.findByPhone((String) session.getAttribute("userPhone"));
                if(BeanUtil.nonNull(tmp)){
                    if(user.getPassword().equals(tmp.getPassword())){
                        LOGGER.info("newPassword : " + newPassword);
                        if(PatternUtil.checkPassword(newPassword)){
                            tmp.setPassword(newPassword);
                            userService.saveOrUpdate(tmp);
                            LOGGER.info("密码修改成功");
                            return "success";
                        }else{
                            LOGGER.warn("新密码不合规范");
                            session.setAttribute("errorMsg","新密码不合规范");
                            return "failure";
                        }
                    }else{
                        LOGGER.warn("原密码错误");
                        session.setAttribute("errorMsg","原密码错误");
                        return "failure";
                    }
                }else{
                    LOGGER.warn("该用户不存在： " + user.getPhone());
                    session.setAttribute("errorMsg","该用户不存在");
                    return "failure";
                }
            }else{
                LOGGER.warn("用户没有登录");
                session.setAttribute("errorMsg", "用户没有登录");
                return "failure";
            }
        }catch (Exception e){
            LOGGER.error(e);
            return "failure";
        }
    }





    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public User getModel() {
        return user;
    }
}
