package com.isspark.study.collection.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Spliterator;

/**
 * @version V1.0
 * @class: ArrayListSample
 * @description:
 * @author: xuzheng
 * @create: 2020-05-08 15:56
 **/
public class ArrayListSample {

    private static List<String> list = new ArrayList<>();

    static {
        list.add("b");
        list.add("c");
        list.add("a");
        list.add("e");
        list.add("d");
    }

    @Test
    public void removeIf(){
        List<String> tmp = new ArrayList<>(list);
        tmp.removeIf(a -> a.equals("a") || a.equals("b"));
        tmp.forEach(t -> System.out.println(t));
    }

    @Test
    public void spliterator(){
        List<String> tmp = new ArrayList<>(list);
        Spliterator<String> spliterator = tmp.spliterator();
        spliterator.forEachRemaining( a -> System.out.println(a));
    }

    @Test
    public void replaceAll(){
        List<String> tmp = new ArrayList<>(list);
        tmp.replaceAll(a -> a.equals("a")?"aa":a);
        tmp.forEach(a -> System.out.println(a));
    }

    public void synchronizedList(){
        List<String> tmp = Collections.synchronizedList(new ArrayList<>());
    }
}
