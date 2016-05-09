package com.system.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by king on 2016/5/6.
 */
public class PatternUtil {

    /**
     * 检测密码模式正确性
     * 长度为6-16位
     * 由数字、26个英文字母或者下划线组成的字符串
     * @param password
     * @return
     */
    public static boolean checkPassword(String password){
        if(StrUtil.isNotBlank(password)){
            if(password.length() >= 6 && password.length() <= 16){
                String patternString  = "^\\w+$";
                Pattern p = Pattern.compile(patternString);
                Matcher matcher = p.matcher(password);
                return matcher.matches();
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    /**
     * 检验手机号的正确性
     * @param phone
     * @return
     */
    public static boolean checkPhone(String phone){
        if(StrUtil.isNotBlank(phone)){
            if(phone.length() == 11){
                String patternString  = "^1[3|4|5|8]\\d{9}$";
                Pattern p = Pattern.compile(patternString);
                Matcher matcher = p.matcher(phone);
                return matcher.matches();
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    /**
     * 检验身份证号的正确性
     * @param idCard
     * @return
     */
    public static boolean checkIDCard(String idCard){
        if(StrUtil.isNotBlank(idCard)){
            String patternString  = "^\\d{15}|\\d{18}$";
            Pattern p = Pattern.compile(patternString);
            Matcher matcher = p.matcher(idCard);
            return matcher.matches();
        }else{
            return false;
        }
    }
}
