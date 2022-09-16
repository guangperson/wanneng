package com.omnipotent.work.utils;

/**
 * 用于生成随机字符串的工具
 * 1.盐值生成
 * 2.字符串生成
 *
 * @author 94398
 * 2021/10/5
 */

public class CodeUtils {


    /**
     * 用于设置安全等级枚举
     * Simple：简单级别
     * Normal：普通级别：小写字符+数字
     * Hard：困难级别：大写字符+小写字符+数字
     */
    public enum SecurityLevel {
        SIMPLE,
        NORMAL,
        HARD
    }

    public static String getCode4Hard(){

        return getCode(4, SecurityLevel.HARD,false);
    }

    /**
     * 用于生成随机字符串的方法
     *
     * @param length:长度
     * @param level:等级
     * @param isRepeat:是否允许重复字符
     * @return
     */
    public static String getCode(int length, SecurityLevel level, boolean isRepeat) {
        /**
         * 用于生成字符串的源池
         */
        String code = "0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        //根据难度级别选择资源池范围
        if (level == SecurityLevel.SIMPLE) {
            code = code.substring(0, 10);
        } else if (level == SecurityLevel.NORMAL) {
            code = code.substring(0, 36);
        }
        //准备一个字符数组存储随机生成的每一个字符
        char[] codes = new char[length];
        for (int i = 0; i < length; i++) {
            //从字符串中随机以恶索引
            int index = (int) (Math.random() * code.length());
            //将随机到的字符添加到数组中
            codes[i] = code.charAt(index);
            //如果不允许重复，则应该将读取到的字符从code字符串中移除
            if (!isRepeat) {
                //使用空字符串替换已被选择字符
                code.replace("" + code.charAt(index), "");
            }

        }
        return String.valueOf(codes);
    }

    /**
     * 生成随机数长度为6
     * @return
     */
    public static String randomSalt6() {

        return getCode(6, SecurityLevel.HARD, false);
    }

    public static void main(String[] args) {
        String s = randomSalt6();
        System.out.println(s);
    }
}
