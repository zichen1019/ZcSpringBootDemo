package com.zc.common.utils;

import java.util.Date;

public class CheckUtil {

    private static final String NULL = "null";

    /**
     * 逻辑处理
     * <p>
     * 1. 如果对象直接等于NULL
     *
     * @param obj
     * @return
     */
    public static boolean isNotNull(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj instanceof String) {
            if ("".equals(obj) || NULL.equals(obj)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckUtil.isNotNull("1");
        CheckUtil.isNotNull(new Date());
    }

}
