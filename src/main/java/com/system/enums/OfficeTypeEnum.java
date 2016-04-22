package com.system.enums;

/**
 * Created by king on 2016/4/22.
 */
public enum OfficeTypeEnum {


    /**
     * 其她
     */
    QITA(0)


    ;

    int value;

    OfficeTypeEnum(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "OfficeTypeEnum{" +
                "value=" + value +
                '}';
    }
}
