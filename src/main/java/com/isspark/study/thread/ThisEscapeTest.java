package com.isspark.study.thread;

/**
 * @version V1.0
 * @class: ThisEscapeTest
 * @description:
 * @author: xuzheng
 * @create: 2020-06-09 11:00
 **/
public class ThisEscapeTest {

    private String name;

    public ThisEscapeTest(String name) throws InterruptedException {
        Thread test = new Thread(new ThreadThisEscape());
        test.start();
//        test.join();
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) throws InterruptedException {
        new ThisEscapeTest("a");
    }

    private class ThreadThisEscape implements Runnable {

        @Override
        public void run() {
            System.out.println(ThisEscapeTest.this.getName());
        }
    }
}
