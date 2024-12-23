package com.powernode.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: RG
 * @Package: com.powernode.collection
 * @name: TestArrayList
 * @Date: 2024/11/13 20:30
 *
 * 1. Arraylist集合的无参数构造方法，默认初始化的容量是0
 *
 *
 *
 */
public class TestArrayList {
    @Test
    public void test1() {
        List<String> names = new ArrayList<>();
        names.add("zhangsan");
        names.add("zhangsan");

        String original = names.set(1, "lisi");
        System.out.println(original);
        System.out.println(names);

        names.add(2, "zhangsan");
        System.out.println(names);

        names.remove("zhangsan");
        System.out.println(names);


        // int newCapacity = ***
        // elementData = Arrays.copyOf(elementData, newCapacity);


        // System.arraycopy(elementData, index, elementData, index + 1, s - index);

        int[] a = new int[]{0, 1, 2, 3, 4, 5, 0, 0, 0, 0};
        System.out.println(Arrays.toString(a));
        System.arraycopy(a, 2, a, 3, 3);
        System.out.println(Arrays.toString(a));

    }
}
