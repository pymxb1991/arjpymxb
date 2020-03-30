package beanFactory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {
    private  static Properties properties;

    //���칤��ģʽ����Bean�ķ�ʽ  ������֮����������Է����Ժ�ʹ�ã����ô�����������Ӧ�õ���ģʽ

    //����һ��map  ���ڴ������Ҫ�����Ķ��󣬡������ֳ�֮Ϊ����
    private static Map<String,Object> beans;
    /**
     * ʹ�þ�̬�����Ϊ properties ����ֵ
     */
    static{
        try {
            //ʵ��������
             properties = new Properties();
             //��ȡ properties �ļ���������
             InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
             properties.load(in);

             //�������ʱstart
             //ʵ��������
             beans = new HashMap<String, Object>();
             //ȡ�������ļ������е�Key
             Enumeration<Object> keys = properties.keys();
             //����ö��
             while (keys.hasMoreElements()){
                 String key = keys.nextElement().toString();
                 //ȡ����Ӧ��ȫ������
                 String beanPath = properties.getProperty(key);
                 // ͨ�����䴴������
                 Object beanObject = Class.forName(beanPath).newInstance();

                 //��������
                 beans.put(key,beanObject);
             }

            //�������ʱend
        } catch (Exception e) {
             throw  new ExceptionInInitializerError("��ʼ�� properties  ʧ��");
        }
    }

    /**
     * ����Bean ���ƻ�ȡbean����
     * @param beanName
     * @return
     */
    public  Object getBean(String beanName){
        return beans.get(beanName);
    }

   /* *//**
     * ����Bean ���ƻ�ȡbean����
     * @param beanName
     * @return
     *//*
    public  Object getBean(String beanName){

        Object bean = null;
        try {
        //��ȡ bean ��·��
        String beanPath = properties.getProperty(beanName);
        //ͨ�����䣬Ȼ�����ʵ��������
            bean = Class.forName(beanPath).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }*/

}
