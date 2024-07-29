/*
 * Copyright (c)  2018. houbinbin Inc.
 * fake All rights reserved.
 */

package com.github.houbb.hibernate.util;





import com.github.houbb.hibernate.annotations.Entity;

import java.lang.annotation.Annotation;

/**
 * 列表工具类
 *
 * @author houbinbin
 * @date 16/6/5
 */
public class TableUtil {
    private TableUtil() {
    }

    /**
     * 获取表名称
     *
     * @param t
     * @param <T>
     * @return 表名称
     */
    public static <T> String getTableName(T t) {
        Annotation annotation = ReflectionUtil.getAnnotation(t, Entity.class);

        String tableName = ReflectionUtil.getClassName(t);

        if (annotation != null) {
            Entity entity = (Entity) annotation;
            String tableValue = entity.value();
            tableName = StringUtil.isEmpty(tableValue) ? tableName : tableValue;
        }

        return tableName;
    }
}
