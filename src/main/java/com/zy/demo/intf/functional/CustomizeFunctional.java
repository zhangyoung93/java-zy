package com.zy.demo.intf.functional;

/**
 * 自定义函数式接口
 *
 * @author zy
 */
@FunctionalInterface
public interface CustomizeFunctional<Object> {

    /**
     * 自定义函数方法
     * @return String String
     */
    Object customizeFunction();
}
