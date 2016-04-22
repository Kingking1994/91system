package com.system.enums;

/**
 * Created by king on 2016/4/22.
 */
public enum OrderItemStatusEnum {

    /**
     * 成功预约
     */
    SUCCESS(0),

    /**
     * 已取消
     */
    CANCEL(1)

    ;
    int value;

    OrderItemStatusEnum(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "OrderItemStatusEnum{" +
                "value=" + value +
                '}';
    }
}
