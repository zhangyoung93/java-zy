package com.zy.demo.async;

import java.util.concurrent.*;

/**
 * CompletableFutureDemo
 *
 * @author zy
 */
public class CompletableFutureDemo {

    public static void main(String[] args) {
        //异步调用无返回结果的任务
        CompletableFuture<Void> task1 = CompletableFuture.runAsync(() -> {
            System.out.println("return void");
        });
        //异步调用有返回结果的任务
        CompletableFuture<Integer> task2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("return not void");
            return 1;
            //链式调用，将task2的执行结果传递给thenApply
        }).thenApply(integer -> {
            System.out.println("thenApply");
            return integer;
            //最终处理，正常/异常都会执行
        }).handle((integer, throwable) -> null);

        //组合多个任务都需要完成的条件
        CompletableFuture<Void> finalResult = CompletableFuture.allOf(task1, task2);
        //阻塞当前线程，等待满足条件
        finalResult.join();
    }
}
