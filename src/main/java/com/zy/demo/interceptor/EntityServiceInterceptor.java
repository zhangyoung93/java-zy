package com.zy.demo.interceptor;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 实体服务拦截器
 *
 * @author zy
 */
public class EntityServiceInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //前置检查
        System.out.println("CGLIB代理，执行方法前：" + method.getName() + "，参数：" + Arrays.toString(objects));
        long start = System.currentTimeMillis();
        Object result = methodProxy.invokeSuper(o, objects);
        //后置增强
        long end = System.currentTimeMillis();
        System.out.println("CGLIB代理，执行方法后：" + method.getName() + "，耗时：" + (end - start) + "ms");
        return result;
    }
}
