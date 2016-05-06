package com.system.enums;

/**
 * Created by king on 2016/4/22.
 */
public enum HospitalTypeEnum {

    /**
     * 其他
     */
    QITA("其他",0)


    ;

    public String name;
    public int index;

    HospitalTypeEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public String toString() {
        return "HospitalTypeEnum{" +
                "name='" + name + '\'' +
                ", index=" + index +
                '}';
    }
}
