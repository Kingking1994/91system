package com.system.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by king on 2016/4/20.
 */
@Entity
@Table(name = "doctor",catalog = "91system")
public class Doctor implements Serializable {

    @Id
    @Column(name = "did")
    @GeneratedValue
    private int did;

    @Column(name = "name",nullable = false,length = 10)
    private String name;

    @Column(name = "gender",nullable = false)
    private int gender;

    @Column(name = "title",nullable = false)
    private int title;

    @Column(name = "path")
    private String path;

    @Column(name = "goodat")
    private String goodat;

    @Column(name = "intro")
    private String intro;

    @Column(name = "oid",nullable = false)
    private int oid;

    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinColumn(name = "did")
    private Set<Schedule> scheduleSet;

    public Doctor() {
    }

    public Doctor(String name, int gender, int title) {
        this.name = name;
        this.gender = gender;
        this.title = title;
    }

    public Doctor(String name, int gender, int title, String path, String goodat, String intro) {
        this.name = name;
        this.gender = gender;
        this.title = title;
        this.path = path;
        this.goodat = goodat;
        this.intro = intro;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
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

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getGoodat() {
        return goodat;
    }

    public void setGoodat(String goodat) {
        this.goodat = goodat;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public Set<Schedule> getScheduleSet() {
        return scheduleSet;
    }

    public void setScheduleSet(Set<Schedule> scheduleSet) {
        this.scheduleSet = scheduleSet;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "oid=" + oid +
                ", did=" + did +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", title=" + title +
                ", path='" + path + '\'' +
                ", goodat='" + goodat + '\'' +
                ", intro='" + intro + '\'' +
                '}';
    }
}
