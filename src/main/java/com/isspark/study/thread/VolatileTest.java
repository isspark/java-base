package com.isspark.study.thread;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * <p>
 * TODO(一句话描述该类的功能)
 * </p>
 *
 * @author xuzheng
 * @since 2020/6/11 23:42
 */
public class VolatileTest {

    public static void main(String[] args) {
//        VolatileThread thread = new VolatileThread();
//        thread.start();
//        while (true){
////            System.out.println(thread.isFlag());
//            if(thread.isFlag()){
//                System.out.println("stop run，flag:"+thread.isFlag());
//                break;
//            }
//        }

        new Thread(()->{
            VolatileThread2.two();
        }).start();
        new Thread(()->{
            VolatileThread2.one();
        }).start();
//        new Thread(() -> {
//            IntStream.range(1,1000).forEach(i -> VolatileThread2.one());
//        }).start();
//        new Thread(() ->{
//            IntStream.range(1,1000).forEach(i -> VolatileThread2.two());
//        }).start();
    }

}

class VolatileThread2{

    static int i = 0;
    static int j = 0;

    static void one(){
        i++;
        j++;
    }

    static void two(){
        System.out.println("i=" + i + " j=" + j);
    }
}

class VolatileThread extends Thread{
    private boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread wake up...");
        flag = true;
        System.out.println("update flag:"+ flag);
    }
}
