package com.system.action;

import com.system.entity.Hospital;
import com.system.entity.Office;
import com.system.service.HospitalService;
import com.system.util.BeanUtil;
import com.system.util.CollectionUtil;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

/**
 * Created by king on 2016/4/27.
 */
@Namespace("/hospitals")
public class HospitalAction extends SuperAction {

    private static final Logger LOGGER = Logger.getLogger(HospitalAction.class);

    @Autowired
    private HospitalService hospitalService;


    @Action(value = "list",results = {
            @Result(name = "success",location = "../success.jsp"),
            @Result(name = "failure",location = "../failure.jsp")
    })
    public String hospitalList(){
        try {
            List<Hospital> hospitalList = hospitalService.findAll();
            LOGGER.info(hospitalList);
            session.setAttribute("hospitalList",null);
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
    public String hospitalInfo(){
        try{
            int hid = Integer.parseInt(request.getParameter("hid"));
            Hospital hospital = hospitalService.get(hid);
            LOGGER.info(hospital);
            session.setAttribute("hospital",hospital);
            return "success";
        }catch (Exception e){
            LOGGER.error(e);
            return "failure";
        }
    }

}
