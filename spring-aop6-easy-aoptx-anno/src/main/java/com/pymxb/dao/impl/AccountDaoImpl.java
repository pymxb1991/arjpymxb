package com.pymxb.dao.impl;


import com.pymxb.dao.IAccountDao;
import com.pymxb.domain.Account;
import com.pymxb.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 账户的持久层实现类
 *
 * 1、配置了connectionUtils，然后注入
 * 2、查询时，增加connectionUtils.getThreadConnection() 作为参数
 *    使语句执行时Dao 有connection 支持，且QueryRunner 在配置时（配置文件）由于没有使用配置文件进行注入数据源，所以不会从数据源中获取数据连接有connection
 * 3、通过 connectionUtils 把连接和线程绑定
 * 4、且编写了事务管理
 *
 * 5、 把所有编写的依赖都注入，交给 spring来进行管理
 *    1、配置connection工具类  配置了connectionUtils
 *       由于connectionUtils  中需要一个数据源，所以直接把数据源注入到connectionUtils 中
 *     <bean id="connectionUtils" class="com.pymxb.utils.ConnectionUtils">
 *         <property name="dataSource" ref="dataSource"></property>
 *     </bean>
 *    2、配置了connectionUtils之后，谁在使用呢？
 *       由于Dao 中执行操作时要使用connection ，所以，直接注入到Dao中
 *        <property name="connectionUtils" ref="connectionUtils"></property>
 *    3、业务层中需要一个事务管理器，所以接下来把事务管理器注入到业务管理层中
 *       1、由于TransactionManager 中执行操作时要使用connection ，所以，直接把connectionUtils注入到TransactionManager中
 *          <bean id="txManager" class="com.pymxb.utils.TransactionManager">
*              <property name="connectionUtils" ref="connectionUtils"></property>
*          </bean>
 *        2、最后给业务层Service 中  注入事务管理器
 *        <property name="txManager" ref="txManager"></property>
 *
 */
@Repository
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    private QueryRunner runner;

    /**
     * 注入工具类，从线程中获取数据连接
     */
    @Autowired
    private ConnectionUtils connectionUtils;

    @Override
    public List<Account> findAllAccount() {
        try{
            return runner.query(connectionUtils.getThreadConnection(),"select * from account",new BeanListHandler<Account>(Account.class));
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountById(Integer accountId) {
        try{
            return runner.query(connectionUtils.getThreadConnection(),"select * from account where id = ? ",new BeanHandler<Account>(Account.class),accountId);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAccount(Account account) {
        try{
            runner.update(connectionUtils.getThreadConnection(),"insert into account(name,money)values(?,?)",account.getName(),account.getMoney());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(Account account) {
        try{
            runner.update(connectionUtils.getThreadConnection(),"update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAccount(Integer accountId) {
        try{
            runner.update(connectionUtils.getThreadConnection(),"delete from account where id=?",accountId);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Account findAccountByName(String accountName) {
        try{
            List<Account> accounts = runner.query(connectionUtils.getThreadConnection(),"select * from account where name = ? ",new BeanListHandler<Account>(Account.class),accountName);
            if(accounts == null || accounts.size() == 0){
                return null;
            }
            if(accounts.size() > 1){
                throw new RuntimeException("结果集不唯一，数据有问题");
            }
            return accounts.get(0);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
