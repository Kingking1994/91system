package com.system.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by king on 2016/4/20.
 */
@Entity
@Table(name = "user",catalog = "91system")
public class User implements Serializable {

    @Id
    @Column(name = "uid")
    private int uid;

    @Column(name = "phone",length = 11,nullable = false,unique = true)
    private String phone;

    @Column(name = "password",length = 16,nullable = false)
    private String password;

    @Column(name = "identified",nullable = false)
    private int identified;

    @OneToOne(mappedBy = "user")
    private UserInfo userInfo;

    public User() {
    }

    public User(String phone, String password, int identified) {
        this.phone = phone;
        this.password = password;
        this.identified = identified;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdentified() {
        return identified;
    }

    public void setIdentified(int identified) {
        this.identified = identified;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "User{" +
                "identified=" + identified +
                ", uid=" + uid +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
