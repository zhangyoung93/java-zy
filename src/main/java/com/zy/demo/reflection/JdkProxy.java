package com.zy.demo.reflection;

import com.zy.demo.handler.EntityServiceProxyHandler;
import com.zy.demo.obj.Entity;
import com.zy.demo.service.EntityService;
import com.zy.demo.service.impl.EntityServiceImpl;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 * @author zy
 */
public class JdkProxy {

    @Test
    public void jdkProxy() {
        //创建目标接口对象
        EntityService target = new EntityServiceImpl();
        //创建调用处理器
        EntityServiceProxyHandler handler = new EntityServiceProxyHandler(target);
        //创建代理对象
        EntityService proxy = (EntityService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
        //通过代理对象调用方法，即增强处理。
        proxy.addEntity(new Entity());
    }
}
