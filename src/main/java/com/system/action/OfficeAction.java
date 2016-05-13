package com.system.action;

import com.opensymphony.xwork2.ModelDriven;
import com.system.entity.Hospital;
import com.system.entity.Office;
import com.system.entity.Pager;
import com.system.enums.Constant;
import com.system.service.HospitalService;
import com.system.service.OfficeService;
import com.system.util.StrUtil;
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
public class OfficeAction extends SuperAction implements ModelDriven<Office>{

    //用于接受查询条件
    private Office officeModel = new Office();

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
            String pageNumString = request.getParameter("pageNum");
            int pageNum = 1;//设置默认页数
            if(StrUtil.isNum(pageNumString)){//如果是非法是字符串，则使用默认页数
                pageNum = Integer.parseInt(pageNumString);
            }
            Pager<Office> officePager = officeService.findOffice(officeModel,pageNum, Constant.DEAULT_PAGE_SIZE);
            LOGGER.info(officePager);
            session.setAttribute("result",officePager);
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
            String oidString = request.getParameter("oid");
            if(StrUtil.isNum(oidString)){
                int oid = Integer.parseInt(oidString);
                Office office = officeService.get(oid);
                LOGGER.info(office);
                session.setAttribute("office",office);
                Hospital hospital = hospitalService.get(office.getHid());
                LOGGER.info(hospital);
                session.setAttribute("hospital",hospital);
                return "success";
            }else{
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
