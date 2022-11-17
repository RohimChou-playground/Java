package com.rohim.consoleapp;

public class Task1 implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " says: Task1 triggered (" + (i + 1) + ")");

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " says: " + e.getMessage());
            }
        }
    }
}
