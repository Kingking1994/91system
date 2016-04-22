package com.system.enums;

/**
 * Created by king on 2016/4/22.
 */
public enum HospitalLevelEnum {

    /**
     * 其他
     */
    QITA(0),

    /**
     * 特等
     */
    TEDENG(1),

    /**
     * 三甲
     */
    SANJIA(2),

    /**
     * 三级
     */
    SANJI(3),

    /**
     * 二级
     */
    ERJI(4),

    /**
     * 一级
     */
    YIJI(5)


    ;
    int value;

    HospitalLevelEnum(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "HospitalLevelEnum{" +
                "value=" + value +
                '}';
    }
}
