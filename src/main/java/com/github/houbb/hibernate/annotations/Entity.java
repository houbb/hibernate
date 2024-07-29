/*
 * Copyright (c)  2018. houbinbin Inc.
 * fake All rights reserved.
 */

package com.github.houbb.hibernate.annotations;

import java.lang.annotation.*;

/**
 * 实体-注解
 * Created by houbinbin on 16/6/5.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface Entity {
    /**
     * 表名称
     * @return 表名称
     */
    String value() default "";
}
