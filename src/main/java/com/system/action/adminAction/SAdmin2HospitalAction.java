package com.system.action.adminAction;

import com.opensymphony.xwork2.ModelDriven;
import com.system.action.SuperAction;
import com.system.entity.ErrorMsg;
import com.system.entity.Hospital;
import com.system.entity.Pager;
import com.system.enums.Constant;
import com.system.service.HospitalService;
import com.system.service.SAdminService;
import com.system.util.BeanUtil;
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
public class SAdmin2HospitalAction extends SuperAction implements ModelDriven<Hospital>{

    private Hospital hospitalModel = new Hospital();

    private static final Logger LOGGER = Logger.getLogger(SAdmin2HospitalAction.class);

    @Autowired
    private HospitalService hospitalService;


    @Action(value = "hospital_list",results = {
            @Result(name = "success",location = "../a_s_h_list.jsp"),
            @Result(name = "failure",location = "../a_s_errorMsg.jsp")
    })
    public String hospital_list(){
        try {
            if(StrUtil.isNotBlank((String) session.getAttribute("s_account"))){
                String pageNumString = request.getParameter("pageNum");
                int pageNum = 1;//设置默认页数
                if(StrUtil.isNum(pageNumString)){//如果是非法是字符串，则使用默认页数
                    pageNum = Integer.parseInt(pageNumString);
                }
                Pager<Hospital> hospitalPager = hospitalService.findHospital(hospitalModel,pageNum, Constant.DEAULT_PAGE_SIZE);
                LOGGER.info(hospitalPager);
                session.setAttribute("result",hospitalPager);
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

    @Action(value = "hospital_delete",results = {
            @Result(name = "success",location = "/sAdmin/hospital_list" , type = "redirect"),
            @Result(name = "failure",location = "../a_s_errorMsg.jsp")
    })
    public String hospital_delete(){
        try {
            if(StrUtil.isNotBlank((String) session.getAttribute("s_account"))){
                String hidString  = request.getParameter("hid");
                if(StrUtil.isNum(hidString)){
                    int hid = Integer.parseInt(hidString);
                    LOGGER.info(hid);
                    hospitalService.delete(hid);
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


    @Action(value = "hospital_update",results = {
            @Result(name = "success",location = "../a_s_h_detail.jsp"),
            @Result(name = "failure",location = "../a_s_errorMsg.jsp")
    })
    public String hospital_update_step1(){
        try {
            if(StrUtil.isNotBlank((String) session.getAttribute("s_account"))){
                String hidString  = request.getParameter("hid");
                if(StrUtil.isNum(hidString)){
                    int hid = Integer.parseInt(hidString);
                    Hospital hospital = hospitalService.get(hid);
                    LOGGER.info(hospital);
                    session.setAttribute("hospital",hospital);
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


    @Action(value = "hospital_save",results = {
            @Result(name = "success",location = "/sAdmin/hospital_list" , type = "redirect"),
            @Result(name = "failure",location = "../a_s_errorMsg.jsp")
    })
    public String hospital_update_step2(){
        try {
            if(StrUtil.isNotBlank((String) session.getAttribute("s_account"))){
                if(BeanUtil.nonNull(hospitalModel)){
                    LOGGER.info(hospitalModel);
                    if(hospitalModel.getHid() == 0){
                        hospitalService.save(hospitalModel);
                    }else{
                        hospitalService.saveOrUpdate(hospitalModel);
                    }
                    return "success";
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

    public Hospital getModel() {
        return hospitalModel;
    }
}
