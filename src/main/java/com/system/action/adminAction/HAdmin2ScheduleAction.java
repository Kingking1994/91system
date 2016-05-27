package com.system.action.adminAction;

import com.opensymphony.xwork2.ModelDriven;
import com.system.action.SuperAction;
import com.system.entity.Hospital;
import com.system.entity.Pager;
import com.system.entity.Schedule;
import com.system.enums.Constant;
import com.system.service.HAdminService;
import com.system.service.HospitalService;
import com.system.service.ScheduleService;
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
@Namespace("/hAdmin")
public class HAdmin2ScheduleAction extends SuperAction implements ModelDriven<Schedule>{

    private Schedule scheduleModel = new Schedule();

    private static final Logger LOGGER = Logger.getLogger(HAdmin2ScheduleAction.class);

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private HospitalService hospitalService;

    @Action(value = "schedule_list",results = {
            @Result(name = "success",location = "../a_h_s_list.jsp"),
            @Result(name = "failure",location = "failure.jsp")
    })
    public String schedule_list(){
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


    @Action(value = "schedule_delete",results = {
            @Result(name = "success",location = "/hAdmin/schedule_list",type = "redirect"),
            @Result(name = "failure",location = "failure.jsp")
    })
    public String schedule_delete(){
        try {
            if(StrUtil.isNotBlank((String) session.getAttribute("h_account"))){
                String sidString = request.getParameter("sid");
                if(StrUtil.isNum(sidString)){
                    int sid = Integer.parseInt(sidString);
                    LOGGER.info(sid);
                    scheduleService.delete(sid);
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

    @Action(value = "schedule_update",results = {
            @Result(name = "success",location = "../a_h_s_detail.jsp"),
            @Result(name = "failure",location = "failure.jsp")
    })
    public String schedule_update_step1(){
        try {
            if(StrUtil.isNotBlank((String) session.getAttribute("h_account"))){
                String sidString = request.getParameter("sid");
                if(StrUtil.isNum(sidString)){
                    int sid = Integer.parseInt(sidString);
                    Schedule schedule = scheduleService.get(sid);
                    LOGGER.info(schedule);
                    session.setAttribute("schedule",schedule);
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

    @Action(value = "schedule_save",results = {
            @Result(name = "success",location = "/hAdmin/schedule_list",type = "redirect"),
            @Result(name = "failure",location = "failure.jsp")
    })
    public String schedule_update_step2(){
        try {
            if(StrUtil.isNotBlank((String) session.getAttribute("h_account"))){
                if(BeanUtil.nonNull(scheduleModel)){
                    LOGGER.info(scheduleModel);
                    if(scheduleModel.getSid() == 0){
                        scheduleService.save(scheduleModel);
                    }else{
                        scheduleService.saveOrUpdate(scheduleModel);
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

    public Schedule getModel() {
        return scheduleModel;
    }
}
