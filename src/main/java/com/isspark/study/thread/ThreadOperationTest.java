package com.isspark.study.thread;

import java.util.Arrays;

/**
 * <p>
 * TODO(一句话描述该类的功能)
 * </p>
 *
 * @author xuzheng
 * @since 2020/6/6 23:48
 */
public class ThreadOperationTest {

    public static void main(String[] args) {
        Thread thread1 = new ThreadDemo2("001");
//        Thread thread2 = new ThreadDemo2("002");
//        Thread thread3 = new ThreadDemo2("003");
//        Thread thread4 = new ThreadDemo2("004");
        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();
        System.out.println(Thread.activeCount());

        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName());

//        Thread.dumpStack();

        Thread[] threads = {};
        Thread.enumerate(threads);
        System.out.println("threads size:" + threads.length);
        Arrays.asList(threads).forEach(tmp -> System.out.println(tmp.getName()));
    }

}

class ThreadDemo2 extends Thread{

    private String name;

    public ThreadDemo2(String name) {
        this.name = name;
    }

    @Override
    public void run(){
        try {
            System.out.println(name+"(before sleep):"+Thread.activeCount());
            Thread[] threads = {};
            Thread.enumerate(threads);
            System.out.println("threads size:" + threads.length);
            Thread.sleep(3000);
            System.out.println(name+"(after sleep):"+Thread.activeCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread name:"+this.name);
    }
}
