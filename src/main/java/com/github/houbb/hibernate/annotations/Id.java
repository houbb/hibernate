/*
 * Copyright (c)  2018. houbinbin Inc.
 * fake All rights reserved.
 */

package com.github.houbb.hibernate.annotations;

import java.lang.annotation.*;

/**
 * 主键标识
 * Created by houbinbin on 16/6/5.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
public @interface Id {
}
