package com.zy.demo.concurrency.thread.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 线程池
 *
 * @author zy
 */
public class ThreadPoolDemo {

    /**
     * 创建线程池
     *
     * @return ThreadPoolExecutor
     */
    public static ThreadPoolExecutor getInstance() {
        return new ThreadPoolExecutor(1, 1, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), Thread::new, new ThreadPoolExecutor.AbortPolicy());
    }

    /**
     * 向线程池提交单个任务
     */
    public static void submitOneTask() {
        ThreadPoolExecutor threadPoolExecutor = getInstance();
        //设置核心线程也有存活时间
        threadPoolExecutor.allowCoreThreadTimeOut(true);

        //执行任务，不关心结果。
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                //异常会打印，不影响主线程执行
                throw new RuntimeException("execute runnable fail");
            }
        });

        //提交任务，关心执行结果是正常还是异常，但是不关系任务返回值。
        Future<?> runnableFuture = threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                //异常不会打印，不影响主线程执行
                throw new RuntimeException("submit runnable fail");
            }
        });

        //提交任务，关心任务返回值。
        Future<Boolean> callableFuture = threadPoolExecutor.submit(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
//                throw new RuntimeException("submit callable fail");
                return true;
            }
        });

        try {
            //获取线程池执行结果。正常结束返回具体值；异常结束返回线程内部发生的异常。
            System.out.println("callableFuture=" + callableFuture.get());
            //获取线程池执行结果。正常结束返回null；异常结束返回线程内部发生的异常。
            System.out.println("runnableFuture=" + runnableFuture.get());
            //模拟测试
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            System.out.println("catch InterruptedException:" + e.getCause());
        } catch (ExecutionException e) {
            System.out.println("catch ExecutionException:" + e.getCause());
        }
    }

    /**
     * 提交批量任务
     */
    public static void submitManyTask() {
        ThreadPoolExecutor threadPoolExecutor = getInstance();

        //批量任务集合
        List<Callable<Integer>> callableList = new ArrayList<>();
        callableList.add(() -> 0);
        callableList.add(() -> 1);

        try {
            //批量任务提交，阻塞等待执行结果
            List<Future<Integer>> futureList = threadPoolExecutor.invokeAll(callableList);
            //批量任务提交，只要有一个任务完成就返回结果，并尝试取消其它未完成的任务。
            Integer result = threadPoolExecutor.invokeAny(callableList);
        } catch (InterruptedException e) {
            System.out.println("catch InterruptedException:" + e.getCause());
        } catch (ExecutionException e) {
            System.out.println("catch ExecutionException:" + e.getCause());
        }
    }

    /**
     * 线程池生命周期控制
     */
    public static void controlPool() {
        ThreadPoolExecutor threadPoolExecutor = getInstance();
        //优雅关闭线程池。不接受新任务（如果提交任务会触发拒绝策略），继续执行已有任务，已有任务完成后终止线程池。
        threadPoolExecutor.shutdown();
        //强制关闭线程池。不接受新任务（如果提交任务会触发拒绝策略），尝试停止已有任务，返回等待队列的任务。
        List<Runnable> runnableList = threadPoolExecutor.shutdownNow();
        try {
            //等待线程池终止，配合shutdown()方法使用。阻塞主线程直到超时时间，返回true表示线程池正常终止，false表示超时，线程池仍然未终止。
            boolean isFinish = threadPoolExecutor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 判断线程池状态
     */
    public static void checkPool() {
        ThreadPoolExecutor threadPoolExecutor = getInstance();
        //判断线程池是否调用shutdown()或shutdownNow()
        boolean isShutdown = threadPoolExecutor.isShutdown();
        //判断线程池任务是否完成且终止。
        boolean isTerminated = threadPoolExecutor.isTerminated();
        //判断线程池是否正在关闭，调用shutdown()但未完全终止
        boolean isTerminating = threadPoolExecutor.isTerminating();
        //获取线程池的线程数量
        int poolSize = threadPoolExecutor.getPoolSize();
        //获取线程池中正在执行任务的线程数
        int activeCount = threadPoolExecutor.getActiveCount();
        //获取线程池的等待队列，用于监控
        BlockingQueue<?> blockingQueue = threadPoolExecutor.getQueue();
    }
}
