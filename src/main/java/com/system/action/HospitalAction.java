package com.system.action;

import com.opensymphony.xwork2.ModelDriven;
import com.system.entity.Hospital;
import com.system.entity.Office;
import com.system.entity.Pager;
import com.system.enums.Constant;
import com.system.service.HospitalService;
import com.system.util.BeanUtil;
import com.system.util.CollectionUtil;
import com.system.util.StrUtil;
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
public class HospitalAction extends SuperAction implements ModelDriven<Hospital>{

    //用于接受查询条件
    private Hospital hospitalModel = new Hospital();


    private static final Logger LOGGER = Logger.getLogger(HospitalAction.class);

    @Autowired
    private HospitalService hospitalService;


    @Action(value = "list",results = {
            @Result(name = "success",location = "../success.jsp"),
            @Result(name = "failure",location = "../failure.jsp")
    })
    public String hospitalList(){
        try {
            String pageNumString = request.getParameter("pageNum");
            if(StrUtil.isNum(pageNumString)){
                int pageNum = Integer.parseInt(pageNumString);
                Pager<Hospital> hospitalPager = hospitalService.findHospital(hospitalModel,pageNum, Constant.DEAULT_PAGE_SIZE);
                LOGGER.info(hospitalPager);
                session.setAttribute("result",hospitalPager);
                return "success";
            }else {
                return "failure";
            }
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
            String hidString = request.getParameter("hid");
            if(StrUtil.isNum(hidString)){
                int hid = Integer.parseInt(hidString);
                Hospital hospital = hospitalService.get(hid);
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


    public Hospital getModel() {
        return hospitalModel;
    }
}
