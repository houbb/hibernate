/*
 * Copyright (c)  2018. houbinbin Inc.
 * fake All rights reserved.
 */

package com.github.houbb.hibernate.util;

public class StringUtil {

    /**
     * 空字符串
     */
    public static final String EMPTY_STRING = "";

    public static Boolean isEmpty(String string) {
        return string == null || EMPTY_STRING.equals(string.trim());
    }

}
