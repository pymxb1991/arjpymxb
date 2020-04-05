package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@ComponentScan(basePackages = {"com.pymxb"}) //扫描包，必须是配置类
@EnableAspectJAutoProxy
public class SpringConfiguration {

}
