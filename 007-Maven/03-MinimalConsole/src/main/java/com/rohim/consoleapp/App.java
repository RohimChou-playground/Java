package com.rohim.consoleapp;

public class App {
    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new Task1(), "thread1");
        Thread thread2 = new Thread(new Task2(), "thread2");

        thread1.start();
        thread2.start();
    }
}
