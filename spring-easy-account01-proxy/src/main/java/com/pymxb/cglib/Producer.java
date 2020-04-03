package com.pymxb.cglib;

/**
 * Producer 生产者对象
 *
 * 生产产家做做的事：销售和售后，
 * 现在产家想把销售，售后交给代理商去做；
 *
 * 代理商想去做，怎么去做呢？
 * 做为代理商有一个选择产家的准则，就是生产产家得有销售，售后
 * 用java 语言来说的标准，也就是接口；
 *      接口：定义一些规则，让别人来遵守；
 *
 * 同样生产产家要想符合代理商的要求，就必须去实现 java 定义的接口；
 */
public class Producer{
    /**
     * 销售
     * @param money
     */
    public void sealProduct(float money){
        System.out.println("销售产品，并拿到钱："+money);
    }

    /**
     * 售后
     * @param money
     */
    public void afterService(float money){
        System.out.println("提供售后服务，并拿到钱："+money);
    }
}
