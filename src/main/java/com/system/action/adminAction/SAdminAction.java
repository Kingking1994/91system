package com.system.action.adminAction;

import com.opensymphony.xwork2.ModelDriven;
import com.system.action.SuperAction;
import com.system.entity.SAdmin;
import com.system.service.SAdminService;
import com.system.util.BeanUtil;
import com.system.util.PatternUtil;
import com.system.util.StrUtil;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by king on 2016/5/15.
 */
@Namespace("/sAdmin")
public class SAdminAction extends SuperAction implements ModelDriven<SAdmin>{

    private SAdmin sAdmin = new SAdmin();

    private String newPassword;

    private static final Logger LOGGER = Logger.getLogger(SAdminAction.class);

    @Autowired
    private SAdminService sAdminService;

    @Action(value = "login",results = {
            @Result(name = "success",location = "success.jsp"),
            @Result(name = "failure",location = "failure.jsp")
    })
    public String login(){
        try {
            SAdmin tmp = sAdminService.findByAccount(sAdmin.getAccount());
            if(BeanUtil.nonNull(tmp)){
                if(tmp.getPassword().equals(sAdmin.getPassword())){
                    LOGGER.info("登录成功");
                    session.setAttribute("s_account",tmp.getAccount());
                    return "success";
                }else{
                    LOGGER.warn("密码不正确");
                    session.setAttribute("errorMsg","密码不正确");
                    return "failure";
                }
            }else{
                LOGGER.warn("改管理员不存在");
                session.setAttribute("errorMsg","改管理员不存在");
                return "failure";
            }
        }catch (Exception e){
            LOGGER.error(e);
            return "failure";
        }
    }

    @Action(value = "logout",results = {
            @Result(name = "success",location = "success.jsp"),
            @Result(name = "failure",location = "failure.jsp")
    })
    public String logout(){
        try {
            if(StrUtil.isNotBlank((String)session.getAttribute("s_account"))){
                LOGGER.info("logout account = " + session.getAttribute("s_account"));
                session.removeAttribute("s_account");
                session.invalidate();
            }
            return "success";
        }catch (Exception e){
            LOGGER.error(e);
            return "failure";
        }
    }

    /**
     * 重置密码
     * @return
     */
    @Action(value = "password",results = {
            @Result(name = "success",location = "success.jsp"),
            @Result(name = "failure",location = "failure.jsp")
    })
    public String reset_password(){
        try {
            if(StrUtil.isNotBlank((String)session.getAttribute("s_account"))){
                SAdmin tmp = sAdminService.findByAccount((String)session.getAttribute("s_account"));
                if(tmp.getPassword().equals(sAdmin.getPassword())){
                    if(PatternUtil.checkPassword(newPassword)){
                        tmp.setPassword(newPassword);
                        sAdminService.saveOrUpdate(tmp);
                        return "success";
                    }else{
                        LOGGER.warn("新密码不规范");
                        session.setAttribute("errorMsg","新密码不规范");
                        return "failure";
                    }
                }else{
                    LOGGER.warn("原密码不正确");
                    session.setAttribute("errorMsg","原密码不正确");
                    return "failure";
                }
            }else{
                LOGGER.warn("还没有登录");
                session.setAttribute("errorMsg","还没有登录");
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

    public SAdmin getModel() {
        return sAdmin;
    }
}
