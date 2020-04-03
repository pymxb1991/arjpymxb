package com.pymxb.proxy;

/**
 *  对生产产家要求的接口
 *
 */
public interface IProducer {
    /**
     * 销售
     * @param money
     */
    public void sealProduct(float money);

    /**
     * 售后
     * @param money
     */
    public void afterService(float money);
}
