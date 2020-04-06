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