package com.system.action;

import com.system.entity.Doctor;
import com.system.service.DoctorService;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by king on 2016/5/4.
 */
@Namespace("/doctors")
public class DoctorAction extends SuperAction {

    private static final Logger LOGGER = Logger.getLogger(DoctorAction.class);

    @Autowired
    private DoctorService doctorService;


    @Action(value = "list",results = {
            @Result(name = "success",location = "../success.jsp"),
            @Result(name = "failure",location = "../failure.jsp")
    })
    public String doctorList(){
        try{
            List<Doctor> doctorList = doctorService.findAll();
            LOGGER.info(doctorList);
            session.setAttribute("doctorList",doctorList);
            return "success";
        }catch (Exception e){
            LOGGER.error(e);
            return "failure";
        }
    }


    @Action(value = "info",results = {
            @Result(name = "success",location = "../success.jsp"),
            @Result(name = "failure",location = "../failure.jsp")
    })
    public String doctorInfo(){
        try {
            int did = Integer.parseInt(request.getParameter("did"));
            Doctor doctor = doctorService.get(did);
            LOGGER.info(doctor);
            session.setAttribute("doctor",doctor);
            return "success";
        }catch (Exception e){
            LOGGER.error(e);
            return "failure";
        }
    }
}
