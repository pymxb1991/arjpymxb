package config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * 和事务相关的配置
 *
 * @author Mr.Mao
 * @date 2020/04/08
 */
public class TransactionConfig {

    /**
     * 用于创建事务管理器对象
     *
     *  调用默认的构造函数，创建对象，并且存了spring 容器，同时需要注入一个数据源；
     *
     *   PlatformTransactionManager
     * @param dataSource
     * @return
     */
    @Bean(name="transactionManager") //同时使用@Bean 将其加入spring 容器
    public PlatformTransactionManager createTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}