package com.system.enums;

/**
 * Created by king on 2016/4/22.
 */
public enum HospitalTypeEnum {

    /**
     * 其他
     */
    QITA(0)


    ;

    int value;

    HospitalTypeEnum(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "HospitalTypeEnum{" +
                "value=" + value +
                '}';
    }
}
