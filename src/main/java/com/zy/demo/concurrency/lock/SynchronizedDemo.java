package com.zy.demo.concurrency.lock;

/**
 * synchronized
 *
 * @author zy
 */
public class SynchronizedDemo {

    /**
     * 共享对象
     */
    private final Object object = new Object();

    /**
     * 锁当前实例对象
     */
    public synchronized void lockInstance() {
        System.out.println(1);
    }

    /**
     * 锁当前类对象（所有实例对象都要竞争）
     */
    public static synchronized void lockClass1() {
        System.out.println(1);
    }

    /**
     * 锁当前类对象（所有实例对象都要竞争）
     */
    public static void lockClass2() {
        synchronized (SynchronizedDemo.class) {

        }
    }

    /**
     * 锁共享对象
     */
    public void lockShare() {
        synchronized (this.object) {

        }
    }
}