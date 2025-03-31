package com.example.demo;

import com.example.demo.mapper.AstractMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class DemoApplicationTests {

    @Autowired//自动装配
    private DataSource dataSource;


    @Test
    void contextLoads() {

    }

    /**
     * 数据库连接池
     * 1.DBCP（jdbc下）
     * 2.C3P0（springMVC基本淘汰）
     * 3.Hikari（springboot默认数据库连接池，号称世界上最快的连接池，由日本开发者开发，底层依旧采用C3P0管理数据库连接对象）
     * HikariProxyConnection@1861616277 wrapping com.mysql.cj.jdbc.ConnectionImpl@3127cb44
     * @throws// SQLException
     */
    @Test
    void getConnection() throws SQLException {
        System.out.println(dataSource.getConnection());
    }
}
