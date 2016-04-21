package com.system.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by king on 2016/4/21.
 */
@Entity
@Table(name = "trade",catalog = "91system")
public class Trade implements Serializable {

    @Id
    @Column(name = "tid")
    private int tid;

    @Column(name = "time",nullable = false)
    private Timestamp time;

    @Column(name = "amount",nullable = false)
    private double amount;

    @Column(name = "wid" ,nullable = false)
    private int wid;

    @OneToOne(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinColumn(name = "oiid",unique = true,nullable = false)
    private OrderItem orderItem;

    public Trade() {
    }

    public Trade(Timestamp time, double amount) {
        this.time = time;
        this.amount = amount;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "wid=" + wid +
                ", tid=" + tid +
                ", time=" + time +
                ", amount=" + amount +
                '}';
    }
}
