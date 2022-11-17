package com.rohim.consoleapp;

import java.util.concurrent.Callable;

public class Task1 implements Callable<String> {

    private int taskNum;

    public Task1(int taskNum) {
        this.taskNum = taskNum;
    }

    public String call() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " says: Task" + taskNum + " triggered (" + (i + 1) + ")");

            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " says: " + e.getMessage());
            }
        }

        return Thread.currentThread().getName() + " says: Task" + taskNum + " succeed";
    }
}
