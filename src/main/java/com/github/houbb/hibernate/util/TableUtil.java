/*
 * Copyright (c)  2018. houbinbin Inc.
 * fake All rights reserved.
 */

package com.github.houbb.hibernate.util;





import com.github.houbb.hibernate.annotations.Entity;

import java.lang.annotation.Annotation;

public class TableUtil {
    private TableUtil() {
    }

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
