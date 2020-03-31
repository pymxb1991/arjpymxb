package com.pymxb.controller;

import com.pymxb.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@Controller

/**
 *  ����XML ����
 *     <bean id="accountDao" class="com.pymxb.dao.impl.AccountDaoImpl" scope="" init-method="" destroy-method="">
 *         <property name="" value=""| ref="></property>
 *     </bean>
 *
 *     ���ڴ��������
 *           ���ã�����XML �����ļ��б�дһ��<bean> ��ǩʵ�ֵĹ�����һ����
 *          @Component
 *              ���ã� ���ڰѵ�ǰ�������� Spring ����
 *              ���ԣ�
 *                  value:����ָ��bean ��ID ,�����ǲ�д�ǣ�����Ĭ��ֵ�ǵ�ǰ����������ĸΪСд��
 *          @Controller
 *          @Service
 *          @Repository
 *          ��������ע�����ǵ����ú�������Component ��һģһ���ģ�
 *          �����������ע���ԭ����ʲô�أ�����������    ������spring���Ϊ������ȷ����ʹ�õ�ע�⣬ʹ���ǵ�����������������
 *     ����ע�����ݵ�
 *          ���ã�����XML �����ļ��е�<bean>��ǩ�б�д<property>������һ����
 *          @Autwired
 *              ���ã� �Զ���������ע�룬ֻҪ��������Ψһ��һ��bean �������ͺ�Ҫע��ı�������ƥ�䣬�Ϳ���ע��ɹ�
 *                    ���ioc������û���κ�bean �����ͺ�Ҫע��ı�������ƥ�䣬�򱨴�
 *                    ���ioc�������ж������ƥ��ʱ
 *             ����λ�ã������Ǳ����ϣ�Ҳ�����Ƿ�����
 *             ϸ�ڣ�   ��ʹ��ע��ע��ʱ��set�����Ͳ��Ǳ�����ˣ�
 *          @Qualifier
 *              ���ã��ڰ�������ע��Ļ���֮���ڰ�ť����ע�룬���ڸ����Աע��ʱ���ܵ���ʹ�ã������ڸ���������ע��ʱ���ԣ�
 *              ���ԣ�
 *                value  ����ָ��ע��bean  ��ID
 *             ע�⣬��ע������@Autowired ���ʹ��
 *          @Resource
 *              ���ã� ֱ�Ӱ���bean ��id ע�룬�����Զ���ʹ��
 *              ���ԣ�
 *  *                value  ����ָ��ע��bean  ��ID
 *          ��������ע�붼ֻ��ע������bean ���͵����ݣ��������������ͺ�String �����޷�ʹ������ע��ʵ�ֵġ�
 *          ���⣬�������͵�ע��ֻ��ͨ��XML��ʵ�֣�
 *  `       @Value
 *              ���ã� ����ע��������ͺ�String ���͵�����
 *              ���ԣ�
 *                   value ����ָ�����ݵ�ֵ��������ʹ��spring �е�spEL (Ҳ����spring �е�el ���ʽ)
 *                         SpEL ��д�� �� ${���ʽ}
 *
 *     ���ڸı����÷�Χ��
 *        ���ã� ����<bean>��ǩ��ʹ��scope ����ʵ�ֵĹ�����һ���ģ�
 *          Scope
 *             ���ã� ����ָ��bean�����÷�Χ
 *              ���ԣ�
 *                value ����ָ����Χ��ȡֵ������ȡֵ�� singleton    prototype
 *     �������������  �˽�
 *        ���ã� ����<bean>��ǩ��ʹ�� init-method  ��  destory-method ��������һ���ģ�
 *        PreDestory      ����
 *        PostConstruct   ��ʼ����
 */
public class AccountController {
    public static void main(String[] args) {

        //1����ȡ������������
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2������ID ��ȡBean����
        IAccountService accountService =(IAccountService)ac.getBean("accountService");
       // IAccountDao accountDao = ac.getBean("accountDaoImpl", IAccountDao.class);
        accountService.saveAccount();
       // System.out.println(accountService);

    }
}
