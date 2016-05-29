package com.system.action.adminAction;

import com.opensymphony.xwork2.ModelDriven;
import com.system.action.SuperAction;
import com.system.entity.ErrorMsg;
import com.system.entity.HAdmin;
import com.system.entity.SAdmin;
import com.system.service.HAdminService;
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
public class SAdmin2HAdminAction extends SuperAction implements ModelDriven<HAdmin>{

    private HAdmin hAdmin = new HAdmin();

    private static final Logger LOGGER = Logger.getLogger(SAdmin2HAdminAction.class);

    @Autowired
    private HAdminService hAdminService;


    /**
     * 获取医院管理员列表
     * @return
     */
    @Action(value = "hAdmin_list",results = {
            @Result(name = "success",location = "../a_s_ha_list.jsp"),
            @Result(name = "failure",location = "../a_s_errorMsg.jsp")
    })
    public String hAdmin_list(){
        try {
            if(StrUtil.isNotBlank((String) session.getAttribute("s_account"))){
                List<HAdmin> hAdminList = hAdminService.findAll();
                LOGGER.info(hAdminList);
                session.setAttribute("hAdminList",hAdminList);
                return "success";
            }else{
                LOGGER.warn("该管理员没有登录");
                session.setAttribute("errorMsg",new ErrorMsg(116,"管理员没有登录"));
                return "failure";
            }
        }catch (Exception e){
            LOGGER.error(e);
            session.setAttribute("errorMsg",new ErrorMsg(100,"系统内部异常"));
            return "failure";
        }
    }


    /**
     * 添加医院管理员
     * @return
     */
    @Action(value = "hAdmin_add",results = {
            @Result(name = "success",location = "/sAdmin/hAdmin_list",type = "redirect"),
            @Result(name = "failure",location = "../a_s_errorMsg.jsp")
    })
    public String hAdmin_add(){
        try {
            if(StrUtil.isNotBlank((String) session.getAttribute("s_account"))){
                if(BeanUtil.nonNull(hAdmin)){
                    HAdmin h = hAdminService.findByAccount(hAdmin.getAccount());
                    if(BeanUtil.isNull(h)){
                        if(PatternUtil.checkPassword(hAdmin.getPassword())){
                            LOGGER.info(hAdmin);
                            hAdminService.save(hAdmin);
                            return "success";
                        }else{
                            LOGGER.warn("密码不合规范");
                            session.setAttribute("errorMsg",new ErrorMsg(107,"密码格式不对"));
                            return "failure";
                        }
                    }else{
                        LOGGER.warn("该账号已经存在");
                        session.setAttribute("errorMsg",new ErrorMsg(114,"该账号已经存在"));
                        return "failure";
                    }
                }else{
                    LOGGER.warn("参数为null");
                    session.setAttribute("errorMsg",new ErrorMsg(101,"非法的参数输入"));
                    return "failure";
                }
            }else{
                LOGGER.warn("该管理员没有登录");
                session.setAttribute("errorMsg",new ErrorMsg(116,"管理员没有登录"));
                return "failure";
            }
        }catch (Exception e){
            LOGGER.error(e);
            session.setAttribute("errorMsg",new ErrorMsg(100,"系统内部异常"));
            return "failure";
        }
    }


    /**
     * 删除医院管理员
     * @return
     */
    @Action(value = "hAdmin_delete",results = {
            @Result(name = "success",location = "/sAdmin/hAdmin_list",type = "redirect"),
            @Result(name = "failure",location = "../a_s_errorMsg.jsp")
    })
    public String hAdmin_delete(){
        try {
            if(StrUtil.isNotBlank((String) session.getAttribute("s_account"))){
                String haidString  = request.getParameter("haid");
                if(StrUtil.isNum(haidString)){
                    int haid = Integer.parseInt(haidString);
                    LOGGER.info(haid);
                    hAdminService.delete(haid);
                    return "success";
                }else{
                    LOGGER.warn("非法的输入");
                    session.setAttribute("errorMsg",new ErrorMsg(101,"非法的参数输入"));
                    return "failure";
                }
            }else{
                LOGGER.warn("该管理员没有登录");
                session.setAttribute("errorMsg",new ErrorMsg(116,"管理员没有登录"));
                return "failure";
            }
        }catch (Exception e){
            LOGGER.error(e);
            session.setAttribute("errorMsg",new ErrorMsg(100,"系统内部异常"));
            return "failure";
        }
    }

    public HAdmin getModel() {
        return hAdmin;
    }
}
