package beanFactory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {
    private  static Properties properties;

    //改造工厂模式创建Bean的方式  创建完之后存起来，以方便以后使用，不用创建多个，充分应用单例模式

    //定义一个map  用于存放我们要创建的对象，。我们又称之为容器
    private static Map<String,Object> beans;
    /**
     * 使用静态代码块为 properties 对象赋值
     */
    static{
        try {
            //实例化对象
            properties = new Properties();
            //获取 properties 文件的流对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            properties.load(in);

            //改造进行时start
            //实例化容器
            beans = new HashMap<String, Object>();
            //取出配置文件中所有的Key
            Enumeration<Object> keys = properties.keys();
            //遍历枚举
            while (keys.hasMoreElements()){
                String key = keys.nextElement().toString();
                //取出对应的全限类名
                String beanPath = properties.getProperty(key);
                // 通过反射创建对象
                Object beanObject = Class.forName(beanPath).newInstance();

                //加入容器
                beans.put(key,beanObject);
            }

            //改造进行时end
        } catch (Exception e) {
            throw  new ExceptionInInitializerError("初始化 properties  失败");
        }
    }

    /**
     * 根据Bean 名称获取bean对象
     * @param beanName
     * @return
     */
    public  Object getBean(String beanName){
        return beans.get(beanName);
    }

    /* *//**
     * 根据Bean 名称获取bean对象
     * @param beanName
     * @return
     *//*
    public  Object getBean(String beanName){

        Object bean = null;
        try {
        //获取 bean 的路径
        String beanPath = properties.getProperty(beanName);
        //通过反射，然后进行实例化对象
            bean = Class.forName(beanPath).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }*/

}
