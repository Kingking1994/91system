package com.system.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

/**
 * Created by king on 2016/4/20.
 */
@Entity
@Table(name = "userinfo",catalog = "91system")
public class UserInfo implements Serializable {

    @Id
    @Column(name = "uiid")
    @GeneratedValue
    private int uiid;

    @Column(name = "phone",length = 11,nullable = false,unique = true)
    private String phone;

    @Column(name = "name",length = 10,nullable = false)
    private String name;

    @Column(name = "gender",nullable = false)
    private int gender;

    @Column(name = "birthday",nullable = false)
    private Date birthday;

    @Column(name = "idcard",length = 32,nullable = false)
    private String idcard;

    @Column(name = "email",length = 32)
    private String email;

    @Column(name = "address",length = 128)
    private String address;

    @Column(name = "blood")
    private int blood;

    @Column(name = "married")
    private int married;

    @Column(name = "career",length = 32)
    private String career;

    @OneToOne(mappedBy = "userInfo")
    private Wallet wallet;

    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    @JoinColumn(name = "uiid")
    private Set<OrderItem> orderItemSet;

    @OneToOne(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    @JoinColumn(name = "uid",unique = true)
    private User user;

    public UserInfo() {
    }

    public UserInfo(String phone, String name, int gender, Date birthday, String idcard) {
        this.phone = phone;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.idcard = idcard;
    }

    public int getUiid() {
        return uiid;
    }

    public void setUiid(int uiid) {
        this.uiid = uiid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public int getMarried() {
        return married;
    }

    public void setMarried(int married) {
        this.married = married;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Set<OrderItem> getOrderItemSet() {
        return orderItemSet;
    }

    public void setOrderItemSet(Set<OrderItem> orderItemSet) {
        this.orderItemSet = orderItemSet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "uiid=" + uiid +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", idcard='" + idcard + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", blood=" + blood +
                ", married=" + married +
                ", career='" + career + '\'' +
                '}';
    }
}
