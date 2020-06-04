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
    }
}
