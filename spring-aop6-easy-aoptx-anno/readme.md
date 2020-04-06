# 银行转账案例改造为注解方式
    1. 首先改造IOC的部分
       配置Spring创建容器时要扫描的包
       1.1  先增加支持 context 的依赖；
       1.2  然后增加扫描
       <!-- 1、 配置Spring创建容器时要扫描的包-->
       <context:component-scan base-package="com.pymxb"></context:component-scan>
    2.有了以上配置之后 ，Service 就可以改为注解模式
        1、首先，AccountServiceImpl 的实现类，增加注解@Service
        2、然后 AccountServiceImpl中注入的dao 也改为使用注解注入   @Autowired
           之后set方法即是多余的，删除即可
        3、把xml 中配置也干掉；
    3.再然后就是DAO 的注解配置
        1、首先，AccountDaoImpl 的实现类，增加注解@@Repository
        2、然后 AccountDaoImpl中注入的工具类ConnectionUtils 和QueryRunner 也改为使用注解注入   @Autowired
           之后set方法即是多余的，删除即可
        3、把xml 中先将accountDao配置干掉；
        4、QueryRunner的配置，暂时先不动，因为涉及到纯注解配置的内容；
    4.connectionUtils 的配置
        1、因为connectionUtils是我们自己配置的配置类工具，所以直接使用@Component 进行注入
        2、然后 ConnectionUtils中注入的DataSource 也改为使用注解注入   @Autowired
           之后set方法即是多余的，删除即可
        3、把xml 中配置也干掉；
    5.最后是AOP 的配置设置
        1、首先配置TransactionManager 使用@Component 进行注入
        2、然后 首先配置TransactionManager中注入的ConnectionUtils 也改为使用注解注入   @Autowired
           之后set方法即是多余的，删除即可
        3、把xml 中配置也干掉；
        然后接下来进行我们我切面配置工作
           4、首先把TransactionManager 通过使用注解  @Aspect 配置为切面类
           5、然后增加配置通用切入点表达式
              //配置通用切入点表达式
              @Pointcut("execution(* com.pymxb.service.impl.*.*(..))")
              private void pt1(){}
           6、然后在各个增加的方法上分别增加注解配置
              @Before("pt1()")   前置通知
              @AfterReturning("pt1()")  后置通知
              @AfterThrowing("pt1()")   异常通知
              @After("pt1()")           最终通知
           7、把xml 中配置也干掉；
           8、最后在xml 中开启spring 对注解AOP的支持
    6. 配置完毕AOP 之后，直接测试     
    7、测试结果：java.sql.SQLException: Can't call commit when autocommit=true
      ********************************************************************************
       分析原因： 是因为spring 注解AOP 的最终通知总是在后置通知，异常通知之前执行，最终通知总是在前执行，提前把connection 关闭，自然就提交不了了
      ********************************************************************************
      
    8、代码执行分析：
         1、首先 执行入口：AccountServiceTest: testTransfer
         2、然后进行service: AccountServiceImpl:  testTransfer
         3、然后service 中调用Dao中的方法：获取数据库连接，然后从数据库中获取数据: dao.findAccountByName(ConnectionUtil.getThreadConnection()……)
            获取到之后然后更新 也是调用Dao中的方法
         4、数据库连接工具类中：ConnectionUtil -> getThreadConnection() 获取数据库连接，然后从线程上获取，如果没有再进行创建；
         5、在AOP的执行顺序中，因为最终通知总是在后置通知，异常通知之前执行，
            只要最终通知执行，connectionUtils.getThreadConnection().close();//还回连接池中
                            connectionUtils.removeConnection();
            那么就会把连接和线程解绑，
            而当后置通知，和异常通知再次执行时，还会去线程上拿连接，但是由于没有连接了，所以会进行创建，所以拿到的连接是一个新的连接，所以会出现控制不了事务的情况
    
    9、如果想要使用AOP 控制事务，那么则只能使用环绕通知；