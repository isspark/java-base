package com.isspark.study.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @version V1.0
 * @class: StreamTest
 * @description:
 * @author: xuzheng
 * @create: 2020-04-07 11:37
 **/
public class StreamTest {

    private static Logger logger = LoggerFactory.getLogger(StreamTest.class);

    public static void main(String[] args) {
        skip();
    }

    public static void skip(){
        List<String> strings = Arrays.asList("a", "b", "c", "d", "e", "f");
        List<String> result = strings.stream().skip(2).limit(2).collect(Collectors.toList());
        result.forEach(s -> System.out.println(s));
    }

    /**
     * 运算
     */
    public static void reduce(){
        int reduce = IntStream.range(10, 15).reduce(0, (a, b) -> {
            logger.info("a:{}", a);
            logger.info("b:{}", b);
            return a+b;
        });
        logger.info("{}", reduce);
    }

    /**
     * 过滤集合
     */
    public static void filter(){
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        // 获取空字符串的数量
        int count = (int) strings.parallelStream().filter(string -> string.equals("efg")).count();
        logger.info("{}", count);

        int num = IntStream.range(10, 15).filter(a -> a > 11).sum();
        logger.info("{}", num);
    }

    /**
     * 获取集合内对象的某个字段
     */
    public static void getOneField(){
        List<User> users = new ArrayList<>();
        users.add(new User("AA","Boy"));
        users.add(new User("BB","Girl"));
        users.add(new User("CC",20,"Boy"));
        users.add(new User("DD",22,"Girl"));

        List<String> names = users.stream().map(User::getName).collect(Collectors.toList());
        names.forEach(name -> System.out.println(name));
    }
}

class User{

    private String name;

    private Integer age = 18;

    private String sex = "Boy";

    public User(String name) {
        this.name = name;
    }

    public User(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public User(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
