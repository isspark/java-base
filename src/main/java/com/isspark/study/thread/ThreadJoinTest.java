package com.isspark.study.thread;

/**
 * <p>
 * TODO(一句话描述该类的功能)
 * </p>
 *
 * @author xuzheng
 * @since 2020/6/7 14:21
 */
public class ThreadJoinTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new JoinThread1("001");
        Thread thread2 = new JoinThread2("002");
        thread1.start();
        thread2.start();
    }
}

class JoinThread1 extends Thread {

    private String name;

    public JoinThread1(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread name:" + this.name);
    }
}

class JoinThread2 extends Thread {

    private String name;

    public JoinThread2(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Thread name:" + this.name);
    }
}

