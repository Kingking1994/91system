package com.system.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

/**
 * Created by king on 2016/4/20.
 */
@Entity
@Table(name = "schedule",catalog = "91system")
public class Schedule implements Serializable {

    @Id
    @Column(name = "sid")
    @GeneratedValue
    private int sid;

    @Column(name = "date",nullable = false)
    private Date date;

    @Column(name = "time",nullable = false)
    private int time;

    @Column(name = "num",nullable = false)
    private int num;

    @Column(name = "ordernum",nullable = false)
    private int ordernum;

    @Column(name = "fee",nullable = false)
    private double fee;

    @Column(name = "did",nullable = false)
    private int did;

    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinColumn(name = "sid")
    private Set<OrderItem> orderItemSet;


    public Schedule() {
    }

    public Schedule(Date date, int time, int num, int ordernum, double fee) {
        this.date = date;
        this.time = time;
        this.num = num;
        this.ordernum = ordernum;
        this.fee = fee;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(int ordernum) {
        this.ordernum = ordernum;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }


    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public Set<OrderItem> getOrderItemSet() {
        return orderItemSet;
    }

    public void setOrderItemSet(Set<OrderItem> orderItemSet) {
        this.orderItemSet = orderItemSet;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "did=" + did +
                ", sid=" + sid +
                ", date=" + date +
                ", time=" + time +
                ", num=" + num +
                ", ordernum=" + ordernum +
                ", fee=" + fee +
                '}';
    }
}
