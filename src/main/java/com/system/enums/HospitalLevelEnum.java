package com.system.enums;

/**
 * Created by king on 2016/4/22.
 */
public enum HospitalLevelEnum {

    /**
     * 其他
     */
    QITA("其他",0),

    /**
     * 特等
     */
    TEDENG("特等",1),

    /**
     * 三甲
     */
    SANJIA("三甲",2),

    /**
     * 三级
     */
    SANJI("三级",3),

    /**
     * 二级
     */
    ERJI("二级",4),

    /**
     * 一级
     */
    YIJI("一级",5)


    ;
    public String name;
    public int index;

    HospitalLevelEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public String toString() {
        return "HospitalLevelEnum{" +
                "name='" + name + '\'' +
                ", index=" + index +
                '}';
    }
}
