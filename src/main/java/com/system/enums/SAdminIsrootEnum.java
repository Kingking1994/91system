package com.system.enums;

/**
 * Created by king on 2016/5/15.
 */
public enum SAdminIsrootEnum {

    TRUE("true",1),

    FALSE("false",0)

    ;
    public String name;

    public int index;

    SAdminIsrootEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public String toString() {
        return "SAdminIsrootEnum{" +
                "name='" + name + '\'' +
                ", index=" + index +
                '}';
    }
}
