package com.isspark.study.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @version V1.0
 * @class: ScheduledThreadPoolExecutorTest
 * @description:
 * @author: xuzheng
 * @create: 2020-06-30 11:34
 **/
public class ScheduledThreadPoolExecutorTest {

    public static void main(String[] args) {
        ScheduledExecutorService scheduled = Executors.newSingleThreadScheduledExecutor();

        //每1秒就执行任务
        scheduled.scheduleAtFixedRate(()-> System.out.println("Hello"),1000L,1000L, TimeUnit.MILLISECONDS);

        //延迟1秒执行
        scheduled.schedule(()-> System.out.println("emmm"),1000L,TimeUnit.MILLISECONDS);

        scheduled.scheduleWithFixedDelay(()-> System.out.println("hehehe"),1000L,1000L,TimeUnit.MILLISECONDS);

        scheduled.shutdown();
    }
}
