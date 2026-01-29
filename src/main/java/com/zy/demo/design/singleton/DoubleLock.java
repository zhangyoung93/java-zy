package com.zy.demo.design.singleton;

/**
 * 双重校验锁
 *
 * @author zy
 */
public class DoubleLock {

    /**
     * 声明对象可见性、防止指令重排序
     */
    private static volatile DoubleLock doubleLock;

    private DoubleLock() {

    }

    public static DoubleLock getInstance() {
        //对象未被实例化
        if (doubleLock == null) {
            //获取类锁，准备实例化对象
            synchronized (DoubleLock.class) {
                //判断加锁时是否有其它线程已经实例化对象
                if (doubleLock == null) {
                    /*
                        创建对象的3个步骤：
                        1、堆中分配内存空间
                        2、调用构造方法，初始化对象的成员变量
                        3、将分配好的内存地址指向对象的引用doubleLock，此时doubleLock不为null

                        JVM为了优化程序执行的性能，会进行指令重排序，可能出现1->3->2的执行顺序，
                        在doubleLock不为null时另一个线程会跳过getInstance()方法入口的null判断，
                        直接拿到未完全初始化的doubleLock，后续会发生空指针异常、数据混乱等问题。
                        因此，使用volatile修饰对象引用，一方面保证可见性，另一方面防止JVM进行指令重排序。
                     */
                    doubleLock = new DoubleLock();
                }
            }
        }
        return doubleLock;
    }
}
