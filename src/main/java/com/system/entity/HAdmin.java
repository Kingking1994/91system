package com.system.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by king on 2016/5/15.
 */
@Entity
@Table(name = "hadmin",catalog = "91system")
public class HAdmin implements Serializable {

    @Id
    @Column(name = "haid")
    @GeneratedValue
    private int haid;

    @Column(name = "account", length = 10 , nullable = false , unique = true)
    private String account;

    @Column(name = "password", length = 16 , nullable = false)
    private String password;

    @Column(name = "hid" , nullable = false)
    private int hid;

    public HAdmin() {
    }

    public HAdmin(String account, String password, int hid) {
        this.account = account;
        this.password = password;
        this.hid = hid;
    }

    public int getHaid() {
        return haid;
    }

    public void setHaid(int haid) {
        this.haid = haid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    @Override
    public String toString() {
        return "HAdmin{" +
                "haid=" + haid +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", hid=" + hid +
                '}';
    }
}
