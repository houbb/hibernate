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


public class FieldUtil {

    public static String getSqlType(Field field) {
        return TypeMap.getTypeMap().get(field.getType().getTypeName());
    }

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

    public static Column getFieldColumnAnnotation(Field field) {
        Annotation annotation = getAnnotation(field, Column.class);

        if(annotation != null) {
            return (Column) annotation;
        }

        return null;
    }

    public static <T> Field getIdField(T t) {
        for (Field field : getFieldList(t)) {
            Annotation annotation = getAnnotation(field, Id.class);
            if(annotation != null) {
                return field;
            }
        }

        return null;
    }

    public static <T> Field getGenerateValueField(T t) {
        for(Field field : getFieldList(t)) {
            Annotation annotation = getAnnotation(field, GenerateValue.class);
            if(annotation != null) {
                return field;
            }
        }

        return null;
    }

    public static <T> boolean isGenerateValueField(T t, Field field) {
        Field generateValueField = getGenerateValueField(t);
        return generateValueField != null && field.equals(generateValueField);
    }

    public static <T> List<String> getFieldNameList(T t) {
        List<String> fieldNameList = new LinkedList<>();

        for(Field field : getFieldList(t)) {
            fieldNameList.add(getFieldName(field));
        }

        return fieldNameList;
    }

    public static <T> String getFieldNameString(T t) {
        return CollectionUtil.concatCollection2Str(FieldUtil.getFieldNameList(t));
    }

    public static <T> String getFieldValueString(T t) {
        List<String> valueStrList = new LinkedList<>();
        for(Field field : getFieldList(t)) {
            valueStrList.add(String.format("'%s'", getValueString(t, field)));
        }

        return CollectionUtil.concatCollection2Str(valueStrList);
    }

    private static <T> String getValueString(T t, Field field) {
        Object value = getFieldValueForce(t, field.getName());

        String result = value.toString();

        if(isType(field, Date.class)) {
            result = dateToString((Date) value);
        }

        return result;
    }

    private static String dateToString(Date dateTime) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateTime);
    }

}
