package com.zy.demo.filter;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * 回调过滤器
 *
 * @author zy
 */
public class EntityServiceCallbackFilter implements CallbackFilter {
    /**
     * 过滤要执行的拦截器
     *
     * @param method 目标方法
     * @return int值，表示在多个回调拦截器中选择执行的拦截器数组index
     */
    @Override
    public int accept(Method method) {
        if ("addEntity".equals(method.getName())) {
            return 0;
        }
        return 1;
    }
}
