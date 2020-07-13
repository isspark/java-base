package com.isspark.study.lock;

import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

/**
 * @version V1.0
 * @class: CountDownLatchTest
 * @description:
 * @author: xuzheng
 * @create: 2020-07-10 17:30
 **/
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        //这里我们声明两个CountDownLatch，startSignal用来表示线程开始执行开关
        // doneSignal 表示线程执行完成信号
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(10);
        IntStream.range(0,10).forEach((i)->{
            new Thread(new CDLTest(startSignal,doneSignal,i)).start();
        });
        startSignal.countDown();
        doneSignal.await();
        System.out.println("all thread finshed!");
    }
}

class CDLTest implements Runnable{

    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;
    int threadNo;

    public CDLTest(CountDownLatch startSignal, CountDownLatch doneSignal, int threadNo) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
        this.threadNo = threadNo;
    }

    @Override
    public void run() {
        try {
            System.out.println("线程"+threadNo+"等待执行...");
            startSignal.await();
            System.out.println("线程"+threadNo+"开始执行...");
            doSomething();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("线程"+threadNo+"执行完成...");
            doneSignal.countDown();
        }
    }

    protected void doSomething(){
        //....
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
