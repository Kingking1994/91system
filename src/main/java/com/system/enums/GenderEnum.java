package com.system.enums;

/**
 * Created by king on 2016/4/22.
 */
public enum GenderEnum {

    /**
     * 男性
     */
    MALE("男",0),

    /**
     * 女性
     */
    FEMALE("女",1)


    ;
    public String name;
    public int index;

    GenderEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public String toString() {
        return "GenderEnum{" +
                "name='" + name + '\'' +
                ", index=" + index +
                '}';
    }
}
