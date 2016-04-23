package com.system.enums;

/**
 * Created by king on 2016/4/22.
 */
public enum RefundStatusEnum {
    /**
     * 成功退款
     */
    SUCCESS("成功退款",0),

    /**
     * 已取消
     */
    CANCEL("已取消",1),

    /**
     * 正在处理
     */
    DOING("正在处理",2)

    ;
    private String name;

    private int index;

    RefundStatusEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public String toString() {
        return "RefundStatusEnum{" +
                "name='" + name + '\'' +
                ", index=" + index +
                '}';
    }
}
