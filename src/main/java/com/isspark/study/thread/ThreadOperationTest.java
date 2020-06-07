package com.isspark.study.thread;

public class ThreadOperationTest {

    public static void main(String[] args) {
        Thread thread1 = new ThreadOptDemo("001");
        thread1.start();
    }
}
class ThreadOptDemo extends Thread {

    private String name;

    public ThreadOptDemo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread name:" + this.name);
    }
}