package com.system.enums;

/**
 * Created by king on 2016/4/22.
 */
public enum HospitalRegionEnum {


    /**
     * 海珠区
     */
    HAIZHU("海珠区",1),

    /**
     * 荔湾区
     */
    LIWAN("荔湾区",2),

    /**
     * 天河区
     */
    TIANHE("天河区",3),

    /**
     * 番禺区
     */
    PANYU("番禺区",4),

    /**
     * 白云区
     */
    BAIYUN("白云区",5),

    /**
     * 黄浦区
     */
    HUANGPU("黄浦区",6),

    /**
     * 花都区
     */
    HUADU("花都区",7),

    /**
     * 增城区
     */
    ZENGCHENG("增城区",8),

    /**
     * 越秀区
     */
    YUEXIU("越秀区",9),

    /**
     * 其他
     */
    QITA("其他",0)


    ;


    private String name;
    private int index;

    HospitalRegionEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public String toString() {
        return "HospitalRegionEnum{" +
                "name='" + name + '\'' +
                ", index=" + index +
                '}';
    }
}
