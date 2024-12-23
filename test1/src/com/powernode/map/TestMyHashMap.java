package com.powernode.map;

import com.powernode.Address;
import com.powernode.IntegerTest;
import com.powernode.User;
import org.junit.jupiter.api.Test;

/**
 * @Author: RG
 * @Package: com.powernode.map
 * @name: TestMyHashMap
 * @Date: 2024/11/19 1:11
 */
public class TestMyHashMap {
    @Test
    public void testMyHashMap1() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("11", "a");
        map.put("22", "b");
        map.put("33", "c");
        map.put("44", "d");
        map.put("44", "dddd");
        map.put(null, "e");
        map.put(null, "eee");

        System.out.println(map);

        System.out.println(map.get("11"));
        System.out.println(map.get(null));
    }

    @Test
    public void testMyHashMap2() {
        MyHashMap<Address, String> map = new MyHashMap<>();
        Address a1 = new Address("nanjing", "jianging");
        Address a2 = new Address("beijing", "jianging");
        Address a3 = new Address("dongjing", "jianging");
        Address a4 = new Address(null, "jianging");
        Address a33 = new Address("dongjing", "jianging");

        map.put(a1, "a1");
        map.put(a2, "a2");
        map.put(a3, "a3");
        map.put(a4, "a4");
        map.put(a33, "a33");

        System.out.println(map);
    }

    @Test
    public void testMyHashMapa() {
        MyHashMap1<String, String> map = new MyHashMap1<>();
        map.put("11", "aa");
        map.put("22", "bb");
        map.put("33", "cc");
        map.put("44", "dd");
        map.put(null, "dd");
        map.put(null, "ddddd");

        System.out.println(map.size());

        System.out.println(map.get(null));
    }

    @Test
    public void testMyHashMapb() {
        MyHashMap1<UserDemo, String> map = new MyHashMap1<>();

        UserDemo user1 = new UserDemo("zhangsan", 11);
        UserDemo user2 = new UserDemo("lisi", 22);
        UserDemo user3 = new UserDemo("wangwu", 33);
        UserDemo user4 = new UserDemo("zhaoliu", 4);

        map.put(user1, "aaa");
        map.put(user2, "bbb");
        map.put(user3, "ccc");
        map.put(user4, "ddd");

        UserDemo user5 = new UserDemo("zhangsan", 11);
        map.put(user5, "*****");


        System.out.println(map.size());
        System.out.println(map);

        System.out.println(map.get(user1));
    }
}
