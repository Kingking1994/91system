package com.system.enums;

/**
 * Created by king on 2016/4/22.
 */
public enum UserInfoBloodEnum {

    /**
     * 其他
     */
    QITA("其他",0),

    /**
     * A型
     */
    A("A型",1),

    /**
     * B型
     */
    B("B型",2),

    /**
     * AB型
     */
    AB("AB型",3),

    /**
     * O型
     */
    O("O型",4)


    ;
    public String name;

    public int index;

    UserInfoBloodEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public String toString() {
        return "UserInfoBloodEnum{" +
                "name='" + name + '\'' +
                ", index=" + index +
                '}';
    }
}
