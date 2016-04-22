package com.system.enums;

/**
 * Created by king on 2016/4/22.
 */
public enum ScheduleTimeEnum {

    /**
     * 上午
     */
    SHANGWU(0),

    /**
     * 下午
     */
    XIAWU(1)

    ;

    int value;

    ScheduleTimeEnum(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ScheduleTimeEnum{" +
                "value=" + value +
                '}';
    }
}
