package com.zy.demo.concurrency;

/**
 * 死锁
 *
 * @author zy
 */
public class DeadLock {

    /**
     * 共享资源
     */
    private static final Object RESOURCE_A = new Object();
    private static final Object RESOURCE_B = new Object();

    /**
     * 设置死锁
     * 1、资源只能被一个线程持有。
     * 2、线程持有一个资源，未释放，又请求另一个资源。
     * 3、线程持有的资源不能被强制夺走。
     * 4、线程之间互相等待获取对方持有的资源。
     */
    public static void setDeadLock() {
        //线程A
        Thread threadA = new Thread(() -> {
            System.out.println("线程A等待资源A...");
            synchronized (RESOURCE_A) {
                System.out.println("线程A持有资源A，等待资源B...");
                synchronized (RESOURCE_B) {
                    System.out.println("线程A持有资源B");
                }
                System.out.println("线程A释放资源B");
            }
            System.out.println("线程A释放资源A，线程A执行完毕");
        });
        //线程B
        Thread threadB = new Thread(() -> {
            System.out.println("线程B等待资源B...");
            synchronized (RESOURCE_B) {
                System.out.println("线程B持有资源B，等待资源A...");
                synchronized (RESOURCE_A) {
                    System.out.println("线程B持有资源A");
                }
                System.out.println("线程B释放资源A");
            }
            System.out.println("线程B释放资源B，线程B执行完毕");
        });
        threadA.start();
        threadB.start();
    }

    public static void main(String[] args) {
        setDeadLock();
    }
}
