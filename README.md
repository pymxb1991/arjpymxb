# arjpymxb
##java 学习 路线
### java 基础
    1. 封装、继承、多态     
    2. 抽象： 举例：动物-->狗-->[2ha,金毛]
    3. 接口：
           1. 从java8开始: 接口中增加了``Default`` 默认方法
           2. 从java8开始： 接口中允许定义静态方法 ；可以直接通过接口名称，直接调用定义的静态方法
           3. 从java9开始：接口允许定义私有方法：[普通私有，静态私有]
### spring demo 
### spring IOC
    曾经XML 配置
    <bean id="accountDao" class="com.pymxb.dao.impl.AccountDaoImpl" 
          scope="" init-method="" destroy-method="">
             <property name="" value=""| ref="></property>
         </bean>
    Spring 注解
    @Component    @Controller    @Service    @Repository
    
    @Autwired    @Qualifier   @Resource
    
    @Value  @Scope
###spring-easy-account-xmlioc
    基于XML 配置学习
###spring-easy-account-annlioc
    基于注解 配置学习
###spring-easy-account-withoutxmlioc
    无XML 纯注解配置学习
    