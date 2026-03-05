package com.zy.demo.concurrency.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo implements Callable<Thread> {
    @Override
    public Thread call() throws Exception {
        return Thread.currentThread();
    }

    public static void main(String[] args) {
        FutureTask<Thread> futureTask = new FutureTask<>(new CallableDemo());
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            System.out.println(futureTask.get().getName());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
