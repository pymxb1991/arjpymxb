# dao 中重复代码改造
   - 假如后期有了这些实现 (OrderDaoImpl ProductDaoImpl UserDaoImpl) 说明：这三个都是通过复制第一个过来的，
 此处复制三个只是为了说明现象
   - 问题：每个实现类中都有重复代码
         private JdbcTemplate jdbcTemplate;
     
         public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
             this.jdbcTemplate = jdbcTemplate;
         }
   -  那么我们可以将重复代码抽取出来
   
        1. 通过创建 JdbcDaoSupport 来抽取公共代码
        2. 有了公共代码之后，可以用于被其它类直接继承,
        3. 当实现类继承之后，把重复代码干掉，发现获取jdbcTemplete 出错，于是我们可以写一个get 方法来获取jdbcTemplate
        4. 有了getJdbcTemplate 时，就可以直接将之前旧的 通过jdbcTemplate.query() 查询修改为 通过有了getJdbcTemplate().query()查询
        5. 既然可以注入jdbcTemplate  那么直接将DateSource 也可以直接注入进来
              同时可以增加一个判断，当jdbcTemplate 为空时，创建一个jdbcTemplate 
        6. 很明显的问题就是，setDataSource 中的 dataSource 虽然赋值了，但是没有用上，所以可以直接干掉
           既然已经不需要赋值了，那么，上面定义的成员变量也就没有必要了；
        ``` 
              //private DataSource dataSource; 也没有必要了，可以干掉
              public void setDataSource(DataSource dataSource) {
                    //可以干掉
                   //this.dataSource = dataSource;
                   if (jdbcTemplate == null){
                       jdbcTemplate = createJdbcTemplate(dataSource);
                   }
               }
      ```
         7. 最终结果逻辑
               JdbcDaoSupport 中有两个 set 方法
               setJdbcTemplate  和 setDataSource
               1、如果传一个jdbctemplate 那么，jdbctemplate是否可以有值呢
               2、如果没有传jdbctemplate，而是传了一个dataSource ，那么，jdbctemplate是否可以有值呢
                  传dataSource会触发setDataSource() ,如果jdbctemplate是null ,那么会进行初始化jdbctemplate；
         8.当使用如此设置之后，XML 中的配置就可以进行改造一下；
              <!--配置账户的持久层 --> 中也就可以直接注入dataSource,而不用先注入jdbctemplate然后再获取数据源了；
              
              当然，既然我们都能想到这种写法，那么spring 也就能想到，也就可以支持extend这种写法；
              在Spring 中 public abstract class JdbcDaoSupport 直接继承它即可实现我们上述功能；
              
         9. 需要注意的就是这两种写法，一种是继承，一种是不继承；
                如果用注解开发，那么 可以直接使用注解@Autowrite 进行注入jdbctemplate；
                如果是XML 配置开发，那么可以直接用继承开发
              