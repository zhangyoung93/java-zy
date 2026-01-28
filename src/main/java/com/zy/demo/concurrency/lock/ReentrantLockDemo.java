package com.zy.demo.concurrency.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock
 *
 * @author zy
 */
public class ReentrantLockDemo {

    /**
     * 线程数
     */
    private static final int THREAD_NUM = 100;

    /**
     * 计数器，用于等待线程执行完成
     */
    private static final CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(THREAD_NUM);

    /**
     * 初始化ReentrantLock，设置公平锁
     */
    private final ReentrantLock reentrantLock = new ReentrantLock(true);

    /**
     * 线程等待队列
     */
    private final Condition condition = reentrantLock.newCondition();

    /**
     * 共享计数器
     */
    private int count = 0;

    public int getCount() {
        return this.count;
    }

    public void execute() throws Exception {
        //lock方法要放到try外边，否则finally释放未获取到的锁会异常
        this.reentrantLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "获取锁，" + this.reentrantLock.getHoldCount());
            this.reentrantLock.lock();
            //获取锁，可被中断
            this.reentrantLock.lockInterruptibly();
            //尝试获取锁，5秒超时
            this.reentrantLock.tryLock(5, TimeUnit.SECONDS);
            //释放锁，线程进入等待队列
            condition.await();
            //从等待队列中唤醒一个线程
            condition.signal();
            try {
                this.count++;
                System.out.println(Thread.currentThread().getName() + "获取锁，" + this.reentrantLock.getHoldCount());
            } finally {
                this.reentrantLock.unlock();
                System.out.println(Thread.currentThread().getName() + "释放锁，" + this.reentrantLock.getHoldCount());
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        } finally {
            this.reentrantLock.unlock();
            System.out.println(Thread.currentThread().getName() + "释放锁，" + this.reentrantLock.getHoldCount());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();
        for (int i = 0; i < THREAD_NUM; i++) {
            new Thread(() -> {
                try {
                    reentrantLockDemo.execute();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    //表示当前线程已执行完成
                    COUNT_DOWN_LATCH.countDown();
                }
            }, "thread-" + i).start();
        }
        //等待线程全部执行完成
        COUNT_DOWN_LATCH.await();
        System.out.println(reentrantLockDemo.getCount());
    }
}
