/*
 * Copyright (c)  2018. houbinbin Inc.
 * fake All rights reserved.
 */

package com.github.houbb.hibernate;



import com.github.houbb.hibernate.model.User;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by houbinbin on 16/6/5.
 */
@Ignore
public class TableTest {

    /**
     * 建表语句测试
     */
    @Test
    public void createTableSQLTest() {
        Table table = new Table();
        User user = new User();
        System.out.println(table.buildCreateTableSQL(user));
    }

    /**
     * 执行建表语句
     * @throws SQLException SQL 异常
     */
    @Test
    public void executeCreateTableTest() throws SQLException {
        Session session = new Session();
        Table table = new Table();
        User user = new User();

        Connection connection = session.createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(table.buildCreateTableSQL(user));
        preparedStatement.execute();
    }

}
