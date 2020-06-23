package com.isspark.study.lock;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * @version V1.0
 * @class: ReentrantLockTest
 * @description:
 * @author: xuzheng
 * @create: 2020-06-22 14:26
 **/
public class ReentrantLockTest {

    private static Lock lock = new ReentrantLock();

    private static List list = new ArrayList(30);

    final Condition notFull  = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    public static void main(String[] args) {
        Thread  thread01 = new Thread(() -> {
            lock.lock();
            try {
                IntStream.range(0,10).forEach(i ->  list.add(i) );
            }finally {
                lock.unlock();
            }
        });
        Thread  thread02 = new Thread(() -> {
            lock.lock();
            try {
                IntStream.range(10,20).forEach(i ->  list.add(i) );
            }finally {
                lock.unlock();
            }
        });

        thread01.start();
        thread02.start();

        try {
            thread01.join();
            thread02.join();
            list.forEach( data -> System.out.println(data));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

