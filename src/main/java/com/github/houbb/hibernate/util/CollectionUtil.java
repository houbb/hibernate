/*
 * Copyright (c)  2018. houbinbin Inc.
 * fake All rights reserved.
 */

package com.github.houbb.hibernate.util;

import java.util.Collection;

public class CollectionUtil {
    public static final String CONNECTER = ",";

    public static boolean isEmpty(Object[] array) {
        return (array == null) || (array.length <= 0);
    }

    public static String concatCollection2Str(Collection<String> collection, String... connector) {
        String conn = isEmpty(connector) ? CollectionUtil.CONNECTER : connector[0];
        StringBuilder stringBuilder = new StringBuilder();

        for (String str : collection) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(conn);
            }
            stringBuilder.append(str);
        }

        return stringBuilder.toString();
    }


}
