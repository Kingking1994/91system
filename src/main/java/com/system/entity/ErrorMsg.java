package com.system.entity;

import java.io.Serializable;

/**
 * 错误信息类
 * Created by king on 2016/5/25.
 */
public class ErrorMsg implements Serializable{

    public int code;

    public String message;

    public ErrorMsg(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ErrorMsg() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorMsg{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
