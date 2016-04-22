package com.system.enums;

/**
 *
 * Created by king on 2016/4/22.
 */
public enum HospitalQualityEnum {

    /**
     * 公立医院
     */
    GONGLI(0),

    /**
     * 私立医院
     */
    SILI(1);

    int value;

    HospitalQualityEnum(int value){ this.value = value; }

    @Override
    public String toString() {
        return "HospitalQualityEnum{" +
                "value=" + value +
                '}';
    }
}
