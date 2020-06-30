package com.isspark.study.executor;

import java.util.concurrent.*;

/**
 * @version V1.0
 * @class: ExecutorServiceTest
 * @description:
 * @author: xuzheng
 * @create: 2020-06-24 17:47
 **/
public class ExecutorServiceTest {

    public static void main(String[] args) {

//        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        BlockingQueue<Runnable> linkedBlockingDeque = new LinkedBlockingDeque<>(
                100);
        ExecutorService pool = new ThreadPoolExecutor(5,10, 2L,TimeUnit.MICROSECONDS,linkedBlockingDeque);

        Executors.newFixedThreadPool(10);
        Executors.newSingleThreadExecutor();
        Executors.newCachedThreadPool();
        Executors.newScheduledThreadPool(10);
        Executors.newSingleThreadScheduledExecutor();
        //不建议使用Executors创建线程池
        //ExecutorService executorService =  Executors.newCachedThreadPool();
//        pool.submit(new PoolTest());
        pool.execute(new PoolTest());
        Future<String> future = pool.submit(new CallableTest());

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        pool.shutdown();
    }


}

class PoolTest implements Runnable{

    @Override
    public void run() {
        System.out.println("Hello,World1!");
    }
}

class CallableTest implements Callable<String>{

    @Override
    public String call(){
        return "Hello,World2!";
    }
}
