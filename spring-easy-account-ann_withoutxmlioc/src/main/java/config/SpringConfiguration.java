package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * ������һ�������࣬�������ú�bean.xml��һ����
 * spring�е���ע��
 * @Configuration
 *     ���ã�ָ����ǰ����һ��������
 *
 *     ϸ�ڣ�����������ΪAnnotationConfigApplicationContext���󴴽��Ĳ���ʱ����ע����Բ�д��
 * @ComponentScan
 *      ���ã�����ͨ��ע��ָ��spring�ڴ�������ʱҪɨ��İ�
 *      ���ԣ�
 *          value������ basePackages��������һ���ģ���������ָ����������ʱҪɨ��İ���
 *                 ����ʹ�ô�ע��͵�ͬ����xml��������:
 *                      <context:component-scan base-package="com.pymxb"></context:component-scan>
 *  Bean
 *      ���ã����ڰѵ�ǰ�����ķ���ֵ��Ϊbean�������spring��ioc������
 *      ����:
 *          name:����ָ��bean��id������дʱ��Ĭ��ֵ�ǵ�ǰ����������
 *      ϸ�ڣ�
 *          ������ʹ��ע�����÷���ʱ����������в�����spring��ܻ�ȥ�����в�����û�п��õ�bean����
 *          ���ҵķ�ʽ��Autowiredע���������һ����
 *  Import
 *      ���ã����ڵ���������������
 *      ���ԣ�
 *          value������ָ��������������ֽ��롣
 *                  ������ʹ��Import��ע��֮����Importע�����͸������࣬������Ķ�����������
 *  PropertySource
 *      ���ã�����ָ��properties�ļ���λ��
 *      ���ԣ�
 *          value��ָ���ļ������ƺ�·����
 *                  �ؼ��֣�classpath����ʾ��·����
 */
//@Configuration
@ComponentScan(basePackages = {"com.pymxb"}) //ɨ�����������������
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {

}
