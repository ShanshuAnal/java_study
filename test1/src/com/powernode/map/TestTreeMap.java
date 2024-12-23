package com.powernode.map;

import com.powernode.User;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @Author: RG
 * @Package: com.powernode.map
 * @name: TestTreeMap
 * @Date: 2024/11/21 15:46
 */
public class TestTreeMap {
    /**
     * TreeMap的key是可排序的（不可重复，这需要重写HashCode + equals）
     * 底层是红黑树
     */
    @Test
    public void test() {
        TreeMap<Integer, String> map = new TreeMap<>();

        map.put(3, "c");
        map.put(4, "d");
        map.put(1, "a");
        map.put(2, "b");
        map.put(2, "bb");

        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry);
        }

    }

    /**
     * TreeMap中对于非基本类型的key进行排序
     * 1. 在实体类中实现 Comparable 接口
     */
    @Test
    public void testCompare() {
        Map<UserDemo, Integer> map1 = new TreeMap<>();

        UserDemo u1 = new UserDemo("aaa", 12);
        UserDemo u2 = new UserDemo("aaa", 112);
        UserDemo u3 = new UserDemo("bb", 21);
        UserDemo u4 = new UserDemo("cc", 32);
        UserDemo u5 = new UserDemo("dd", 15);

        map1.put(u1, 1);
        map1.put(u2, 2);
        map1.put(u3, 3);
        map1.put(u4, 4);
        map1.put(u5, 5);

        Set<Map.Entry<UserDemo, Integer>> entries1 = map1.entrySet();
        for (Map.Entry<UserDemo, Integer> entry : entries1) {
            System.out.println(entry);
        }
    }

    /**
     * 2. 使用比较器 Comparator 来实现比较规则
     * (1) 构造一个比较器类
     * (2) 使用匿名内部类，这个更好
     */
    @Test
    public void testCompare1() {
        Map<UserDemo, Integer> map1 = new TreeMap<>(new Comparator<UserDemo>() {
            @Override
            public int compare(UserDemo o1, UserDemo o2) {
                if (o1.getName() == o2.getName()) {
                    return o2.getAge() - o1.getAge();
                }
                return o1.getAge() - o2.getAge();
            }
        });

        UserDemo u1 = new UserDemo("aaa", 12);
        UserDemo u2 = new UserDemo("aaa", 112);
        UserDemo u3 = new UserDemo("bb", 21);
        UserDemo u4 = new UserDemo("cc", 32);
        UserDemo u5 = new UserDemo("dd", 15);

        map1.put(u1, 1);
        map1.put(u2, 2);
        map1.put(u3, 3);
        map1.put(u4, 4);
        map1.put(u5, 5);

        System.out.println(map1);

    }

    /**
     * Map集合一族
     *
     * HashTable Properties 的 key value 均不可为null
     * TreeMap 的 key 不可以为null valye可以为null
     *
     * 其余的key value都可以为null
     */

}
