package com.pymxb.jdbctemplate;

import com.pymxb.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * JDBC 的 crud 操作
 *
 * @author Mr.Mao
 * @date 2020/04/07
 */
public class JdbcTemplateDemo3 {
    public static void main(String[] args) {

        //1、获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2、获取Bean
        JdbcTemplate jdbcTemplate = (JdbcTemplate)ac.getBean("jdbcTemplate");
        //jdbcTemplate.execute("insert into account(name,money) values('eee',1000) ");
        //3、执行操作（带参数）

        //3.1--保存
        //jdbcTemplate.update("insert into account(name,money) values(?,?)","fff",5555f);

        //3.2--更新
       // jdbcTemplate.update("update  account set money = (?) where id =(?)","1000",5);

        //3.3--删除
       // jdbcTemplate.update("delete from account where id = (?)","5");

        //3.4--查询所有
          //众多方法分析，应该选取哪一个：首先应该考虑：我们有什么，然后考虑：我们要什么
          //我们有什么：  执行查询，那么我们有SQL语句，还有参数；  我们要什么：返回一个List 结果集
          //RowMapper 是一个接口，想要用它，只能去实现他 实现之后，把新的RowMapper对象添加进来
          //List<Account> accountList = jdbcTemplate.query("select * from account where money > ?", new AccountRowMapper(), 1000f);

          //写完上面的语句，回过头来想想，难道spring 没有一个将对象封装到集合里面的实现吗？有 BeanPropertyRowMapper
          /* List<Account> accountList = jdbcTemplate.query("select * from account where money > ?", new BeanPropertyRowMapper<Account>(Account.class), 1000f);
        for(Account account:accountList){
            System.out.println(account);
        }*/
        //查询一个
      /*  List<Account> accountList = jdbcTemplate.query("select * from account where money = ?", new BeanPropertyRowMapper<Account>(Account.class), 1000f);
        System.out.println(accountList.isEmpty() ?"没有内容":accountList.get(0));*/
        //查询返回一行一列（使用聚合函数，但不加group by子句）
        Long aLong = jdbcTemplate.queryForObject("select count(*) from account where money = ?", Long.class, 1000f);
        System.out.println(aLong);
    }
}

/**
 * 实现RowMapper
 *
 * 定义Account 的封闭策略
 */
class AccountRowMapper implements RowMapper<Account>{
    /**
     * 把结果集中的数据封闭到Account 中，然后由spring 把每个Account 加到集合中去
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setName(resultSet.getString("name"));
        account.setMoney(resultSet.getFloat("money"));
        return account;
    }
}