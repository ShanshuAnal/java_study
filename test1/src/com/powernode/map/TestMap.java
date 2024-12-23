package com.powernode.map;

import com.powernode.Address;
import com.powernode.User;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @Author: RG
 * @Package: com.powernode.map
 * @name: TestMap
 * @Date: 2024/11/17 20:15
 */
public class TestMap {

    @Test
    public void testMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "a");

        System.out.println(map.size());

        Map<Integer, String> newMap = new HashMap<>();
        newMap.put(1, "aaa");
        map.putAll(newMap);
        System.out.println(map.size());

        newMap.put(1, "aa");



        // 根据key获得value
        String s = map.get(1);
        System.out.println(s);
        System.out.println(map.get(4));


        // 是否包含某个key、value
        System.out.println(map.containsKey(1));
        System.out.println(map.containsKey(4));

        System.out.println(map.containsValue("a"));
        System.out.println(map.containsValue("aa"));

        // 判断是否为空
        System.out.println(map.isEmpty());

        // 获取所有的value
        Collection<String> values = map.values();
        for (String value : values) {
            System.out.println(value);
        }

        System.out.println(values);

        // 根据key删除键对值
        String remove = map.remove(1);
        System.out.println(remove);

        // 通过Map的静态方法of生成新的map集合对象
        Map<Integer, String> map1 = Map.of(1, "a", 2, "b", 3, "c");

        // 清空map
        map.clear();
    }

    /**
     * 遍历方式
     */
    @Test
    public void traversal() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "a");

        System.out.println(map);

        // 1. 获取所有key，再根据key得到value
        // 获取所有key，得到key的set集合
        Set<Integer> keys = map.keySet();

        // （1）set集合实现Collections，因此可以用迭代器
        Iterator<Integer> iterator = keys.iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            String value = map.get(key);
            System.out.println(key + "=" + value);
        }

        // （2）增强for循环 for-each 实际上底层还是调用的迭代器
        for (int key : keys) {
            String value = map.get(key);
            System.out.println(key + "=" + value);
        }


        // 2. 获取所有键值对的Set视图集合  （效率高，建议使用）
        // Entry是Map的内部类
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator1 = entries.iterator();
        while (iterator1.hasNext()) {
            Map.Entry<Integer, String> entry = iterator1.next();
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "=" + value);

            System.out.println(entry);
        }


    }

    @Test
    public void test() {
        Map<Address, Integer> map = new HashMap<>();

        Address a1 = new Address("nanjing", "jianging");
        Address a2 = new Address("beijing", "tiananmen");
        Address a3 = new Address("shanghai", "nanjinglu");
        Address a4 = new Address("guangzhou", "baiyunqu");
        Address a5 = new Address("shenzhen", "longgang");
        Address a6 = new Address("chongqing", "yadong");
        Address a7 = new Address("tianjin", "hutog");
        Address a11 = new Address("nanjing", "jianging");

        System.out.println(a1.hashCode());
        System.out.println(a11.hashCode());


        map.put(a1, 1);
        map.put(a2, 2);
        map.put(a3, 3);
        map.put(a4, 4);
        map.put(a5, 5);
        map.put(a6, 6);
        map.put(a7, 7);
        map.put(a11, 11);
        map.put(null, 12);

        System.out.println(map.size());

        System.out.println(a1.equals(a11));

        Set<Map.Entry<Address, Integer>> entries = map.entrySet();
        for (Map.Entry<Address, Integer> entry : entries) {
            System.out.println(entry);
        }


    }

    @Test
    public void testModel() {
        System.out.println(-8 % 3);
    }

    /**
     * 1. 哈希表的容量都是2的次方<p>
     *    哪怕传入构造函数中的初始容量不是2的次方，内部还是会自动转换成2的次方<p>
     * 2. 原因：<p>
     *    1）提高哈希计算的效率<p>
     *       位运算肯定比取模速度快，当哈希表长度为2的次方时， hash % length = hash & length - 1<p>
     *    2）减少哈希冲突,让散列分布更加均匀<p>
     *       length - 1为奇数，那么二进制最后一位是1，和其他二进制进行与运算，结果可能是1也可能是0，这样
     *       可以减少哈希冲突，使得散列分布更加均匀<p>
     * <p>
     *       这点不加苟同，因为这个运算结果与直接取模是相同的，也就是说index计算结果是一样的，各个键值对
     *       在table中排列方式是不变的，也就不存在排列上的优化就是所谓的奇偶数平均分配
     *
     *
     */
    @Test
    public void testCapacity(){
        Map<String, Integer> map = new HashMap<>(31);
    }


}
