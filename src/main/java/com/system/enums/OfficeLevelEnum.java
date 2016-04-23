package com.system.enums;

/**
 * Created by king on 2016/4/22.
 */
public enum OfficeLevelEnum {

    /**
     * 普通
     */
    PUTONG("普通",0),

    /**
     * 国级
     */
    GUOJI("国级",1),

    /**
     * 省级
     */
    SHENGJI("省级",2),

    /**
     * 市级
     */
    SHIJI("市级",3),

    /**
     * 区级
     */
    QUJI("区级",4)

    ;
    private String name;
    private int index;

    OfficeLevelEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public String toString() {
        return "OfficeLevelEnum{" +
                "name='" + name + '\'' +
                ", index=" + index +
                '}';
    }
}
