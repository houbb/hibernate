# 目录


# 前言

Hibernate 相信接触过 java 的人都不会陌生。

今天我们一起写一个简化版的 Hibernate，用于加深对此 ORM 工具的理解。

## 代码地址

> [hibernate-simulator](https://github.com/houbb/hibernate-simulator/tree/release_1.0.1) 

# 环境准备

- maven

本项目使用 maven 管理 jar 包

- jdk

jdk 为 1.8

# pom.xml

## 内容

pom 文件如下:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.github.houbb</groupId>
    <artifactId>hibernate-simulator</artifactId>
    <version>1.0.1-SNAPSHOT</version>
    <packaging>jar</packaging>

    <description>模拟 Hibernate</description>
    
    <properties>
        <!--============================== All Plugins START==============================-->
        <plugin.compiler.version>3.2</plugin.compiler.version>
        <plugin.compiler.version>3.2</plugin.compiler.version>
        <plugin.surefire.version>2.18.1</plugin.surefire.version>
        <plugin.surefire.skip-it>true</plugin.surefire.skip-it>
        <plugin.surefire.ignore-failure>true</plugin.surefire.ignore-failure>
        <!--============================== All Plugins END  ==============================-->

        <!--main-->
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.compiler.level>1.8</project.compiler.level>

        <mysql.version>5.1.34</mysql.version>
        <dom4j.version>1.6.1</dom4j.version>
    </properties>

    <dependencies>

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>${mysql.version}</version>
        </dependency>

        <!--dom4j-->
        <dependency>
            <groupId>dom4j</groupId>
            <artifactId>dom4j</artifactId>
            <version>${dom4j.version}</version>
        </dependency>

        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>

    </dependencies>

    <build>
        <finalName>${project.name}</finalName>

        <pluginManagement>
            <!--============================== All Plugins ==============================-->
            <plugins>

                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-compiler-plugin</artifactId>
                    <version>${plugin.compiler.version}</version>
                    <configuration>
                        <source>${project.compiler.level}</source>
                        <target>${project.compiler.level}</target>
                        <encoding>${project.build.sourceEncoding}</encoding>
                    </configuration>
                </plugin>

                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-surefire-plugin</artifactId>
                    <version>${plugin.surefire.version}</version>
                    <configuration>
                        <skipTests>true</skipTests>
                        <testFailureIgnore>true</testFailureIgnore>
                    </configuration>
                </plugin>

            </plugins>
        </pluginManagement>

        <!--use plugins-->
        <plugins>

            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
            </plugin>

            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
            </plugin>

        </plugins>
    </build>

</project>
```

## jar 包功能说明

| 名称 | 作用 | 备注 |
|:---|:---|:---|
| mysql-connector-java | 用于连接 mysql 数据库 | 本项目以 mysql 为例子 |
| dom4j | 用于模拟读取 `hibernate.cfg.xml` | |
| junit | 用于单元测试 | |

## 目录结构

```
.
├── main
│   ├── java
│   │   └── com
│   │       └── ryo
│   │           └── hibernate
│   │               └── simulator
│   │                   ├── hibernate
│   │                   │   ├── Session.java
│   │                   │   ├── Table.java
│   │                   │   ├── annotations
│   │                   │   │   ├── Column.java
│   │                   │   │   ├── Entity.java
│   │                   │   │   ├── GenerateValue.java
│   │                   │   │   └── Id.java
│   │                   │   ├── constants
│   │                   │   │   ├── HibernateConstant.java
│   │                   │   │   └── TypeMap.java
│   │                   │   └── util
│   │                   │       ├── ConnectionUtil.java
│   │                   │       ├── FieldUtil.java
│   │                   │       └── TableUtil.java
│   │                   ├── model
│   │                   │   └── User.java
│   │                   └── util
│   │                       ├── CollectionUtil.java
│   │                       ├── ReflectionUtil.java
│   │                       ├── StringBuilderUtil.java
│   │                       └── StringUtil.java
│   └── resources
│       └── hibernate.cfg.xml
```
