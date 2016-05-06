package com.system.enums;

/**
 *
 * Created by king on 2016/4/22.
 */
public enum HospitalQualityEnum {

    /**
     * 公立医院
     */
    GONGLI("公立医院",0),

    /**
     * 私立医院
     */
    SILI("私立医院",1);

    public String name;
    public int index;

    HospitalQualityEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public String toString() {
        return "HospitalQualityEnum{" +
                "name='" + name + '\'' +
                ", index=" + index +
                '}';
    }
}
