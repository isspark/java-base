package com.isspark.study.collection.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @version V1.0
 * @class: LinkedListSample
 * @description:
 * @author: xuzheng
 * @create: 2020-05-09 16:41
 **/
public class LinkedListSample {

    @Test
    public void descendingIterator(){
        List<String> tmp = new LinkedList<>();
        tmp.add("a");
        tmp.add("b");
        Iterator iterator1 = tmp.iterator();
        iterator1.forEachRemaining( a -> System.out.println(a));

        Iterator iterator2 = ((LinkedList<String>) tmp).descendingIterator();
        iterator2.forEachRemaining(a -> System.out.println(a));

        tmp.get(0);
        tmp.forEach(a -> System.out.println(a));
    }

    @Test
    public void cloneTest() {
        List<TestDTO> a = new LinkedList<>();
        a.add(new TestDTO("a"));
        a.add(new TestDTO("b"));
        a.forEach(tmp -> System.out.println(tmp));
        LinkedList<TestDTO> b = (LinkedList<TestDTO>) ((LinkedList<TestDTO>) a).clone();
        a.set(0,new TestDTO("c"));
        a.forEach(tmp -> System.out.println(tmp));
        b.forEach(tmp -> System.out.println(tmp));
    }
}

class TestDTO {

    private String id;

    public TestDTO(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TestDTO{" +
                "id='" + id + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
