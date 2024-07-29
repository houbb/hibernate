/*
 * Copyright (c)  2018. houbinbin Inc.
 * fake All rights reserved.
 */

package com.github.houbb.hibernate.util;




import com.github.houbb.hibernate.annotations.Column;
import com.github.houbb.hibernate.annotations.GenerateValue;
import com.github.houbb.hibernate.annotations.Id;
import com.github.houbb.hibernate.constants.TypeMap;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static com.github.houbb.hibernate.util.ReflectionUtil.*;


/**
 *
 * 字段工具类
 * @author houbinbin
 * @date 16/6/5
 */
public class FieldUtil {
    /**
     * 获取对应SQL字段类型
     * @param field
     * @return
     */
    public static String getSqlType(Field field) {
        return TypeMap.getTypeMap().get(field.getType().getTypeName());
    }

    /**
     * 获取字段名称
     * @param field
     * @return
     */
    public static String getFieldName(Field field) {
        String fieldName = field.getName();
        Annotation annotation = getAnnotation(field, Column.class);

        Column column = getFieldColumnAnnotation(field);
        if(column != null) {
            String columnValue = column.value();
            fieldName = StringUtil.isEmpty(columnValue) ? fieldName : columnValue;
        }

        return fieldName;
    }

    /**
     * 获取子弹注解信息
     * @param field
     * @return
     */
    public static Column getFieldColumnAnnotation(Field field) {
        Annotation annotation = getAnnotation(field, Column.class);

        if(annotation != null) {
            return (Column) annotation;
        }

        return null;
    }

    /**
     * 获取ID字段
     * - 不存在则返回null
     * @param t
     * @param <T>
     * @return
     */
    public static <T> Field getIdField(T t) {
        for (Field field : getFieldList(t)) {
            Annotation annotation = getAnnotation(field, Id.class);
            if(annotation != null) {
                return field;
            }
        }

        return null;
    }

    /**
     * 获取自增长字段。
     * @param <T>
     * @return
     */
    public static <T> Field getGenerateValueField(T t) {
        for(Field field : getFieldList(t)) {
            Annotation annotation = getAnnotation(field, GenerateValue.class);
            if(annotation != null) {
                return field;
            }
        }

        return null;
    }

    /**
     * 是否为 GenerateValue 字段
     * @param t
     * @param field
     * @param <T>
     * @return
     */
    public static <T> boolean isGenerateValueField(T t, Field field) {
        Field generateValueField = getGenerateValueField(t);
        return generateValueField != null && field.equals(generateValueField);
    }

    /**
     * 获取字段名称列表
     * @param t
     * @param <T>
     * @return
     */
    public static <T> List<String> getFieldNameList(T t) {
        List<String> fieldNameList = new LinkedList<>();

        for(Field field : getFieldList(t)) {
            fieldNameList.add(getFieldName(field));
        }

        return fieldNameList;
    }

    /**
     * 获取字段名称字符串形式
     * @param t
     * @param <T>
     * @return
     */
    public static <T> String getFieldNameString(T t) {
        return CollectionUtil.concatCollection2Str(FieldUtil.getFieldNameList(t));
    }

    /**
     * 获取字段值字符串形式
     * @param t
     * @param <T>
     * @return
     */
    public static <T> String getFieldValueString(T t) {
        List<String> valueStrList = new LinkedList<>();
        for(Field field : getFieldList(t)) {
            valueStrList.add(String.format("'%s'", getValueString(t, field)));
        }

        return CollectionUtil.concatCollection2Str(valueStrList);
    }

    /**
     * 获取指定字段值字符串
     * @param t
     * @param field
     * @param <T>
     * @return
     */
    private static <T> String getValueString(T t, Field field) {
        Object value = getFieldValueForce(t, field.getName());

        String result = value.toString();

        if(isType(field, Date.class)) {
            result = dateToString((Date) value);
        }

        return result;
    }

    /**
     * 日期转字符串
     * @param dateTime 日期
     * @return 字符串
     */
    private static String dateToString(Date dateTime) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateTime);
    }

}
