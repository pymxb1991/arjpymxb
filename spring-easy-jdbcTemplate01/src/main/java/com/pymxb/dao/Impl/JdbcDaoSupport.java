package com.pymxb.dao.Impl;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


/**
 * 此类将用于抽取公共代码
 *
 * @author Mr.Mao
 * @date 2020/04/07
 */
public class JdbcDaoSupport {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

   // private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {

        //this.dataSource = dataSource;
        if (jdbcTemplate == null){
            jdbcTemplate = createJdbcTemplate(dataSource);
        }
    }

    private JdbcTemplate createJdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}