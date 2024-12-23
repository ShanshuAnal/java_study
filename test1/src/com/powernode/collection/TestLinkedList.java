package com.powernode.collection;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: RG
 * @Package: com.powernode.collection
 * @name: TestLinkedList
 * @Date: 2024/11/14 18:10
 */
public class TestLinkedList {
    @Test
    public void test(){
        List<String> list = new LinkedList<>();


        list.add("asd");
        list.add("qwe");
        list.add("zxc");

        list.set(1,"123");

        list.remove(2);

        list.add(1,"123");

        list.get(1);

        list.remove("asd");

        System.out.println(list.toString());

    }
}
