package com.system.enums;

/**
 * Created by king on 2016/4/22.
 */
public enum RefundStatusEnum {
    /**
     * 成功退款
     */
    SUCCESS(0),

    /**
     * 已取消
     */
    CANCEL(1),

    /**
     * 正在处理
     */
    DOING(2)

    ;
    int value;

    RefundStatusEnum(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "RefundStatusEnum{" +
                "value=" + value +
                '}';
    }
}
