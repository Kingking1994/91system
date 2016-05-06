package com.system.enums;

/**
 * Created by king on 2016/4/22.
 */
public enum ScheduleTimeEnum {

    /**
     * 上午
     */
    SHANGWU("上午",0),

    /**
     * 下午
     */
    XIAWU("上午",1)

    ;

    public String name;

    public int index;

    ScheduleTimeEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public String toString() {
        return "ScheduleTimeEnum{" +
                "name='" + name + '\'' +
                ", index=" + index +
                '}';
    }
}
