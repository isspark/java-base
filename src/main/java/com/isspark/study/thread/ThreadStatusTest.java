package com.isspark.study.thread;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @version V1.0
 * @class: ThreadStatusTest
 * @description:
 * @author: xuzheng
 * @create: 2020-06-04 16:01
 **/
public class ThreadStatusTest {

    public static void main(String[] args) {
        Thread.State[] status = Thread.State.values();
        Arrays.asList(status).forEach( tmp -> System.out.println(tmp));
        System.out.println(int2iP(1158L));
    }

    /**
     * 整型解析为IP地址
     * @param num
     * @return
     */
    public static String int2iP(Long num)
    {
        String str = null;
        Long[] tt = new Long[4];
        tt[0] = (num >>> 24) >>> 0;
        tt[1] = ((num << 8) >>> 24) >>> 0;
        tt[2] = (num << 16) >>> 24;
        tt[3] = (num << 24) >>> 24;
        str = (tt[0]) + "." + (tt[1]) + "." + (tt[2]) + "." + (tt[3]);
        return str;
    }
}
