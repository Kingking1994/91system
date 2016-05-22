package com.system.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串常用方法工具类
 */
public final class StrUtil {

    /**
     * 此类不需要实例化
     */
    private StrUtil() {
    }

    /**
     * 判断一个字符串是否为空，null也会返回true
     *
     * @param str 需要判断的字符串
     * @return 是否为空，null也会返回true
     */
    public static boolean isBlank(String str) {
        return null == str || "".equals(str.trim());
    }

    /**
     * 判断一个字符串是否不为空
     *
     * @param str 需要判断的字符串
     * @return 是否为空
     */
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    /**
     * 判断input是否为大于等于0的整数
     * @param input
     * @return
     */
    public static boolean isNum(String input){
        if(isBlank(input)){
            return false;
        }
        Pattern pattern = Pattern.compile("^\\d+$");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

}