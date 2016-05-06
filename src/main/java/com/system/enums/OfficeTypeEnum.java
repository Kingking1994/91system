package com.system.enums;

/**
 * Created by king on 2016/4/22.
 */
public enum OfficeTypeEnum {


    /**
     * 其她
     */
    QITA("其她",0)


    ;

    public String name;
    public int index;

    OfficeTypeEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public String toString() {
        return "OfficeTypeEnum{" +
                "name='" + name + '\'' +
                ", index=" + index +
                '}';
    }
}
