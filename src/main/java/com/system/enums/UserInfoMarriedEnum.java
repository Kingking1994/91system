package com.system.enums;

/**
 * Created by king on 2016/4/22.
 */
public enum UserInfoMarriedEnum {

    /**
     * 其他
     */
    QITA("其他",0),

    /**
     * 否
     */
    NO("否",1),

    /**
     * 是
     */
    YES("是",2)
    ;

    private String name;
    private int index;

    UserInfoMarriedEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public String toString() {
        return "UserInfoMarriedEnum{" +
                "name='" + name + '\'' +
                ", index=" + index +
                '}';
    }
}
