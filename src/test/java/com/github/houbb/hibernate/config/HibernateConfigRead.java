/*
 * Copyright (c)  2018. houbinbin Inc.
 * fake All rights reserved.
 */

package com.github.houbb.hibernate.config;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.Iterator;

/**
 * Created by houbinbin on 16/6/5.
 */
public class HibernateConfigRead {
    @Test
    public void testRead() throws Exception {
        System.out.println(getClass().getClassLoader().getResource("hibernate.cfg.xml"));
        SAXReader reader = new SAXReader();
        Document document = reader.read(getClass().getClassLoader().getResource("hibernate.cfg.xml"));
        Element root = document.getRootElement();

        // iterate through child elements of root
        for (Iterator i = root.elementIterator(); i.hasNext(); ) {
            Element element = (Element) i.next();
            System.out.println(element.attributeValue("name"));
            System.out.println(element.getData()+" == "+element.getText());  //获取值
        }
    }
}
