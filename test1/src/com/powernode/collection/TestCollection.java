package com.powernode.collection;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @Author: RG
 * @Package: com.powernode.collection
 * @name: testCollection
 * @Date: 2024/10/16 20:12
 */
public class TestCollection {

    @Test
    public void testCollection1() {
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add("123");
        collection.add(3.01);
        collection.add(false);
        collection.add(new Object());

        System.out.println(collection.size());


        Collection collection1 = new ArrayList();
        collection1.add(1223);
        collection1.add("1223");
        collection1.add(3.001);
        collection1.add(true);
        collection1.add(new Object());

        collection.addAll(collection1);
        System.out.println(collection.size());

        for (Object o : collection) {
            System.out.println(o);
        }


        System.out.println(collection1.contains(1223));

        String s1 = "123123";
        String s2 = "123123";
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2);

        String s = new String("123123");

        System.out.println(s1.equals(s));
        System.out.println(s == s1);

        DateDemo d1 = new DateDemo(2008, 1, 1);
        collection.add(d1);
        DateDemo d2 = new DateDemo(2008, 1, 1);
        System.out.println(collection.contains(d2));
        collection.remove(d2);
        System.out.println(collection.contains(d2));
        System.out.println(collection.containsAll(collection1));

        Object[] array = collection.toArray();
        for (Object o : array) {
            System.out.println(o);
        }

        collection.clear();
        System.out.println(collection.isEmpty());

    }

    /**
     * Collection的遍历/迭代
     * 迭代器
     *
     * Iterator iterator = c.iterator();
     *      获取一个迭代器，迭代器中有一个光标cursor，默认指向集合第一个元素的前面一个位置
     *
     * boolean has = iterator.hasNext();
     *      has = true  光标指向的当前位置有数据
     *      has = false 光标指向的当前位置没有数据
     *
     * Object next = iterator.next()
     *      取出当前光标指向位置的元素
     *      将光标移动下一位
     *
     */
    @Test
    public void testTraversal() {
        Collection c = new ArrayList();
        c.add(123);
        c.add("asd");
        c.add(true);
        c.add(new Object());


        Iterator iterator = c.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }


    /**
     * SqeuencedCollection接口的方法
     *      addFirst()      addLast()
     *      removeFirst()   removeLast()
     *      getFirst()      getLast()
     *      reversed()
     *
     * LinkedList ArrayList Vector Stack TreeSet 都可以用
     */
    @Test
    public void testSequencedCollection() {
         SequencedCollection sc =  new ArrayList();
         sc.add(0);
         sc.add(0);
         sc.add(0);
         sc.add(0);



         sc.addFirst(1);
        System.out.println(Arrays.toString(sc.toArray()));

        sc.addLast(2);
        System.out.println(Arrays.toString(sc.toArray()));


        System.out.println(sc.getFirst());
        System.out.println(sc.getLast());

        SequencedCollection reversed = sc.reversed();
        System.out.println(Arrays.toString(sc.toArray()));
        System.out.println(Arrays.toString(reversed.toArray()));


        sc.removeFirst();
        System.out.println(Arrays.toString(sc.toArray()));

        sc.removeLast();
        System.out.println(Arrays.toString(sc.toArray()));


        List<Object> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add(1);

        System.out.println(Arrays.toString(list.toArray()));

        List<Object> reversed1 = list.reversed();
        System.out.println(Arrays.toString(reversed1.toArray()));

        Collections.reverse(list);

        System.out.println(Arrays.toString(list.toArray()));
    }


    /**
     * 泛型定义
     */
    @Test
    public void testE() {
        Collection<DateDemo> dateDemos = new ArrayList<>();

        DateDemo d1 = new DateDemo(1, 1, 1);
        DateDemo d2 = new DateDemo(2, 2, 3);
        DateDemo d3 = new DateDemo(3, 3, 3);

        dateDemos.add(d1);
        dateDemos.add(d2);
        dateDemos.add(d3);

        Iterator<DateDemo> iterator = dateDemos.iterator();
        while (iterator.hasNext()) {
            DateDemo next = iterator.next();
            next.run();
        }

        // 在类上定义泛型 定义类型
        MyClass<String> my = new MyClass<>("zhangsan");
        MyClass<String> my1 = new MyClass<>("1");
        System.out.println(my.getName());

        MyClass1<String, Integer> my2 = new MyClass1<>("zhangsan",1);
        MyClass1<String, Integer> myClass1 = new MyClass1<>();

        // 在静态方法上定义泛型 传入类型参数
        Customer.shopping1(123);
        Customer.shopping1("asd");
        Customer.shopping1(true);

        String[] strs = {"123", "asd", ",.;"};
        Customer.print(strs);


        // 在接口上定义泛型
        Product product1 = new Product(12);
        Product product2 = new Product(15);
        System.out.println(product1.compareTo(product2));
    }

    /**
     * 泛型通配符
     * 泛型如何使用
     *
     * 1. 无限定通配符，<?>,此处的？为任意引用数据类型
     * 2. 上限通配符，  <? extends Number> 此处的 ？ 是 Number 或 其子类
     * 3. 下限通配符，  <? super Number>   此处的 ？ 是 Number 或 其父类
     */
    @Test
    public void test() {
        // 无限顶通配符对类型没要求
        print1(new ArrayList<String>());
        print1(new ArrayList<Integer>());
        print1(new ArrayList<DateDemo>());

        // 上限通配符
        // 这个只能是Number，或者Number的子类
        print2(new ArrayList<Integer>());
        print2(new ArrayList<Double>());
        print2(new ArrayList<Number>());

        // 下限通配符
        // 这里只能是String 后者 String的父类Object
        print3(new ArrayList<String>());
        print3(new ArrayList<Object>());

        print4(new ArrayList<A>());
        print4(new ArrayList<B>());
        print4(new ArrayList<C>());

        print5(new ArrayList<A>());
        print5(new ArrayList<B>());
        print5(new ArrayList<C>());

    }

    // 无限定通配符
    public static void print1(ArrayList<?> list) {

    }

    // 上限通配符
    public static void print2(ArrayList<? extends Number> list) {

    }

    // 下限通配符
    public static void print3(ArrayList<? super String> list) {

    }

    public static void print4(ArrayList<? extends A> list) {

    }

    public static void print5(ArrayList<? super C> list) {

    }


    /**
     * 集合迭代过程中的元素删除
     *
     * java.util.ConcurrentModificationException 并发修改异常
     * 一个线程负责删除，一个线程负责遍历，；当这两个线程同时执行时可能会冲突
     *
     * 解决办法：快速失败机制 —— fail-fast，只要程序发现对集合进行了并发修改，那么就会立即让其失败，以防止出现错误
     *      1. 集合中设置modCount，用于记录修改次数（增删改）
     *      2. 获取迭代器对象时，会给迭代器对象初始化一个exceptedModCount属性，并将其初始化为modCount
     *      3. 使用集合对象删除元素时，modCount++，但是迭代器中的exceptedModCount不会加 1。而当迭代器对象
     *          执行next()方法时，会校验两个值是否相等，若不想等，则会抛出ConcurrentModificationException
     *      4. 使用迭代器对象删除元素时，两个都会加一，那么自然也就不会报错了
     *
     * 即使目前还不是多线程操作，但使用迭代器进行遍历、集合进行删除，会被认定为并发修改
     * 所以使用迭代器时，删除元素也要用迭代器删除
     *      it.remove();
     *
     */
    @Test
    public void testDelete() {
        Collection<String> names = new ArrayList<>();

        names.add("ad");
        names.add("12");
        names.add("34");
        names.add("56");
        names.add("ty");

        names.remove("34");

        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            String name = it.next(); //java.util.ConcurrentModificationException 并发修改异常
//            if (name.equals("34")) {
                it.remove();
//            }
            System.out.println(name);
        }

        System.out.println(Arrays.toString(names.toArray()));
    }

    @Test
    public void test1() {
        char[][] chess = {
                {'.','Q','.','.'},
                {'.','.','.','Q'},
                {'Q','.','.','.'},
                {'.','.','Q','.'}
        };

        List<String> list = new ArrayList<>();
        for (char[] chs : chess) {
            list.add(String.valueOf(chs));
        }
        System.out.println(list.get(0));


        List<List<String>> res = new ArrayList<>();
        res.add(list);




    }

}



class A {

}

class B extends A {

}

class C extends B {

}