package com.pymxb.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * This is Description
 *
 * @author Mr.Mao
 * @date 2020/04/07
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {

        //准备数据源，使用spring  内置的数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/easy");
        ds.setUsername("root");
        ds.setPassword("123456");

        //首先new jdbcTemplate 对象，然后设置数据源，发现缺少数据源，然后去准备数据源，
        JdbcTemplate jdbc = new JdbcTemplate();
        jdbc.setDataSource(ds);
        jdbc.execute("insert into account(name,money) values('ddd',1000) ");
    }
}