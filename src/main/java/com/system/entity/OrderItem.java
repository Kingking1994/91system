package com.system.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * Created by king on 2016/4/21.
 */
@Entity
@Table(name = "orderitem",catalog = "91system")
public class OrderItem implements Serializable {

    @Id
    @GeneratedValue(generator = "oiid")
    @GenericGenerator(name = "oiid",strategy = "assigned")
    @Column(length = 32)
    private String oiid;

    @Column(name = "timing",nullable = false)
    private Time timing;

    @Embedded
    private Patient patient;

    @Column(name = "created",nullable = false)
    private Timestamp created;

    @Column(name = "payed")
    private Timestamp payed;

    @Column(name = "status",nullable = false)
    private int status;

    @Column(name = "sid",nullable = false)
    private int sid;

    @Column(name = "uiid",nullable = false)
    private int uiid;

    public OrderItem() {
    }

    public OrderItem(int status, Time timing, Patient patient, Timestamp created) {
        this.status = status;
        this.timing = timing;
        this.patient = patient;
        this.created = created;
    }

    public String getOiid() {
        return oiid;
    }

    public void setOiid(String oiid) {
        this.oiid = oiid;
    }

    public Time getTiming() {
        return timing;
    }

    public void setTiming(Time timing) {
        this.timing = timing;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getPayed() {
        return payed;
    }

    public void setPayed(Timestamp payed) {
        this.payed = payed;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getUiid() {
        return uiid;
    }

    public void setUiid(int uiid) {
        this.uiid = uiid;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "oiid='" + oiid + '\'' +
                ", timing=" + timing +
                ", patient=" + patient +
                ", created=" + created +
                ", payed=" + payed +
                ", status=" + status +
                ", sid=" + sid +
                ", uiid=" + uiid +
                '}';
    }
}
