package com.zy.demo.interceptor;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 默认业务拦截器
 *
 * @author zy
 */
public class DefaultServiceInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //前置检查
        System.out.println("CGLIB代理，执行默认方法：" + method.getName() + "，参数：" + Arrays.toString(objects));
        long start = System.currentTimeMillis();
        Object result = methodProxy.invokeSuper(o, objects);
        //后置增强
        long end = System.currentTimeMillis();
        System.out.println("CGLIB代理，执行默认方法：" + method.getName() + "，耗时：" + (end - start) + "ms");
        return result;
    }
}
