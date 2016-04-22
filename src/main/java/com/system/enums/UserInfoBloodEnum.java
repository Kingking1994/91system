package com.system.enums;

/**
 * Created by king on 2016/4/22.
 */
public enum UserInfoBloodEnum {

    /**
     * 其她
     */
    QITA(0),

    /**
     * A型
     */
    A(1),

    /**
     * B型
     */
    B(2),

    /**
     * AB型
     */
    AB(3),

    /**
     * O型
     */
    O(4)


    ;
    int value;

    UserInfoBloodEnum(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "UserInfoBloodEnum{" +
                "value=" + value +
                '}';
    }
}
