package com.system.enums;

/**
 * Created by king on 2016/4/22.
 */
public enum HospitalRegionEnum {


    /**
     * 海珠区
     */
    HAIZHU(1),

    /**
     * 荔湾区
     */
    LIWAN(2),

    /**
     * 天河区
     */
    TIANHE(3),

    /**
     * 番禺区
     */
    PANYU(4),

    /**
     * 白云区
     */
    BAIYUN(5),

    /**
     * 黄浦区
     */
    HUANGPU(6),

    /**
     * 花都区
     */
    HUADU(7),

    /**
     * 增城区
     */
    ZENGCHENG(8),

    /**
     * 越秀区
     */
    YUEXIU(9),

    /**
     * 其他
     */
    QITA(0)


    ;



    int value;

    HospitalRegionEnum(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "HospitalRegionEnum{" +
                "value=" + value +
                '}';
    }
}
