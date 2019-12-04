package com.redstar.proxy;

/**
 * @date: 2019-03-24 上午 10:56
 * @author: zhaobo0119@outlook.com
 * @Descriptopn:
 */
public class ProxyMain {

    public static void main(String[] args) {
        // 保存生成的代理类的字节码文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        People proxy = new MyInvocationHeadler(new PeopleImpl()).getProxy();
        proxy.eat();
    }
}
