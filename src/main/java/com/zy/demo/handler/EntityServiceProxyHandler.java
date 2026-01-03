package com.zy.demo.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 实体服务代理处理器
 *
 * @author zy
 */
public class EntityServiceProxyHandler implements InvocationHandler {

    /**
     * 目标对象
     */
    private Object target;

    public EntityServiceProxyHandler(Object target) {
        this.target = target;
    }

    /**
     * 增强目标方法
     *
     * @param proxy  代理对象
     * @param method 对象调用的方法
     * @param args   参数
     * @return 对象调用方法的返回
     * @throws Throwable 异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //前置拦截
        if (args[0] == null) {
            System.out.println("拦截");
            return null;
        }
        //调用对象方法
        Object object = method.invoke(this.target, args);
        //后置增强
        System.out.println("打印日志：" + object);
        return object;
    }
}
