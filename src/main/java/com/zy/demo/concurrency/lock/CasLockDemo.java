package com.zy.demo.concurrency.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS
 *
 * @author zy
 */
public class CasLockDemo {

    /**
     * AtomicInteger
     */
    private static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger(0);

    /**
     * 线程数
     */
    private static final int THREAD_NUM = 100;

    /**
     * 计数器，用于等待线程执行完成
     */
    private static final CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(THREAD_NUM);

    /**
     * 预期值
     */
    private int expect = 100;

    /**
     * 更新值
     */
    private int update = 101;

    public void setExpect(int expect) {
        this.expect = expect;
    }

    public void setUpdate(int update) {
        this.update = update;
    }

    public int getExpect() {
        return expect;
    }

    public int getUpdate() {
        return update;
    }

    /**
     * 线程安全原子性操作
     */
    private void function() {
        //赋值
        ATOMIC_INTEGER.set(1);
        //取值
        ATOMIC_INTEGER.get();
        //自增
        ATOMIC_INTEGER.incrementAndGet();
        //自减
        ATOMIC_INTEGER.decrementAndGet();
        //CAS，底层调用本地方法
        ATOMIC_INTEGER.compareAndSet(this.expect, this.update);
    }

    /**
     * 加锁。定义持有锁值为1，释放锁值为0
     */
    public void lock() {
        //只有0状态才能获取锁。如果获取失败则自旋
        while (!ATOMIC_INTEGER.compareAndSet(0, 1)) {
            //线程短暂让步
            Thread.yield();
        }
    }

    /**
     * 解锁。只有1状态才能释放锁
     */
    public void unlock() {
        ATOMIC_INTEGER.compareAndSet(1, 0);
    }

    /**
     * 尝试获取锁
     *
     * @return boolean
     */
    public boolean tryLock() {
        return ATOMIC_INTEGER.compareAndSet(0, 1);
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < THREAD_NUM; i++) {
            new Thread(() -> {
                try {
                    ATOMIC_INTEGER.incrementAndGet();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    //表示当前线程已执行完成
                    COUNT_DOWN_LATCH.countDown();
                }
            }, "thread-" + i).start();
        }
        COUNT_DOWN_LATCH.await();
        System.out.println("count=" + ATOMIC_INTEGER.get());
    }
}
