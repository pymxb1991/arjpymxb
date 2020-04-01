package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

/**
 * 和spring连接数据库相关的配置类
 */
//@Configuration
public class JdbcConfig {

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    /**
     * 用于创建一个QueryRunner对象
     *
     *    注意：
     *          1、当使用多数据源时，如果都是返回相同类型的数据源,首先会根据当前 Bean的ID 来创建数据源；
     *          2、如果根据当前 Bean的ID 找不到对应的同名数据源，也就是说两个数据源使用@Bean 定义的名称都不一样，那么则会抛出异常
     *             expected single matching bean but found2:ds1 ds2
     *             如果想解决此异常，
     *                1、可以把数据源名称命名跟其中一个数据源一致；
     *                2、也可以直接使用@Qualifier来标记数据源进行配置：
     *                @Qualifier
     *                     首先一上来会先按照类型来进行注入，
     *                     当没有类型匹配，或有多个类型匹配时并且形参无法在多个匹配中找到符合名称的ID 时，就会使用@Qualifier标记的数据源来执行
     * @param dataSource
     * @return
     */
    @Bean(name="runner")
    @Scope("prototype")//支持多例
    public QueryRunner createQueryRunner(@Qualifier("ds2") DataSource dataSource){
        return new QueryRunner(dataSource);
    }

    /**
     * 创建数据源对象
     * @return
     */
    @Bean(name="dataSource")
    public DataSource createDataSource(){
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            //有了数据库连接配置文件之后，可以使用@Value 注解 @PropertySource
       /*     ds.setDriverClass("com.mysql.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/easy");
            ds.setUser("root");
            ds.setPassword("123456"); */
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(username);
            ds.setPassword(password);
            return ds;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 注意：
     *
     * 创建数据源对象
     * @return
     */
    @Bean(name="ds1")
    public DataSource createDataSource1(){
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            //有了数据库连接配置文件之后，可以使用@Value 注解 @PropertySource
       /*     ds.setDriverClass("com.mysql.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/easy");
            ds.setUser("root");
            ds.setPassword("123456"); */
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(username);
            ds.setPassword(password);
            return ds;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
