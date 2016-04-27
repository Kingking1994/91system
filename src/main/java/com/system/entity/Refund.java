package com.system.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by king on 2016/4/21.
 */
@Entity
@Table(name = "refund",catalog = "91system")
public class Refund implements Serializable{

    @Id
    @Column(name = "rid")
    @GeneratedValue
    private int rid;

    @Column(name = "apply",nullable = false)
    private Timestamp apply;

    @Column(name = "amount",nullable = false)
    private double amount;

    @Column(name = "status",nullable = false)
    private int status;

    @Column(name = "completed")
    private Timestamp completed;

    @Column(name = "wid" ,nullable = false)
    private int wid;

    @ManyToOne(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    @JoinColumn(name = "oiid")
    private OrderItem orderItem;

    public Refund() {
    }

    public Refund(Timestamp apply, double amount, int status) {
        this.apply = apply;
        this.amount = amount;
        this.status = status;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public Timestamp getApply() {
        return apply;
    }

    public void setApply(Timestamp apply) {
        this.apply = apply;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getCompleted() {
        return completed;
    }

    public void setCompleted(Timestamp completed) {
        this.completed = completed;
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
        return "Refund{" +
                "wid=" + wid +
                ", rid=" + rid +
                ", apply=" + apply +
                ", amount=" + amount +
                ", status=" + status +
                ", completed=" + completed +
                '}';
    }
}
