/*
 * Copyright (c)  2018. houbinbin Inc.
 * fake All rights reserved.
 */

package com.github.houbb.hibernate.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;


/**
 *
 * 反射工具类
 * @author houbinbin
 * @date 16/6/5
 */
public class ReflectionUtil {

    /**
     * 是否为某一类型
     * @param field
     * @param clazz
     * @return
     */
    public static Boolean isType(Field field, Class clazz) {
        return field.getType().equals(clazz);
    }

    /**
     * 获取类名
     * @param t
     * @param <T>
     * @return
     */
    public static <T> String getClassName(T t) {
        Class clazz = t.getClass();
        return clazz.getSimpleName();
    }

    /**
     * 获取子弹列表
     * @param t
     * @param <T>
     * @return
     */
    public static <T> Field[] getFieldList(T t) {
        Class clazz = t.getClass();

        return clazz.getDeclaredFields();
    }


    /**
     * 强制获取字段值
     * @param t
     * @param fieldName
     * @param <T>
     * @return
     */
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

    /**
     * 获取字段值
     * @param t
     * @param field
     * @param <T>
     * @return
     */
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

    /**
     * 获取注解信息
     * @param t
     * @param annotationClass
     * @param <T>
     * @return
     */
    public static <T> Annotation getAnnotation(T t, Class annotationClass) {
        Class clazz = t.getClass();

        return clazz.getAnnotation(annotationClass);
    }

    /**
     * 获取注解信息
     * @param field
     * @param annotationClass
     * @return
     */
    public static Annotation getAnnotation(Field field, Class annotationClass) {
        return field.getAnnotation(annotationClass);
    }
}
