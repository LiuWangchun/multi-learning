package com.mystudy.multilearning.jwt.util;

/**
 * @ClassName ObjectUtils
 * @Description TODO
 * @Author MrLiu
 */
public class ObjectUtils {

    public static String toString(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public static Long toLong(Object obj) {
        if (obj == null) {
            return 0L;
        }
//        if (obj instanceof Double || obj instanceof Float) {
//            return Long.valueOf(StringUtils.substringBefore(obj.toString(), "."));
//        }
        if (obj instanceof Double || obj instanceof Float) {
            return Long.valueOf(obj.toString().substring(0,obj.toString().indexOf(".")));
        }
        if (obj instanceof Number) {
            return Long.valueOf(obj.toString());
        }
        if (obj instanceof String) {
            return Long.valueOf(obj.toString());
        } else {
            return 0L;
        }
    }

    public static Integer toInt(Object obj) {
        return toLong(obj).intValue();
    }
}
