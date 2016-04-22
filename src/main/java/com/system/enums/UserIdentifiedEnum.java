package com.system.enums;

/**
 * Created by king on 2016/4/22.
 */
public enum UserIdentifiedEnum {

    /**
     * 否
     */
    NO(0),

    /**
     * 是
     */
    YES(1)

    ;
    int value;

    UserIdentifiedEnum(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "UserIdentifiedEnum{" +
                "value=" + value +
                '}';
    }
}
