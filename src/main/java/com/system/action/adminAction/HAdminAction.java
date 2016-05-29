package com.system.action.adminAction;

import com.opensymphony.xwork2.ModelDriven;
import com.system.action.SuperAction;
import com.system.entity.ErrorMsg;
import com.system.entity.HAdmin;
import com.system.service.HAdminService;
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
@Namespace("/hAdmin")
public class HAdminAction extends SuperAction implements ModelDriven<HAdmin>{

    private HAdmin hAdmin = new HAdmin();

    private String newPassword;

    private static final Logger LOGGER = Logger.getLogger(HAdminAction.class);

    @Autowired
    private HAdminService hAdminService;


    @Action(value = "login",results = {
            @Result(name = "success",location = "/hAdmin/office_list",type = "redirect"),
            @Result(name = "failure",location = "/home/welcomeAdmin" ,type = "redirect")
    })
    public String login(){
        try {
            HAdmin tmp = hAdminService.findByAccount(hAdmin.getAccount());
            if(BeanUtil.nonNull(tmp)){
                if(tmp.getPassword().equals(hAdmin.getPassword())){
                    LOGGER.info("登录成功");
                    session.setAttribute("h_account",tmp.getAccount());
                    session.setAttribute("hid",tmp.getHid());
                    return "success";
                }else{
                    LOGGER.warn("密码不正确");
                    session.setAttribute("errorMsg",new ErrorMsg(111,"密码不正确"));
                    return "failure";
                }
            }else{
                LOGGER.warn("改管理员不存在");
                session.setAttribute("errorMsg",new ErrorMsg(112,"该管理员不存在"));
                return "failure";
            }
        }catch (Exception e){
            LOGGER.error(e);
            session.setAttribute("errorMsg",new ErrorMsg(100,"系统内部异常"));
            return "failure";
        }
    }

    @Action(value = "logout",results = {
            @Result(name = "success",location = "../adminLogin.jsp"),
            @Result(name = "failure",location = "../a_h_errorMsg.jsp")
    })
    public String logout(){
        try {
            if(StrUtil.isNotBlank((String) session.getAttribute("h_account"))){
                LOGGER.info("logout account = " + session.getAttribute("h_account"));
                session.removeAttribute("h_account");
                session.invalidate();
            }
            return "success";
        }catch (Exception e){
            LOGGER.error(e);
            session.setAttribute("errorMsg",new ErrorMsg(100,"系统内部异常"));
            return "failure";
        }
    }

    /**
     * 重置密码
     * @return
     */
    @Action(value = "password",results = {
            @Result(name = "success",location = "../a_h_pwd_success.jsp"),
            @Result(name = "failure",location = "../a_h_errorMsg.jsp")
    })
    public String reset_password(){
        try {
            if(StrUtil.isNotBlank((String)session.getAttribute("h_account"))){
                HAdmin tmp = hAdminService.findByAccount((String)session.getAttribute("h_account"));
                if(tmp.getPassword().equals(hAdmin.getPassword())){
                    if(PatternUtil.checkPassword(newPassword)){
                        tmp.setPassword(newPassword);
                        hAdminService.saveOrUpdate(tmp);
                        return "success";
                    }else{
                        LOGGER.warn("新密码不规范");
                        session.setAttribute("errorMsg",new ErrorMsg(107,"密码格式不对"));
                        return "failure";
                    }
                }else{
                    LOGGER.warn("原密码不正确");
                    session.setAttribute("errorMsg",new ErrorMsg(111,"密码不正确"));
                    return "failure";
                }
            }else{
                LOGGER.warn("还没有登录");
                session.setAttribute("errorMsg",new ErrorMsg(116,"管理员没有登录"));
                return "failure";
            }
        }catch (Exception e){
            LOGGER.error(e);
            session.setAttribute("errorMsg",new ErrorMsg(100,"系统内部异常"));
            return "failure";
        }
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public HAdmin getModel() {
        return hAdmin;
    }

}
