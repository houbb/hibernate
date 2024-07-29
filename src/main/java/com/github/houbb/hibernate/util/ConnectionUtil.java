/*
 * Copyright (c)  2018. houbinbin Inc.
 * fake All rights reserved.
 */

package com.github.houbb.hibernate.util;

import com.mysql.jdbc.Connection;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ConnectionUtil {

    private ConnectionUtil() {
    }

    public static Connection getConnection() {
        Connection connection = null;

        Map<String, String> config = getJDBCConfig();
        try {
            Class.forName(config.get("connection.driver_class"));
            connection = (Connection) DriverManager.getConnection(config.get("connection.url"), config.get("connection.username"),
                    config.get("connection.password"));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }


    private static Map<String, String> getJDBCConfig() {
        Map<String, String> config = new HashMap<>();

        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read(ConnectionUtil.class.getClassLoader().getResource("hibernate.cfg.xml"));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        assert document != null;
        Element root = document.getRootElement();
        for (Iterator i = root.elementIterator(); i.hasNext(); ) {
            Element element = (Element) i.next();
            config.put(element.attributeValue("name"), element.getText());
        }

        return config;
    }
}
