package com.rohim.consoleapp;

public class Task2 implements Runnable {
    public void run() {
        try {
            String threadName = Thread.currentThread().getName();
            synchronized (SharedResource.obj2) {
                System.out.println(threadName + ": 取得 obj1 的鎖");
                Thread.sleep(1000);
                System.out.println(threadName + ": 等待 obj2 的鎖");
                synchronized (SharedResource.obj1) {
                    System.out.println(threadName + ": 取得 obj2 的鎖");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
