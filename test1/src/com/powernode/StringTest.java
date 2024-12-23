package com.powernode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: RG
 * @Package: com.powernode
 * @name: StringTest
 * @Date: 2024/9/27 21:34
 */
public class StringTest {

    @Test
    public void stringTest() {
        String s1 = "abc";
        String s2 = "ABC";
        String s3 = "abcABC";
        String s4 = "adcadcadc";
        String number = "012345678910";

        System.out.println(s4.indexOf("d",5));
        System.out.println(s4.lastIndexOf("ad"));
        System.out.println(s4.lastIndexOf("ad", 5));
        System.out.println(number.lastIndexOf("3", 8));
        System.out.println(number.substring(5, 6));

        String s5 = "  asd  ";
        String s6 = "  asd  ";
        System.out.println(s5.trim());
        System.out.println(s6.strip());
        System.out.println(s6.stripTrailing());
        System.out.println(s6.stripLeading());

        String s7 = new String("abc");
        String s8 = s7.intern();
        System.out.println(s1 == s7);
        System.out.println(s1 == s8);
    }

    @Test
    public void test2() {
        // 分隔符
        String year = "2024";
        String month = "9";
        String day = "27";
        String join = String.join("-", year, month, day);
        System.out.println(join);

        List<String> res = new LinkedList<>();
        res.add(year);
        res.add(month);
        res.add(day);
        System.out.println(String.join("-", res));
    }

    @Test
    public void value() {
        String s = String.valueOf(1000);
        String s1 = null;
        String s2 = s1 + "123";
        System.out.println(s2);
        s1.equals(s2);
        StringBuilder sb = new StringBuilder();
        String s3 = new String(sb);
        String string = sb.toString();

    }

    @Test
    public void testSB() {
        StringBuilder s1 = new StringBuilder(100);
        s1.append(false);
        System.out.println(s1);

        StringBuilder s2 = new StringBuilder();
        s2.append("0123456");
        s2.replace(1,2,"asd");
        System.out.println(s2);
        s2.insert(1, ",./");
        System.out.println(s2);
        System.out.println(s2.reverse());

        int[] a = {1, 2};
        int[] ints = Arrays.copyOf(a, 4);
        System.out.println(Arrays.toString(ints));
    }

    @Test
    public void testAppend() {
        long begin = System.currentTimeMillis();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 10000000; i++) {
            s.append("1");
        }

        long end = System.currentTimeMillis();

        System.out.println(end - begin);
    }
}


