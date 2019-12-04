package com.redstar.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @date: 2019-03-24 上午 11:00
 * @author: zhaobo0119@outlook.com
 * @Descriptopn:
 */
public class MyInvocationHeadler implements InvocationHandler {

    private Object target;

    public MyInvocationHeadler(Object target) {
        this.target = target;
    }

    /**
     * 获取被代理接口实例对象
     *
     * @param <T>
     * @return
     */
    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("----------------before----------------");
        method.invoke(target, args);
        System.out.println("----------------after----------------");
        return null;
    }
}
