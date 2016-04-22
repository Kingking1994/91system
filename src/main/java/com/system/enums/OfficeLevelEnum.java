package com.system.enums;

/**
 * Created by king on 2016/4/22.
 */
public enum OfficeLevelEnum {

    /**
     * 普通
     */
    PUTONG(0),

    /**
     * 国家
     */
    GUOJIA(1),

    /**
     * 省级
     */
    SHENGJI(2),

    /**
     * 市级
     */
    SHIJI(3),

    /**
     * 区级
     */
    QUJI(4)

    ;
    int value;

    OfficeLevelEnum(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "OfficeLevelEnum{" +
                "value=" + value +
                '}';
    }
}
