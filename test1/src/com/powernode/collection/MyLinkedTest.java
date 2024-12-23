package com.powernode.collection;

/**
 * @Author: RG
 * @Package: com.powernode.collection
 * @name: MyLinkedTest
 * @Date: 2024/11/17 16:36
 */
public class MyLinkedTest {
    public static void main(String[] args) {
        MyLinked<String> list = new MyLinked<>();
        list.add("123");
        list.add("456");
        list.add("789");


        String s1 = list.set(2, "asd");
        System.out.println(s1);

        String s = list.get(2);
        System.out.println(s);

        System.out.println("**********************************");

        MyLinked1<String> list1 = new MyLinked1<>();
        list1.add("123");
        list1.add("456");
        list1.add("789");


        list1.add(1, "asd");

        System.out.println(list1.size());


        list1.remove("123");

        System.out.println(list1.get(0));

        System.out.println(list1.size());



    }
}
