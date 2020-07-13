package com.isspark.study.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @version V1.0
 * @class: CountDownLatchTest2
 * @description:
 * @author: xuzheng
 * @create: 2020-07-13 14:42
 **/
public class CountDownLatchTest2 {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch doneSignal = new CountDownLatch(10);

        ExecutorService executor = Executors.newFixedThreadPool(10);
        IntStream.range(0,10).forEach((i) -> {
            executor.execute(new CDL2(doneSignal,i));
        });
        doneSignal.await();
        System.out.println("all thread finished!");
        executor.shutdown();
    }
}

class CDL2 implements Runnable{

    private final CountDownLatch doneSignal;
    private final int i;

    public CDL2(CountDownLatch doneSignal, int i) {
        this.doneSignal = doneSignal;
        this.i = i;
    }

    @Override
    public void run() {
        dowork();
        doneSignal.countDown();
    }

    void dowork(){
        System.out.println("thread "+i+" processing......");
    }
}
