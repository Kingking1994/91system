package com.system.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by king on 2016/5/15.
 */
@Entity
@Table(name = "sadmin",catalog = "91system")
public class SAdmin implements Serializable {

    @Id
    @Column(name = "said")
    @GeneratedValue
    private int said;

    @Column(name = "account", length = 10 , nullable = false ,unique = true)
    private String account;

    @Column(name = "password", length = 16 , nullable = false)
    private String password;

    @Column(name = "isroot", nullable = false)
    private int isroot;

    public SAdmin() {
    }

    public SAdmin(String account, String password, int isroot) {
        this.account = account;
        this.password = password;
        this.isroot = isroot;
    }

    public int getSaid() {
        return said;
    }

    public void setSaid(int said) {
        this.said = said;
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

    public int getIsroot() {
        return isroot;
    }

    public void setIsroot(int isroot) {
        this.isroot = isroot;
    }

    @Override
    public String toString() {
        return "SAdmin{" +
                "said=" + said +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", isroot=" + isroot +
                '}';
    }
}
