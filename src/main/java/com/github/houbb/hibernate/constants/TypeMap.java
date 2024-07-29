/*
 * Copyright (c)  2018. houbinbin Inc.
 * fake All rights reserved.
 */

package com.github.houbb.hibernate.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * 存放类型 map
 * Created by houbinbin on 16/6/5.
 * @author houbinbin
 */
public class TypeMap {

    private static final Map<String, String> TYPE_MAP = new HashMap<>();

    static {
        TYPE_MAP.put("java.lang.String", "VARCHAR");
        TYPE_MAP.put("char", "CHAR");
        TYPE_MAP.put("java.lang.Character", "CHAR");
        TYPE_MAP.put("boolean", "BIT");
        TYPE_MAP.put("java.lang.Boolean", "BIT");
        TYPE_MAP.put("byte", "TINYINT");
        TYPE_MAP.put("short", "SMALLINT");
        TYPE_MAP.put("java.lang.Byte", "SMALLINT");
        TYPE_MAP.put("int", "INTEGER");
        TYPE_MAP.put("java.lang.Integer", "INTEGER");
        TYPE_MAP.put("long", "BIGINT");
        TYPE_MAP.put("java.lang.Long", "BIGINT");
        TYPE_MAP.put("float", "FLOAT");
        TYPE_MAP.put("java.lang.Float", "FLOAT");
        TYPE_MAP.put("double", "DOUBLE");
        TYPE_MAP.put("java.lang.Double", "DOUBLE");
        TYPE_MAP.put("java.util.Date", "DATETIME");
    }

    /**
     * 获取 map 列表
     * @return map
     */
    public static Map<String, String> getTypeMap() {
        return TYPE_MAP;
    }
}



