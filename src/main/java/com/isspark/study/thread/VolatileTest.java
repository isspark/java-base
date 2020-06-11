package com.isspark.study.thread;

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
        VolatileThread thread = new VolatileThread();
        thread.start();
        while (true){
//            System.out.println(thread.isFlag());
            if(thread.isFlag()){
                System.out.println("flag:"+thread.isFlag());
                break;
            }
        }
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
