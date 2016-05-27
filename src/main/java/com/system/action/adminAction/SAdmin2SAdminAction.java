package com.system.action.adminAction;

import com.opensymphony.xwork2.ModelDriven;
import com.system.action.SuperAction;
import com.system.entity.SAdmin;
import com.system.enums.SAdminIsrootEnum;
import com.system.service.SAdminService;
import com.system.util.BeanUtil;
import com.system.util.PatternUtil;
import com.system.util.StrUtil;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by king on 2016/5/15.
 */
@Namespace("/sAdmin")
public class SAdmin2SAdminAction extends SuperAction implements ModelDriven<SAdmin>{

    private SAdmin sAdmin = new SAdmin();

    private static final Logger LOGGER = Logger.getLogger(SAdmin2SAdminAction.class);

    @Autowired
    private SAdminService sAdminService;


    /**
     * 权限为超级管理员
     * 获得系统管理员列表
     * @return
     */
    @Action(value = "sAdmin_list",results = {
            @Result(name = "success",location = "../a_s_sa_list.jsp"),
            @Result(name = "failure",location = "failure.jsp")
    })
    public String sAdmin_list(){
        try {
            if(StrUtil.isNotBlank((String)session.getAttribute("s_account"))){
                SAdmin tmp = sAdminService.findByAccount((String)session.getAttribute("s_account"));
                if(tmp.getIsroot() == SAdminIsrootEnum.TRUE.index){
                    List<SAdmin> sAdminList = sAdminService.findAll();
                    LOGGER.info(sAdminList);
                    session.setAttribute("sAdminList",sAdminList);
                    return "success";
                }else{
                    LOGGER.warn("该管理员没有权限");
                    session.setAttribute("errorMsg","该管理员没有权限");
                    return "failure";
                }
            }else{
                LOGGER.warn("该管理员没有登录");
                session.setAttribute("errorMsg","该管理员没有登录");
                return "failure";
            }
        }catch (Exception e){
            LOGGER.error(e);
            return "failure";
        }
    }


    /**
     * 权限为超级管理员
     * 添加系统管理员
     * @return
     */
    @Action(value = "sAdmin_add",results = {
            @Result(name = "success",location = "/sAdmin/sAdmin_list",type = "redirect"),
            @Result(name = "failure",location = "failure.jsp")
    })
    public String sAdmin_add(){
        try {
            if(StrUtil.isNotBlank((String)session.getAttribute("s_account"))){
                SAdmin tmp = sAdminService.findByAccount((String)session.getAttribute("s_account"));
                if(tmp.getIsroot() == SAdminIsrootEnum.TRUE.index){
                    SAdmin s = sAdminService.findByAccount(sAdmin.getAccount());
                    if(BeanUtil.isNull(s)){
                        if(PatternUtil.checkPassword(sAdmin.getPassword())){
                            sAdmin.setIsroot(SAdminIsrootEnum.FALSE.index);
                            sAdminService.save(sAdmin);
                            return "success";
                        }else{
                            LOGGER.warn("该密码不合规范");
                            session.setAttribute("errorMsg","该密码不合规范");
                            return "failure";
                        }
                    }else{
                        LOGGER.warn("该账号已经存在");
                        session.setAttribute("errorMsg","该账号已经存在");
                        return "failure";
                    }
                }else{
                    LOGGER.warn("该管理员没有权限");
                    session.setAttribute("errorMsg","该管理员没有权限");
                    return "failure";
                }
            }else{
                LOGGER.warn("该管理员没有登录");
                session.setAttribute("errorMsg","该管理员没有登录");
                return "failure";
            }
        }catch (Exception e){
            LOGGER.error(e);
            return "failure";
        }
    }


    /**
     * 权限为超级管理员
     * 删除系统管理员
     * @return
     */
    @Action(value = "sAdmin_delete",results = {
            @Result(name = "success",location = "/sAdmin/sAdmin_list",type = "redirect"),
            @Result(name = "failure",location = "failure.jsp")
    })
    public String sAdmin_delete(){
        try {
            if(StrUtil.isNotBlank((String)session.getAttribute("s_account"))){
                SAdmin tmp = sAdminService.findByAccount((String)session.getAttribute("s_account"));
                if(tmp.getIsroot() == SAdminIsrootEnum.TRUE.index){
                    String saidString = request.getParameter("said");
                    if(StrUtil.isNum(saidString)){
                        int said = Integer.parseInt(saidString);
                        if(said != 1){
                            sAdminService.delete(said);
                            return "success";
                        }else{
                            LOGGER.warn("超级管理员无法被删除");
                            session.setAttribute("errorMsg","超级管理员无法被删除");
                            return "failure";
                        }
                    }else{
                        LOGGER.warn("非法的输入");
                        session.setAttribute("errorMsg","非法的输入");
                        return "failure";
                    }
                }else{
                    LOGGER.warn("该管理员没有权限");
                    session.setAttribute("errorMsg","该管理员没有权限");
                    return "failure";
                }
            }else{
                LOGGER.warn("该管理员没有登录");
                session.setAttribute("errorMsg","该管理员没有登录");
                return "failure";
            }
        }catch (Exception e){
            LOGGER.error(e);
            return "failure";
        }
    }


    public SAdmin getModel() {
        return sAdmin;
    }
}
