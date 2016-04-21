package com.system.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by king on 2016/4/21.
 */
@Embeddable
public class Patient implements Serializable {

    @Column(nullable = false)
    private String pname;

    @Column(nullable = false)
    private Date pbirthday;

    @Column(nullable = false)
    private int pgender;

    @Column(nullable = false)
    private String pphone;

    private String pinfo;

    public Patient() {
    }

    public Patient(String pname, Date pbirthday, int pgender, String pphone) {
        this.pname = pname;
        this.pbirthday = pbirthday;
        this.pgender = pgender;
        this.pphone = pphone;
    }

    public Patient(String pname, Date pbirthday, int pgender, String pphone, String pinfo) {
        this.pname = pname;
        this.pbirthday = pbirthday;
        this.pgender = pgender;
        this.pphone = pphone;
        this.pinfo = pinfo;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Date getPbirthday() {
        return pbirthday;
    }

    public void setPbirthday(Date pbirthday) {
        this.pbirthday = pbirthday;
    }

    public int getPgender() {
        return pgender;
    }

    public void setPgender(int pgender) {
        this.pgender = pgender;
    }

    public String getPphone() {
        return pphone;
    }

    public void setPphone(String pphone) {
        this.pphone = pphone;
    }

    public String getPinfo() {
        return pinfo;
    }

    public void setPinfo(String pinfo) {
        this.pinfo = pinfo;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "pname='" + pname + '\'' +
                ", pbirthday=" + pbirthday +
                ", pgender=" + pgender +
                ", pphone='" + pphone + '\'' +
                ", pinfo='" + pinfo + '\'' +
                '}';
    }
}
