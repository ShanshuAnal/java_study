package com.study.javase;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @Author: 19599
 * @Date: 2024/12/3 17:21
 *
 * lambda List、Set和Map集合遍历
 *
 * for-each
 */
public class LambdaTest4 {
    /**
     * List集合
     */
    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        // forEach方法，其参数一个函数接口：Consumer（消费性接口）
        // 匿名内部类方式
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                // integer 表示集合中的每个元素
                System.out.println(integer);
            }
        });

        // list.for
        for (Integer i : list) {
            System.out.println(i);
        }

        list.forEach(i -> System.out.println(i));

        list.forEach(System.out::println);
    }

    /**
     * Set
     */
    @Test
    public void test2() {
        TreeSet<Integer> set = new TreeSet<>(Integer::compareTo);

        set.add(1);
        set.add(5);
        set.add(2);
        set.add(3);
        set.add(4);

        set.forEach(System.out::println);
    }

    /**
     * Map
     */
    @Test
    public void test3() {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.put(4, "d");

        map.forEach(new BiConsumer<Integer, String>() {
            @Override
            public void accept(Integer integer, String s) {
                System.out.println(integer + "=" + s);
            }
        });

        map.forEach((k, v) -> System.out.println(k + "=" + v));
    }

    /**
     * removeIf() 方法
     * 在集合遍历过程中，删除符合条件的元素
     */
    @Test
    public void test4() {
        List<String> list = new ArrayList<>();

        list.add("123");
        list.add("345");
        list.add("234");
        list.add("123");

        list.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return "345".equals(s);
            }
        });

        System.out.println(list);

        // lambda
        list.removeIf(s -> "234".equals(s));
        System.out.println(list);


        // 方法引用(实例方法引用)
        list.removeIf("123"::equals);
        System.out.println(list);
    }

}
