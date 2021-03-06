package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * 和连接数据库相关的配置类
 *
 * @author Mr.Mao
 * @date 2020/04/08
 */
public class JdbcConfig {

    //加载配置文件之后，通过基本类型注释：把数据注入
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    /**
     * 创建JDBCtemplate 对象
     * @param dataSource
     * @return
     */
    @Bean(name = "jdbcTemplate") //同时把jdbcTemplate 加入容器
    public JdbcTemplate createJdbcTemplate(DataSource dataSource){
        return  new JdbcTemplate(dataSource);
    }

    /**
     *创建数据源对象
     * @return
     */
    @Bean(name = "dataSource") //同时把dataSource 加入容器
    public DataSource createDataSource(){

        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return  ds;
    }
}