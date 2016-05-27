package com.system.action.adminAction;

import com.opensymphony.xwork2.ModelDriven;
import com.system.action.SuperAction;
import com.system.entity.Doctor;
import com.system.entity.Hospital;
import com.system.entity.Pager;
import com.system.enums.Constant;
import com.system.service.DoctorService;
import com.system.service.HAdminService;
import com.system.service.HospitalService;
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
public class HAdmin2DoctorAction extends SuperAction implements ModelDriven<Doctor>{

    private Doctor doctorModel = new Doctor();

    private static final Logger LOGGER = Logger.getLogger(HAdmin2DoctorAction.class);

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private HospitalService hospitalService;


    @Action(value = "doctor_list",results = {
            @Result(name = "success",location = "../a_h_d_list.jsp"),
            @Result(name = "failure",location = "failure.jsp")
    })
    public String doctor_list(){
        try {
            if(StrUtil.isNotBlank((String) session.getAttribute("h_account"))){
                Hospital hospital = hospitalService.get((Integer)session.getAttribute("hid"));
                LOGGER.info(hospital);
                session.setAttribute("result",hospital);
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



    @Action(value = "doctor_delete",results = {
            @Result(name = "success",location = "/hAdmin/doctor_list",type = "redirect"),
            @Result(name = "failure",location = "failure.jsp")
    })
    public String doctor_delete(){
        try {
            if(StrUtil.isNotBlank((String) session.getAttribute("h_account"))){
                String didString = request.getParameter("did");
                if(StrUtil.isNum(didString)){
                    int did = Integer.parseInt(didString);
                    LOGGER.info(did);
                    doctorService.delete(did);
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

    @Action(value = "doctor_update",results = {
            @Result(name = "success",location = "../a_h_d_detail.jsp"),
            @Result(name = "failure",location = "failure.jsp")
    })
    public String doctor_update_step1(){
        try {
            if(StrUtil.isNotBlank((String) session.getAttribute("h_account"))){
                String didString = request.getParameter("did");
                if(StrUtil.isNum(didString)){
                    int did = Integer.parseInt(didString);
                    Doctor doctor = doctorService.get(did);
                    LOGGER.info(doctor);
                    session.setAttribute("doctor",doctor);
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

    @Action(value = "doctor_save",results = {
            @Result(name = "success",location = "/hAdmin/doctor_list",type = "redirect"),
            @Result(name = "failure",location = "failure.jsp")
    })
    public String doctor_update_step2(){
        try {
            if(StrUtil.isNotBlank((String) session.getAttribute("h_account"))){
                if(BeanUtil.nonNull(doctorModel)){
                    LOGGER.info(doctorModel);
                    if(doctorModel.getDid() == 0){
                        doctorService.save(doctorModel);
                    }else{
                        doctorService.saveOrUpdate(doctorModel);
                    }
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

    public Doctor getModel() {
        return doctorModel;
    }
}
