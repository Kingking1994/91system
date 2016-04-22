package com.system.enums;

/**
 * Created by king on 2016/4/22.
 */
public enum DoctorTitleEnum {

    /**
     * 主任医师
     */
    ZHUREN(0),

    /**
     * 副主任医师
     */
    FUZHUREN(1),

    /**
     * 主治医生
     */
    ZHUZHI(2)

    ;
    int value;

    DoctorTitleEnum(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "DoctorTitleEnum{" +
                "value=" + value +
                '}';
    }
}
