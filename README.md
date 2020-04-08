# arjpymxb
##java 学习 路线
### java 基础
    1. 封装、继承、多态     
    2. 抽象： 举例：动物-->狗-->[2ha,金毛]
    3. 接口：
           1. 从java8开始: 接口中增加了``Default`` 默认方法
           2. 从java8开始： 接口中允许定义静态方法 ；可以直接通过接口名称，直接调用定义的静态方法
           3. 从java9开始：接口允许定义私有方法：[普通私有，静态私有]
    4. 多态：
           1. 代码当中体现多态性，其它就是一句话，父类引用指向子类对象
              格式：
                 父类名称   对象名称  =  new  子类名称（）      左父右子
              或者      接口实现关系也一样
                 接口名称  对象名称 =  new  实现类名称（）；            
                 extend   implements  都能作为多态性的体现前提            
            2. 就一句话：左父，右子就是多态，右侧子类对象就被当做父类进行使用，一只猫被当做动物看待，这是没有问题的，
                因为子类就是一个父类，在这里体现了面向对象的多态性
            3. 向上转型一定是安全的，没有问题的，正确的。但是也有一个弊端：
               对象一旦向上转型为父类，那么就无法调用子类原本特有的内容。
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
### spring-easy-account-xmlioc
    基于XML 配置学习
### spring-easy-account-annlioc
    基于注解 配置学习
### spring-easy-account-withoutxmlioc
    无XML 纯注解配置学习
### spring-easy-account01
    银行转账业务代码分析学习
    事务初探-数据异常回滚（使用工具类方式） 
### spring-easy-account01-proxy
    代理模式--初探
    旧时模式：生产产家生产产品，自己销售和售后；
    新的模式：生产产家生产产品，委托代理商进行销售，代理商根据自己要求，选择有销售和售后的生产产家进行合作   
    
    有了代理，然后对 spring-easy-account01 进行改造，
    解除耦合，消除依赖，使用事务
### spring-aop01
    1. XML 配置 AOP 逻辑
       增强配置：accountService 方法执行前都进行记录日志
       实际开发中切入点表达式的通常写法 学习：
       execution(表达式)
       切入点表达式的写法：
           关键字：execution(表达式)
           表达式：
               访问修饰符  返回值  包名.包名.包名...类名.方法名(参数列表)
           标准的表达式写法：
               public void com.itheima.service.impl.AccountServiceImpl.saveAccount()
               ……
           详细配置见：bean.xml
### spring-aop02
    1. spring AOP
            XML配置 前置，后置，异常，最终通知, 以及环绕通知 学习
            通用化切入点表达式的应用
             <aop:pointcut id="ptcut1" expression="execution( * com.pymxb.service.impl.*.*(..))"/>
             环绕通知：切入点方法调用
                 Spring框架为我们提供了一个接口：ProceedingJoinPoint。该接口有一个方法proceed()，此方法就相当于明确调用切入点方法。
                 该接口可以作为环绕通知的方法参数，在程序执行时，spring框架会为我们提供该接口的实现类供我们使用。
### spring-aop03-anno
    1. 注解 配置 AOP 逻辑
          1、@Aspect 配置切面类
          2、@Before   @AfterReturning  @AfterThrowing @After 配置通知类型
          3、配置切入点表达式 pt1  @Pointcu
          4、配置spring开启注解AOP的支持
          
          ********************************************************************************
           注意，在使用注解 @Before   @AfterReturning  @AfterThrowing @After 配置通知类型时，
                发现通知执行顺序有问题（最终通知总在 后置通知，异常通知前面，）调用顺序有问题
          ********************************************************************************
       
### spring-aop04-withoutxml
    1. 纯注解 配置 AOP 逻辑
       增加配置Config配置 -->> SpringConfiguration 类
       @EnableAspectJAutoProxy //配置spring开启注解AOP的支持
       即可；
### spring-aop05-easy-aoptx-xml
    1、案例改造
          银行转账改造： 
             把用工厂模式创建代理service 模式控制事务 改造为 基于 AOP 控制事务  XML模式
### spring-aop06-easy-aoptx-anno
    1、案例改造
           银行转账改造： 为注解配置的设置
           
           使用环绕通知，解决事务控制 问题；
### spring-easy-jdbcTemplate01
    1、JdbcTemplate 初探，学习
    2、JdbcTemplate CRUD 操作
       注意：在查询所有时，query 的第二个参数是RowMapper ，RowMapper 是一个接口，想要用它，只能去实现他 实现之后，把新的RowMapper对象添加进来
    3、JdbcDaoSupport的使用以及Dao的两种编写方式
### spring-easy-tx01
    spring中基于XML的声明式事务控制配置步骤
         1、配置事务管理器
         2、配置事务的通知
         3、配置AOP中的通用切入点表达式
         4、建立事务通知和切入点表达式的对应关系
         5、最后还需要配置事务的属性
### spring-easy-tx02
    spring基于注解的声明式事务控制
         使用注解的方式配置事务
    ***************************************************************************************     
    注意：当一个业务层中有5个查询，5个更新时，使用注释配置就比较麻烦了， 一种配置中最少需要增加5次；
         所以，XML 的选择上选择哪一种比较合适，毫无疑问的是 XML的配置是一劳永逸的；
         而注解的，可能在一个service 中就需要配置多遍
         但是如果单从简单程序上来说，还是注解的方式简单
    ***************************************************************************************
### spring-easy-tx03
    spring基于纯注解的声明式事务控制
        1、第一个注解：  @Configuration 可写可不写，因为SpringConfiguration 类会当作字节码的参数，传给annocationContext
        2、第二个注解： 指定spring在创建容器时要扫描的包 @ComponentScan("com.pymxb")
        3、第三个注解： @Import用于导入其他的配置类
                其它的配置类如：JdbcConfig  TransactionConfig
        4、第四个注解： @Bean  把创建的Bean对象 加入容器
        5、第四个注解： @PropertySource 加载数据源配置文件进容器  同时使用@Value 把基本类型数据注入
        6、第五个注解: @EnableTransactionManagement 开启注解支持，同时创建事务管理器
        7、以上操作都操作完之后，Bean.xml 就可以直接干掉了，