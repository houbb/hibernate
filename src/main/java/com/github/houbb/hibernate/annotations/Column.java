/*
 * Copyright (c)  2018. houbinbin Inc.
 * fake All rights reserved.
 */

package com.github.houbb.hibernate.annotations;

import java.lang.annotation.*;

/**
 * 列-注解
 * Created by houbinbin on 16/6/5.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface Column {

    /**
     * 列名
     * @return 列名
     */
    String value() default "";

    /**
     * 是否可以为空
     * @return {@code true} 可以
     */
    boolean nullable() default true;

    /**
     * 字段的长度
     * @return 字段的长度
     */
    int length() default 255;

}
