package com.system.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

/**
 *
 * 系统访问首页
 * Created by king on 2016/5/25.
 */
@Namespace("/home")
public class WelcomeAction extends SuperAction {

    @Action(value = "welcomeUser" ,results = {
            @Result(name = "success",location = "../login.jsp")
    })
    public String welcomeUser(){
        return "success";
    }
}
