package com.powernode.leetcode;


import com.powernode.leetcode.doudizhu.Card;

import java.lang.reflect.Proxy;

/**
 * @Author: 19599
 * @Date: 2025/9/17 23:50
 * @Description:
 */
public class StringTest {
    public static void main(String[] args) {
        final String a = "a";
        final String b = "bb";
        String c = a + b;
        String d = "abb";
        System.out.println(c == d);


    }
}
