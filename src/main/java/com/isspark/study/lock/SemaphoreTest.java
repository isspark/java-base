package com.isspark.study.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @version V1.0
 * @class: SemaphoreTest
 * @description:
 * @author: xuzheng
 * @create: 2020-07-03 16:13
 **/

/**
 *
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        // 每次就餐人数
        Integer pre = 3;
        // 排队人数
        Integer max = 10;

        Semaphore semaphore = new Semaphore(pre,true);
        ExecutorService executorService = Executors.newFixedThreadPool(max);

        IntStream.range(1,10).forEach(tmp ->{
            executorService.submit(new Semaphore01(semaphore,tmp+""));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();

    }
}

class Semaphore01 implements Runnable{

    private Semaphore semaphore;

    private String name;

    public Semaphore01(Semaphore semaphore, String name) {
        this.semaphore = semaphore;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            //do something...
            Thread.sleep(3000);
            System.out.println("Thread :" + name);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

