package com.system.enums;

/**
 * Created by king on 2016/4/22.
 */
public enum OrderItemStatusEnum {

    /**
     * 成功预约
     */
    SUCCESS("成功预约",0),

    /**
     * 已取消
     */
    CANCEL("已取消",1)

    ;
    public String name;
    public int index;

    OrderItemStatusEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public String toString() {
        return "OrderItemStatusEnum{" +
                "name='" + name + '\'' +
                ", index=" + index +
                '}';
    }
}
