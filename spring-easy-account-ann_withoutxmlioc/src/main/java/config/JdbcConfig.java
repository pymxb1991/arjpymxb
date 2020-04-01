package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

/**
 * ��spring�������ݿ���ص�������
 */
//@Configuration
public class JdbcConfig {

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    /**
     * ���ڴ���һ��QueryRunner����
     *
     *    ע�⣺
     *          1����ʹ�ö�����Դʱ��������Ƿ�����ͬ���͵�����Դ,���Ȼ���ݵ�ǰ Bean��ID ����������Դ��
     *          2��������ݵ�ǰ Bean��ID �Ҳ�����Ӧ��ͬ������Դ��Ҳ����˵��������Դʹ��@Bean ��������ƶ���һ������ô����׳��쳣
     *             expected single matching bean but found2:ds1 ds2
     *             ����������쳣��
     *                1�����԰�����Դ��������������һ������Դһ�£�
     *                2��Ҳ����ֱ��ʹ��@Qualifier���������Դ�������ã�
     *                @Qualifier
     *                     ����һ�������Ȱ�������������ע�룬
     *                     ��û������ƥ�䣬���ж������ƥ��ʱ�����β��޷��ڶ��ƥ�����ҵ��������Ƶ�ID ʱ���ͻ�ʹ��@Qualifier��ǵ�����Դ��ִ��
     * @param dataSource
     * @return
     */
    @Bean(name="runner")
    @Scope("prototype")//֧�ֶ���
    public QueryRunner createQueryRunner(@Qualifier("ds2") DataSource dataSource){
        return new QueryRunner(dataSource);
    }

    /**
     * ��������Դ����
     * @return
     */
    @Bean(name="dataSource")
    public DataSource createDataSource(){
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            //�������ݿ����������ļ�֮�󣬿���ʹ��@Value ע�� @PropertySource
       /*     ds.setDriverClass("com.mysql.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/easy");
            ds.setUser("root");
            ds.setPassword("123456"); */
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(username);
            ds.setPassword(password);
            return ds;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * ע�⣺
     *
     * ��������Դ����
     * @return
     */
    @Bean(name="ds1")
    public DataSource createDataSource1(){
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            //�������ݿ����������ļ�֮�󣬿���ʹ��@Value ע�� @PropertySource
       /*     ds.setDriverClass("com.mysql.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/easy");
            ds.setUser("root");
            ds.setPassword("123456"); */
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(username);
            ds.setPassword(password);
            return ds;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
