package com.rohim.consoleapp;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadPoolExecutor;

public class App {
    public static void main(String[] args) throws InterruptedException {

        // minimum threads 0
        // maximum threads 5, (the last 3 threads would only be used, if all 6 waiting is full)
        // maximum tasks in executorService 11=(5 running + 6 waiting)\
        // threads would be closed when idle more then 3 secs 
        ArrayBlockingQueue<Runnable> abQueue = new ArrayBlockingQueue<Runnable>(6, true);
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(
            2, 5, 3L, TimeUnit.SECONDS, abQueue, new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 5; i++) {
            System.out.println("==================" + i + "===================");

            try {
                Future<String> future = executorService.submit(new Task1(i));
                System.out.println(executorService);
            } catch (RejectedExecutionException e) {
                --i;
                System.out.println(e.getMessage());
                System.out.println(executorService);
                Thread.sleep(5000);
            }
        }

        Thread.sleep(15000);
        System.out.println(executorService);
    }
}
