package com.isspark.study.thread;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @version V1.0
 * @class: ThreadLocalTest
 * @description:
 * @author: xuzheng
 * @create: 2020-04-08 09:45
 **/
public class ThreadLocalTest {

    public static void main(String[] args) {
        final ThreadLocal threadLocal = ThreadLocal.withInitial(() -> "Hello World！");
//        threadLocal.set("Hello World !");
        System.out.println("main thread:" + threadLocal.get());



//        new Thread(() -> {
//            threadLocal.set("world1");
//            System.out.println("threaed1 running :" + threadLocal.get());
//        }).start();
//
//        new Thread(() -> {
//            threadLocal.set("world2");
//            System.out.println("threaed2 running :" + threadLocal.get());
//        }).start();

//        System.out.println(get());
//        System.out.println(get());
//        System.out.println(get());
        IntStream.range(0, 3).forEach(i -> {
            new Thread(() -> {
                threadLocal.set(i);
                System.out.println("线程"+i+":"+threadLocal.get());
                threadLocal.remove();
                System.out.println("线程"+i+"清除后:"+threadLocal.get());
            }).start();
        });

//        new Thread(() -> {
//            System.out.println(get());
//        }).start();
//        new Thread(() -> {
//            System.out.println(get());
//        }).start();

    }

    // Atomic integer containing the next thread ID to be assigned
    private static final AtomicInteger nextId = new AtomicInteger(0);

    // Thread local variable containing each thread's ID
    private static final ThreadLocal<Integer> threadId =
            new ThreadLocal<Integer>() {
                @Override
                protected Integer initialValue() {
                    return nextId.getAndIncrement();
                }
            };

    // Returns the current thread's unique ID, assigning it if necessary
    public static int get() {
        return threadId.get();
    }
}
