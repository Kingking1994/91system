package com.system.action.adminAction;

import com.opensymphony.xwork2.ModelDriven;
import com.system.action.SuperAction;
import com.system.entity.Office;
import com.system.entity.Pager;
import com.system.enums.Constant;
import com.system.service.HAdminService;
import com.system.service.OfficeService;
import com.system.util.BeanUtil;
import com.system.util.StrUtil;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by king on 2016/5/15.
 */
@Namespace("/hAdmin/office")
public class HAdmin2OfficeAction extends SuperAction implements ModelDriven<Office>{

    private Office officeModel = new Office();

    private static final Logger LOGGER = Logger.getLogger(HAdmin2OfficeAction.class);

    @Autowired
    private OfficeService officeService;


    @Action(value = "list",results = {
            @Result(name = "success",location = "success.jsp"),
            @Result(name = "failure",location = "failure.jsp")
    })
    public String office_list(){
        try {
            if(StrUtil.isNotBlank((String) session.getAttribute("h_account"))){
                String pageNumString = request.getParameter("pageNum");
                int pageNum = 1;//设置默认页数
                if(StrUtil.isNum(pageNumString)){//如果是非法是字符串，则使用默认页数
                    pageNum = Integer.parseInt(pageNumString);
                }
                Pager<Office> officePager = officeService.findOffice(officeModel,pageNum, Constant.DEAULT_PAGE_SIZE);
                LOGGER.info(officePager);
                session.setAttribute("result",officePager);
                return "success";
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

    @Action(value = "add",results = {
            @Result(name = "success",location = "success.jsp"),
            @Result(name = "failure",location = "failure.jsp")
    })
    public String office_add(){
        try {
            if(StrUtil.isNotBlank((String) session.getAttribute("h_account"))){
                if(BeanUtil.nonNull(officeModel)){
                    LOGGER.info(officeModel);
                    officeService.save(officeModel);
                    return "success";
                }else{
                    LOGGER.warn("参数为 null");
                    session.setAttribute("errorMsg","参数为 null");
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

    @Action(value = "delete",results = {
            @Result(name = "success",location = "success.jsp"),
            @Result(name = "failure",location = "failure.jsp")
    })
    public String office_delete(){
        try {
            if(StrUtil.isNotBlank((String) session.getAttribute("h_account"))){
                String oidString = request.getParameter("oid");
                if(StrUtil.isNum(oidString)){
                    int oid = Integer.parseInt(oidString);
                    LOGGER.info(oid);
                    officeService.delete(oid);
                    return "success";
                }else{
                    LOGGER.warn("非法的输入");
                    session.setAttribute("errorMsg","非法的输入");
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

    @Action(value = "update",results = {
            @Result(name = "success",location = "success.jsp"),
            @Result(name = "failure",location = "failure.jsp")
    })
    public String office_update_step1(){
        try {
            if(StrUtil.isNotBlank((String) session.getAttribute("h_account"))){
                String oidString = request.getParameter("oid");
                if(StrUtil.isNum(oidString)){
                    int oid = Integer.parseInt(oidString);
                    Office office = officeService.get(oid);
                    LOGGER.info(office);
                    session.setAttribute("office",office);
                    return "success";
                }else{
                    LOGGER.warn("非法的输入");
                    session.setAttribute("errorMsg","非法的输入");
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

    @Action(value = "save",results = {
            @Result(name = "success",location = "success.jsp"),
            @Result(name = "failure",location = "failure.jsp")
    })
    public String office_update_step2(){
        try {
            if(StrUtil.isNotBlank((String) session.getAttribute("h_account"))){
                if(BeanUtil.nonNull(officeModel)){
                    LOGGER.info(officeModel);
                    officeService.saveOrUpdate(officeModel);
                    return "success";
                }else{
                    LOGGER.warn("参数为 null");
                    session.setAttribute("errorMsg","参数为 null");
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

    public Office getModel() {
        return officeModel;
    }
}
