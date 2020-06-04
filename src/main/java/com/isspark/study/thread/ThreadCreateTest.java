package com.isspark.study.thread;

import java.util.concurrent.Callable;

/**
 * @version V1.0
 * @class: ThreadCreateTest
 * @description:
 * @author: xuzheng
 * @create: 2020-06-04 17:05
 **/
public class ThreadCreateTest {
    public static void main(String[] args) {
        Thread thread = new ThreadDemo("001");
        thread.start();

        Runnable runnable = new RunnalbeDemo("002");
        new Thread(runnable).start();

        CallableDemo callable = new CallableDemo("003");
        System.out.println(callable.call());
    }
}

class CallableDemo implements Callable<String>{

    private String name;

    public CallableDemo(String name) {
        this.name = name;
    }

    @Override
    public String call() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.name;
    }
}

class RunnalbeDemo implements Runnable{

    private String name;

    public RunnalbeDemo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.name);
    }
}

class ThreadDemo extends Thread{

    private String name;

    public ThreadDemo(String name) {
        this.name = name;
    }

    @Override
    public void run(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.name);
    }
}
