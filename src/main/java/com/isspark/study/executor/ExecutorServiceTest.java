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

        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        BlockingQueue<Runnable> linkedBlockingDeque = new LinkedBlockingDeque<Runnable>(
                100);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(5,10, 0L,TimeUnit.MICROSECONDS,linkedBlockingDeque);

        //不建议使用Executors创建线程池
        //ExecutorService executorService =  Executors.newCachedThreadPool();
//        pool.submit(new PoolTest());
        pool.execute(new PoolTest());
        pool.shutdown();
    }


}

class PoolTest implements Runnable{

    @Override
    public void run() {
        System.out.println("Hello,World!");
    }
}
