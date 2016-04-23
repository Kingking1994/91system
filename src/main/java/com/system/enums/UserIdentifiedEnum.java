package com.system.enums;

/**
 * Created by king on 2016/4/22.
 */
public enum UserIdentifiedEnum {

    /**
     * 否
     */
    NO("否",0),

    /**
     * 是
     */
    YES("是",1)

    ;
    private String name;

    private int index;

    UserIdentifiedEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public String toString() {
        return "UserIdentifiedEnum{" +
                "name='" + name + '\'' +
                ", index=" + index +
                '}';
    }
}
