/*
 * Copyright (c)  2018. houbinbin Inc.
 * fake All rights reserved.
 */

package com.github.houbb.hibernate.util;

public class StringBuilderUtil {

    public static String removeLastStr(StringBuilder stringBuilder, String subStr) {
        int lastIndex = stringBuilder.lastIndexOf(subStr);
        return stringBuilder.substring(0, lastIndex);
    }

}
