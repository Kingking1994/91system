package com.system.enums;

/**
 * Created by king on 2016/4/22.
 */
public enum UserInfoMarriedEnum {

    /**
     * 其她
     */
    QITA(0),

    /**
     * 否
     */
    NO(1),

    /**
     * 是
     */
    YES(2)
    ;

    int value;

    UserInfoMarriedEnum(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "UserInfoMarriedEnum{" +
                "value=" + value +
                '}';
    }
}
