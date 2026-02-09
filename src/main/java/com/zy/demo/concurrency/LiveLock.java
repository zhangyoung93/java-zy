package com.zy.demo.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * 活锁
 *
 * @author zy
 */
public class LiveLock {

    /**
     * 共享资源
     */
    private static final Object RESOURCE = new Object();

    /**
     * 优先级
     */
    private static volatile char priority = '0';

    public static void setLiveLock() {
        Thread threadA = new Thread(() -> {
            synchronized (RESOURCE) {
                while (priority != 'A') {
                    System.out.println("线程A让步...");
                    //让步线程B执行
                    priority = 'B';
                    try {
                        TimeUnit.MILLISECONDS.sleep(100L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            System.out.println("线程A执行完毕");
        });
        Thread threadB = new Thread(() -> {
            synchronized (RESOURCE) {
                while (priority != 'B') {
                    System.out.println("线程B让步...");
                    //让步线程A执行
                    priority = 'A';
                    try {
                        TimeUnit.MILLISECONDS.sleep(100L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            System.out.println("线程B执行完毕");
        });
        //启动线程A、B
        threadA.start();
        threadB.start();
    }

    public static void main(String[] args) {
        setLiveLock();
    }
}
