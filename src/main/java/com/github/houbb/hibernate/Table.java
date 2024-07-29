/*
 * Copyright (c)  2018. houbinbin Inc.
 * fake All rights reserved.
 */

package com.github.houbb.hibernate;




import com.github.houbb.hibernate.annotations.Column;
import com.github.houbb.hibernate.constants.HibernateConstant;
import com.github.houbb.hibernate.util.FieldUtil;
import com.github.houbb.hibernate.util.ReflectionUtil;
import com.github.houbb.hibernate.util.StringBuilderUtil;
import com.github.houbb.hibernate.util.TableUtil;

import java.lang.reflect.Field;

/**
 * 表
 * @author houbinbin
 * Created by houbinbin on 16/6/5.
 */
public class Table {
    /**
     * 构建创建表的 SQL
     * @param t 泛型入参
     * @param <T> 泛型
     * @return sql
     */
    public <T> String buildCreateTableSQL(T t) {
        String tableName = TableUtil.getTableName(t);
        StringBuilder stringBuilder = new StringBuilder("create table ");
        stringBuilder.append(tableName).append(" (");

        for(Field field : ReflectionUtil.getFieldList(t)) {
            stringBuilder.append(buildFieldSQL(t, field));
        }

        String result = StringBuilderUtil.removeLastStr(stringBuilder, ", ");
        result = buildPrimaryKey(t, result);

        return String.format("%s );", result);
    }

    /**
     * 构建主键SQL
     * @param t 入参
     * @param result 结果
     * @param <T> 泛型
     * @return SQL
     */
    private <T> String buildPrimaryKey(T t, String result) {
        Field field = FieldUtil.getIdField(t);

        if(field != null) {
            String idFieldName = FieldUtil.getFieldName(field);
            result = String.format("%s , PRIMARY KEY  (`%s`)", result, idFieldName);
        }

        return result;
    }

    private <T> String buildFieldSQL(T t, Field field) {
        String result;
        String fieldName = FieldUtil.getFieldName(field);
        String sqlType = FieldUtil.getSqlType(field);

        result = String.format("%s %s", fieldName, sqlType);
        Column column = FieldUtil.getFieldColumnAnnotation(field);

        if(ReflectionUtil.isType(field, String.class)) {
            int length = column != null ? column.length() : HibernateConstant.DEFAULT_STRING_SIZE;
            result = String.format("%s(%d)", result, length);
        }

        if(column != null) {
            result = String.format("%s %s", result, getNullAbleInfo(column));
        }

        if(FieldUtil.isGenerateValueField(t, field)) {
            result = String.format("%s AUTO_INCREMENT", result);
        }

        return String.format("%s, ", result);
    }

    /**
     * 获取是否可以为空的信息
     * @param column 列信息
     * @return 是否可以为空的结果
     */
    private String getNullAbleInfo(Column column) {
        return column.nullable() ? "" : "NOT NULL";
    }

}
