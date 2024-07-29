/*
 * Copyright (c)  2018. houbinbin Inc.
 * fake All rights reserved.
 */

package com.github.houbb.hibernate;

import com.github.houbb.hibernate.model.User;
import com.github.houbb.hibernate.util.ConnectionUtil;
import com.github.houbb.hibernate.util.FieldUtil;
import com.github.houbb.hibernate.util.TableUtil;
import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.SQLException;

public class Session {
    private static final String INSERT_FORMAT = "INSERT INTO %s ( %s ) VALUES ( %s ) ;";

    public void save(User user) throws SQLException {
        String sql = buildInsertSQL(user);

        Connection con = createConnection();
        PreparedStatement state =  (PreparedStatement) con.prepareStatement(sql);
        state.execute();
        con.close();
    }

    public String buildInsertSQL(User user) {
        String tableName = TableUtil.getTableName(user);
        String fieldString = FieldUtil.getFieldNameString(user);
        String valueString = FieldUtil.getFieldValueString(user);

        return String.format(INSERT_FORMAT, tableName, fieldString, valueString);
    }

    public Connection createConnection() {
        return ConnectionUtil.getConnection();
    }
}