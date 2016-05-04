package com.system.action;

import com.system.entity.Office;
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

    private static final Logger LOGGER = Logger.getLogger(OfficeAction.class);

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
            int oid = Integer.parseInt(request.getParameter("oid"));
            Office office = officeService.get(oid);
            LOGGER.info(office);
            session.setAttribute("office",office);
            return "success";
        }catch (Exception e){
            LOGGER.error(e);
            return "failure";
        }
    }

}
