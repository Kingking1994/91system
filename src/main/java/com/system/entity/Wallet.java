package com.system.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by king on 2016/4/21.
 */
@Entity
@Table(name = "wallet",catalog = "91system")
public class Wallet implements Serializable {

    @Id
    @Column(name = "wid")
    @GeneratedValue
    private int wid;

    @Column(name = "account",nullable = false)
    private double account;

    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinColumn(name = "wid")
    private Set<Trade> tradeSet;

    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinColumn(name = "wid")
    private Set<Refund> refundSet;

    @OneToOne(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    @JoinColumn(name = "uiid",unique = true)
    private UserInfo userInfo;


    public Wallet() {
    }

    public Wallet(double account) {
        this.account = account;
    }

    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }

    public Set<Trade> getTradeSet() {
        return tradeSet;
    }

    public void setTradeSet(Set<Trade> tradeSet) {
        this.tradeSet = tradeSet;
    }

    public Set<Refund> getRefundSet() {
        return refundSet;
    }

    public void setRefundSet(Set<Refund> refundSet) {
        this.refundSet = refundSet;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "wid=" + wid +
                ", account=" + account +
                '}';
    }
}
