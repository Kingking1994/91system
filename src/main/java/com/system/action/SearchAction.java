package com.system.action;


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


/**
 * Created by king on 2016/5/13.
 */
@Namespace("/search")
public class SearchAction extends SuperAction {

    private String searchString;

    private static final Logger LOGGER = Logger.getLogger(SearchAction.class);

    @Autowired
    private HospitalService hospitalService;

    @Autowired
    private OfficeService officeService;

    @Autowired
    private DoctorService doctorService;


    @Action(value = "all" ,results = {
            @Result(name = "success",location = "success.jsp"),
            @Result(name = "failure",location = "failure.jsp")
    })
    public String search(){
        try {
            if(StrUtil.isNotBlank(searchString)){
                int recordNum = 4;//显示记录条数

                Hospital h = new Hospital();
                h.setName(searchString);
                Pager<Hospital> hospitalPager = hospitalService.findHospital(h,1,recordNum);
                LOGGER.info(hospitalPager);

                Office o = new Office();
                o.setName(searchString);
                Pager<Office> officePager = officeService.findOffice(o,1,recordNum);
                LOGGER.info(officePager);

                Doctor d = new Doctor();
                d.setName(searchString);
                Pager<Doctor> doctorPager = doctorService.findDoctor(d,1,recordNum);
                LOGGER.info(doctorPager);

                session.setAttribute("hospitalPager",hospitalPager);
                session.setAttribute("officePager",officePager);
                session.setAttribute("doctorPager",doctorPager);
                return "success";
            }else{
                return "failure";
            }
        }catch (Exception e){
            LOGGER.error(e);
            return "failure";
        }
    }


    @Action(value = "hospitals" ,results = {
            @Result(name = "success",location = "success.jsp"),
            @Result(name = "failure",location = "failure.jsp")
    })
    public String search_Hospital_more(){
        try {
            String pageNumString = request.getParameter("pageNum");
            int pageNum = 1;//设置默认页数
            if(StrUtil.isNum(pageNumString)){//如果是非法是字符串，则使用默认页数
                pageNum = Integer.parseInt(pageNumString);
            }
            Hospital h = new Hospital();
            h.setName(searchString);
            Pager<Hospital> hospitalPager = hospitalService.findHospital(h,pageNum, Constant.DEAULT_PAGE_SIZE);
            LOGGER.info(hospitalPager);

            session.setAttribute("result",hospitalPager);
            return "success";
        }catch (Exception e){
            LOGGER.error(e);
            return "failure";
        }
    }

    @Action(value = "offices" ,results = {
            @Result(name = "success",location = "success.jsp"),
            @Result(name = "failure",location = "failure.jsp")
    })
    public String search_Office_more(){
        try {
            String pageNumString = request.getParameter("pageNum");
            int pageNum = 1;//设置默认页数
            if(StrUtil.isNum(pageNumString)){//如果是非法是字符串，则使用默认页数
                pageNum = Integer.parseInt(pageNumString);
            }
            Office o = new Office();
            o.setName(searchString);
            Pager<Office> officePager = officeService.findOffice(o, pageNum, Constant.DEAULT_PAGE_SIZE);
            LOGGER.info(officePager);

            session.setAttribute("result",officePager);
            return "success";
        }catch (Exception e){
            LOGGER.error(e);
            return "failure";
        }
    }

    @Action(value = "doctors" ,results = {
            @Result(name = "success",location = "success.jsp"),
            @Result(name = "failure",location = "failure.jsp")
    })
    public String search_Doctor_more(){
        try {
            String pageNumString = request.getParameter("pageNum");
            int pageNum = 1;//设置默认页数
            if(StrUtil.isNum(pageNumString)){//如果是非法是字符串，则使用默认页数
                pageNum = Integer.parseInt(pageNumString);
            }
            Doctor d = new Doctor();
            d.setName(searchString);
            Pager<Doctor> doctorPager = doctorService.findDoctor(d, pageNum, Constant.DEAULT_PAGE_SIZE);
            LOGGER.info(doctorPager);

            session.setAttribute("result",doctorPager);
            return "success";
        }catch (Exception e){
            LOGGER.error(e);
            return "failure";
        }
    }


    @Action(value = "test" ,results = {
            @Result(name = "success",location = "success.jsp"),
            @Result(name = "failure",location = "failure.jsp")
    })
    public String test(){
        LOGGER.info(session);
        LOGGER.info(application);
        return "success";
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }
}
