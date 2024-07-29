/*
 * Copyright (c)  2018. houbinbin Inc.
 * fake All rights reserved.
 */

package com.github.houbb.hibernate.util;

/**
 * 字符串-工具类
 * @author houbinbin
 * @date 16/6/5
 */
public class StringUtil {

    /**
     * 空字符串
     */
    public static final String EMPTY_STRING = "";

    /**
     * 是否为空
     * @param string
     * @return
     */
    public static Boolean isEmpty(String string) {
        return string == null || EMPTY_STRING.equals(string.trim());
    }

}
