package com.zy.demo.reflection;

import com.zy.demo.filter.EntityServiceCallbackFilter;
import com.zy.demo.interceptor.DefaultServiceInterceptor;
import com.zy.demo.interceptor.EntityServiceInterceptor;
import com.zy.demo.obj.Entity;
import com.zy.demo.service.impl.EntityServiceImpl;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import org.junit.jupiter.api.Test;

/**
 * CGLIB动态代理
 *
 * @author zy
 */
public class CglibProxy {

    @Test
    public void cglibProxy() {
        //创建增强器
        Enhancer enhancer = new Enhancer();
        //设置被代理目标类
        enhancer.setSuperclass(EntityServiceImpl.class);

        //设置单个回调拦截器
        enhancer.setCallback(new EntityServiceInterceptor());

        //设置多个回调拦截器
        Callback[] callbacks = new Callback[]{
                new EntityServiceInterceptor(),
                new DefaultServiceInterceptor()
        };
        enhancer.setCallbacks(callbacks);
        //设置回调过滤器：选择执行某个回调拦截器
        enhancer.setCallbackFilter(new EntityServiceCallbackFilter());

        //创建代理对象
        EntityServiceImpl proxy = (EntityServiceImpl) enhancer.create();

        //代理调用目标方法
        proxy.addEntity(new Entity());
        proxy.queryEntity();
    }
}
