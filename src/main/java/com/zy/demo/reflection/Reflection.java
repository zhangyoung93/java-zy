package com.zy.demo.reflection;

import com.zy.demo.annotation.Anno;
import com.zy.demo.obj.Entity;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射
 *
 * @author zy
 */
public class Reflection {

    @Test
    public void function() {
        Class<?> clazz = null;
        Entity entity = new Entity();
        try {
            //编译阶段：根据类的全限定名称获取类对象，例如spi配置文件读取类。
            clazz = Class.forName("com.zy.demo.obj.Entity");

            //加载阶段：根据类的class静态属性获取类对象，性能高，安全性好。
            clazz = Entity.class;

            //运行阶段：根据已创建的类对象反射。包括getClass()与loadClass()方法。
            clazz = entity.getClass();
            ClassLoader classLoader = entity.getClass().getClassLoader();
            clazz = classLoader.loadClass("com.zy.demo.obj.Entity");
            //根据类对象获取对象实例
            Object object = clazz.newInstance();
            //根据类对象的无参构造方法，获取对象实例。
            Constructor<?> constructor = clazz.getConstructor();
            object = constructor.newInstance();
            //根据类对象的有参构造方法，获取对象实例。
            constructor = clazz.getConstructor(int.class, String.class);
            object = constructor.newInstance(1, "a");


            //获取类继承的父类（单继承）
            Class<?> superClazz = clazz.getSuperclass();
            //获取类实现的接口（多实现）
            Class<?>[] implInterfaces = clazz.getInterfaces();
            //根据类对象获取类的公共成员变量数组。
            Field[] fields = clazz.getFields();
            //根据类对象获取类的所有成员变量数组。不包括继承的属性。
            fields = clazz.getDeclaredFields();
            //根据类对象获取类的公共方法对象数组。
            Method[] methods = clazz.getMethods();
            //根据类对象的getMethod方法指定方法名称与入参类型获取方法对象。
            Method method = clazz.getMethod("createObj", Object.class, int.class);
            //设置请求参数args，反射调用成员方法，并获得方法的返回值。
            object = method.invoke(object, null, 1);


            //获取类的注解集合
            Annotation[] annotations = clazz.getAnnotations();
            //获取类的指定注解
            Resource resource = clazz.getAnnotation(Resource.class);
            //获取属性的注解
            Anno anno = clazz.getDeclaredField("flag").getAnnotation(Anno.class);
            //获取注解的属性
            String name = anno.name();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
