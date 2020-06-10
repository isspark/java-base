package com.isspark.study.thread;

/**
 * <p>
 * TODO(一句话描述该类的功能)
 * </p>
 *
 * @author xuzheng
 * @since 2020/6/10 22:56
 */
public class SynchronizedTest {

    public static void main(String[] args) {
        SynchronizedTest t = new SynchronizedTest();
        synchronized(t) {
            synchronized(t) {
                System.out.println("made it!");
            }
        }
    }
}
