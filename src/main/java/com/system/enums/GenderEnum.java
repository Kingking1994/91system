package com.system.enums;

/**
 * Created by king on 2016/4/22.
 */
public enum GenderEnum {

    /**
     * 男性
     */
    MALE(0),

    /**
     * 女性
     */
    FEMALE(1)


    ;
    int value;

    GenderEnum(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "GenderEnum{" +
                "value=" + value +
                '}';
    }
}
