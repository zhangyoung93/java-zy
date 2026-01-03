package com.zy.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解
 * 注解类型Target：FIELD表示注解作用于属性
 * 注解生命周期Retention：
 *   1、SOURCE：注解只保留在Java源文件，当Java文件编译成class文件时注解被遗弃
 *   2、CLASS：注解只保留在class文件，当JVM加载class文件时注解被遗弃。默认生命周期
 *   3、RUNTIME：注解一直保存到内存中。
 * @author zy
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Anno {

    String name();

    int length();
}
