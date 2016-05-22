package com.system.action;

import com.opensymphony.xwork2.ModelDriven;
import com.system.entity.Doctor;
import com.system.entity.Hospital;
import com.system.entity.Office;
import com.system.entity.Pager;
import com.system.enums.Constant;
import com.system.service.DoctorService;
import com.system.service.HospitalService;
import com.system.service.OfficeService;
import com.system.util.StrUtil;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created by king on 2016/5/4.
 */
@Namespace("/doctors")
public class DoctorAction extends SuperAction implements ModelDriven<Doctor>{

    private Doctor doctorModel = new Doctor();

    private static final Logger LOGGER = Logger.getLogger(DoctorAction.class);

    @Autowired
    private HospitalService hospitalService;

    @Autowired
    private OfficeService officeService;

    @Autowired
    private DoctorService doctorService;


    @Action(value = "list",results = {
            @Result(name = "success",location = "../doctor_list.jsp"),
            @Result(name = "failure",location = "../failure.jsp")
    })
    public String doctorList(){
        try{
            String pageNumString = request.getParameter("pageNum");
            int pageNum = 1;//设置默认页数
            if(StrUtil.isNum(pageNumString)){//如果是非法是字符串，则使用默认页数
                pageNum = Integer.parseInt(pageNumString);
            }
            Pager<Doctor> doctorPager = doctorService.findDoctor(doctorModel, pageNum, Constant.DEAULT_PAGE_SIZE);
            LOGGER.info(doctorPager);
            session.setAttribute("result",doctorPager);
            return "success";
        }catch (Exception e){
            LOGGER.error(e);
            return "failure";
        }
    }


    @Action(value = "info",results = {
            @Result(name = "success",location = "../doctor_info.jsp"),
            @Result(name = "failure",location = "../failure.jsp")
    })
    public String doctorInfo(){
        try {
            String didString = request.getParameter("did");
            if(StrUtil.isNum(didString)){
                int did = Integer.parseInt(didString);
                Doctor doctor = doctorService.get(did);
                LOGGER.info(doctor);
                session.setAttribute("doctor",doctor);
                Office office = officeService.get(doctor.getOid());
                LOGGER.info(office);
                session.setAttribute("office",office);
                Hospital hospital = hospitalService.get(office.getHid());
                LOGGER.info(hospital);
                session.setAttribute("hospital",hospital);
                Date today = new Date(System.currentTimeMillis());
                session.setAttribute("today",today);//方便页面对时间的比较
                return "success";
            }else{
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
