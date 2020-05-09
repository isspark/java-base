package com.isspark.study.annotation;

import java.util.Calendar;

/**
 * <p>
 * TODO(一句话描述该类的功能)
 * </p>
 *
 * @author xuzheng
 * @since 2020/4/15 21:19
 */
public class AnontationTest {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020,5,4);
        System.out.println(System.currentTimeMillis());
        System.out.println(calendar.getTime());
        System.out.println(calendar.getTimeInMillis());
    }


}
