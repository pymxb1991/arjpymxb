package com.pymxb.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * This is Description
 *
 * @author Mr.Mao
 * @date 2020/04/07
 */
public class JdbcTemplateDemo2 {
    public static void main(String[] args) {

        //1、获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate)ac.getBean("jdbcTemplate");
        jdbcTemplate.execute("insert into account(name,money) values('eee',1000) ");

        //*****************************方案一****************************************
        //准备数据源，使用spring  内置的数据源
        /*DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/easy");
        ds.setUsername("root");
        ds.setPassword("123456");

        //首先new jdbcTemplate 对象，然后设置数据源，发现缺少数据源，然后去准备数据源，
        JdbcTemplate jdbc = new JdbcTemplate();
        jdbc.setDataSource(ds);
        jdbc.execute("insert into account(name,money) values('ddd',1000) ");*/
    }
}