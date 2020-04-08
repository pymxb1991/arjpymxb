package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Spring 的配置类，相关于Bean.xml
 *  1、第一个注解：  @Configuration 可写可不写，因为SpringConfiguration 类会当作字节码的参数，传给annocationContext
 *  2、第二个注解： 指定spring在创建容器时要扫描的包 @ComponentScan("com.pymxb")
 *  3、第三个注解： @Import用于导入其他的配置类
 *  4、第四个注解： @Bean  把创建的Bean 加入容器
 *  5、第四个注解： @PropertySource 加载数据源配置文件进容器  @Value 把基本类型数据注入
 *  6、第五个注解: @EnableTransactionManagement 开启注解支持，同时创建事务管理器
 *  7、以上操作都操作完之后，Bean.xml 就可以直接干掉了，
 * @author Mr.Mao
 * @date 2020/04/08
 */
@Configuration
@ComponentScan("com.pymxb")
@Import({JdbcConfig.class,TransactionConfig.class})
@PropertySource("jdbcConfig.properties")
@EnableTransactionManagement
public class SpringConfiguration {
}