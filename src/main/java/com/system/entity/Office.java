package com.system.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by king on 2016/4/20.
 */

@Entity
@Table(name = "office",catalog = "91system")
public class Office implements Serializable {

    @Id
    @Column(name = "oid")
    private int oid;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "type")
    private int type;

    @Column(name = "level")
    private int level;

    @Column(name = "hid",nullable = false)
    private int hid;

    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinColumn(name = "oid")
    private Set<Doctor> doctorSet;

    public Office() {
    }

    public Office(String name, int type, int level) {
        this.name = name;
        this.type = type;
        this.level = level;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public Set<Doctor> getDoctorSet() {
        return doctorSet;
    }

    public void setDoctorSet(Set<Doctor> doctorSet) {
        this.doctorSet = doctorSet;
    }

    @Override
    public String toString() {
        return "Office{" +
                "hid=" + hid +
                ", oid=" + oid +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", level=" + level +
                '}';
    }
}
