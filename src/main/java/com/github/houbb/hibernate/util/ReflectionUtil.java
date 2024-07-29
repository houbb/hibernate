/*
 * Copyright (c)  2018. houbinbin Inc.
 * fake All rights reserved.
 */

package com.github.houbb.hibernate.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;


public class ReflectionUtil {

    public static Boolean isType(Field field, Class clazz) {
        return field.getType().equals(clazz);
    }

    public static <T> String getClassName(T t) {
        Class clazz = t.getClass();
        return clazz.getSimpleName();
    }

    public static <T> Field[] getFieldList(T t) {
        Class clazz = t.getClass();

        return clazz.getDeclaredFields();
    }


    public static <T> Object getFieldValueForce(T t, String fieldName) {
        Class clazz = t.getClass();
        Object value = null;
        try {
            Field field = clazz.getDeclaredField(fieldName);
            value = getFieldValue(t, field);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        return value;
    }

    private static <T> Object getFieldValue(T t, Field field) {
        Object value = null;
        field.setAccessible(true);
        try {
            value = field.get(t);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static <T> Annotation getAnnotation(T t, Class annotationClass) {
        Class clazz = t.getClass();

        return clazz.getAnnotation(annotationClass);
    }

    public static Annotation getAnnotation(Field field, Class annotationClass) {
        return field.getAnnotation(annotationClass);
    }
}
