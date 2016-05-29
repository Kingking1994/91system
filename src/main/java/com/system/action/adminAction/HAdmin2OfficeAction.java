package com.system.action.adminAction;

import com.opensymphony.xwork2.ModelDriven;
import com.system.action.SuperAction;
import com.system.entity.ErrorMsg;
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
@Namespace("/hAdmin")
public class HAdmin2OfficeAction extends SuperAction implements ModelDriven<Office>{

    private Office officeModel = new Office();

    private static final Logger LOGGER = Logger.getLogger(HAdmin2OfficeAction.class);

    @Autowired
    private OfficeService officeService;


    @Action(value = "office_list",results = {
            @Result(name = "success",location = "../a_h_o_list.jsp"),
            @Result(name = "failure",location = "../a_h_errorMsg.jsp")
    })
    public String office_list(){
        try {
            if(StrUtil.isNotBlank((String) session.getAttribute("h_account"))){
                String pageNumString = request.getParameter("pageNum");
                int pageNum = 1;//设置默认页数
                if(StrUtil.isNum(pageNumString)){//如果是非法是字符串，则使用默认页数
                    pageNum = Integer.parseInt(pageNumString);
                }
                officeModel.setHid((Integer)session.getAttribute("hid"));//找到该医院下的所有科室
                Pager<Office> officePager = officeService.findOffice(officeModel,pageNum, Constant.DEAULT_PAGE_SIZE);
                LOGGER.info(officePager);
                session.setAttribute("result",officePager);
                return "success";
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

    @Action(value = "office_delete",results = {
            @Result(name = "success",location = "/hAdmin/office_list",type = "redirect"),
            @Result(name = "failure",location = "../a_h_errorMsg.jsp")
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
                    session.setAttribute("errorMsg",new ErrorMsg(101,"非法的参数输入"));
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

    @Action(value = "office_update",results = {
            @Result(name = "success",location = "../a_h_o_detail.jsp"),
            @Result(name = "failure",location = "../a_h_errorMsg.jsp")
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
                    session.setAttribute("errorMsg",new ErrorMsg(101,"非法的参数输入"));
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

    @Action(value = "office_save",results = {
            @Result(name = "success",location = "/hAdmin/office_list",type = "redirect"),
            @Result(name = "failure",location = "../a_h_errorMsg.jsp")
    })
    public String office_update_step2(){
        try {
            if(StrUtil.isNotBlank((String) session.getAttribute("h_account"))){
                if(BeanUtil.nonNull(officeModel)){
                    LOGGER.info(officeModel);
                    if(officeModel.getOid() == 0){
                        officeModel.setHid((Integer) session.getAttribute("hid"));
                        officeService.save(officeModel);
                    }else {
                        officeService.saveOrUpdate(officeModel);
                    }
                    return "success";
                }else{
                    LOGGER.warn("参数为 null");
                    session.setAttribute("errorMsg",new ErrorMsg(101,"非法的参数输入"));
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

    public Office getModel() {
        return officeModel;
    }
}
