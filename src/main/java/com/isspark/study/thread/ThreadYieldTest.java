package com.isspark.study.thread;

/**
 * <p>
 * TODO(一句话描述该类的功能)
 * </p>
 *
 * @author xuzheng
 * @since 2020/6/7 14:21
 */
public class ThreadYieldTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new YieldThread1("001");
        Thread thread2 = new YieldThread2("002");
        thread1.start();
        thread2.start();

        thread2.join();
        thread1.interrupt();
    }
}
class YieldThread1 extends Thread{

    private String name;

    public YieldThread1(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (!this.isInterrupted()){
            System.out.println("hello world");
        }
    }
}
class YieldThread2 extends Thread{

    private String name;

    public YieldThread2(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            System.out.println(i);
            Thread.yield();
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("耗时："+ (endTime - startTime));
    }
}

