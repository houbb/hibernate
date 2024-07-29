/*
 * Copyright (c)  2018. houbinbin Inc.
 * fake All rights reserved.
 */

package com.github.houbb.hibernate.util;

/**
 * 字符串Builder-工具类
 *
 * @author houbinbin
 * @date 16/6/5
 */
public class StringBuilderUtil {

    /**
     * 移除最后一饿字符
     *
     * @param stringBuilder stringBuilder
     * @param subStr        需要字符串
     * @return 新的结果
     */
    public static String removeLastStr(StringBuilder stringBuilder, String subStr) {
        int lastIndex = stringBuilder.lastIndexOf(subStr);
        return stringBuilder.substring(0, lastIndex);
    }

}
