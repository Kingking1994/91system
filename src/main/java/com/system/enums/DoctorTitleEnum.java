package com.system.enums;

/**
 * Created by king on 2016/4/22.
 */
public enum DoctorTitleEnum {

    /**
     * 主任医师
     */
    ZHUREN("主任医师",0),

    /**
     * 副主任医师
     */
    FUZHUREN("副主任医师",1),

    /**
     * 主治医生
     */
    ZHUZHI("主治医生",2)

    ;
    private String name;
    private int index;

    DoctorTitleEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public String toString() {
        return "DoctorTitleEnum{" +
                "name='" + name + '\'' +
                ", index=" + index +
                '}';
    }
}
