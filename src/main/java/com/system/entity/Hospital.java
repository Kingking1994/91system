package com.system.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by king on 2016/4/20.
 */
@Entity
@Table(name = "hospital",catalog = "91system")
public class Hospital implements Serializable{


    @Id
    @Column(name = "hid")
    private int hid;

    @Column(name = "name",nullable = false,length = 64)
    private String name;

    @Column(name = "address",nullable = false,length = 128)
    private String address;

    @Column(name = "telephone",nullable = false,length = 32)
    private String telephone;

    @Column(name = "intro" , length = 255)
    private String intro;

    @Column(name = "quality")
    private int quality;

    @Column(name = "region")
    private int region;

    @Column(name = "level")
    private int level;

    @Column(name = "type")
    private int type;

    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    @JoinColumn(name = "hid")
    private Set<Office> officeSet;

    public Hospital() {
    }

    public Hospital(String name, String address, String telephone) {
        this.name = name;
        this.address = address;
        this.telephone = telephone;
    }

    public Hospital(String name, String address, String telephone, String intro, int quality, int region, int level, int type) {
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.intro = intro;
        this.quality = quality;
        this.region = region;
        this.level = level;
        this.type = type;
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "hid=" + hid +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", intro='" + intro + '\'' +
                ", quality=" + quality +
                ", region=" + region +
                ", level=" + level +
                ", type=" + type +
                '}';
    }
}
