package com.system.action;

import com.system.entity.Hospital;
import com.system.entity.Office;
import com.system.service.HospitalService;
import com.system.service.OfficeService;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by king on 2016/4/27.
 */
@Namespace("/offices")
public class OfficeAction extends SuperAction {

    private int oid;

    private static final Logger LOGGER = Logger.getLogger(OfficeAction.class);

    @Autowired
    private HospitalService hospitalService;

    @Autowired
    private OfficeService officeService;

    @Action(value = "list",results = {
            @Result(name = "success",location = "../success.jsp"),
            @Result(name = "failure",location = "../failure.jsp")
    })
    public String officeList(){
        try {
            List<Office> officeList = officeService.findAll();
            LOGGER.info(officeList);
            session.setAttribute("officeList",officeList);
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
    public String officeInfo(){
        try {
            Office office = officeService.get(oid);
            LOGGER.info(office);
            session.setAttribute("office",office);
            Hospital hospital = hospitalService.get(office.getHid());
            LOGGER.info(hospital);
            session.setAttribute("hospital",hospital);
            return "success";
        }catch (Exception e){
            LOGGER.error(e);
            return "failure";
        }
    }


    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }
}
