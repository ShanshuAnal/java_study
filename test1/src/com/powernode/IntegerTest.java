package com.powernode;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;

/**
 * @Author: RG
 * @Package: com.powernode
 * @name: IntegerTest
 * @Date: 2024/10/14 22:11
 */


public class IntegerTest {
    @Test
    public void test() {
        int i = Integer.parseInt("123");
        System.out.println(i);
        int i1 = Integer.parseInt("123345");
        System.out.println(i1);

        // 二进制
        System.out.println(Integer.toBinaryString(i));
        // 十六进制
        System.out.println(Integer.toHexString(i));
        // 八进制
        System.out.println(Integer.toOctalString(i));


    }


    @Test
    public void test1() {
        // String -> int
        String s1 = "123";
        int i = Integer.parseInt(s1);

        // int -> String
        int i1 = 123;
        String s2 = i1 + "";
        String s3 = Integer.toString(i1);

        // Integer -> String
        Integer i2 = 123;
        // 这个好 下面那个会出现空指针异常
        String s5 = String.valueOf(i2);
        String s4 = i2.toString();

        // String -> Integer
        Integer i3 = Integer.parseInt(s1);

        // int -> Integer
        int a = 1;
        Integer b = Integer.valueOf(a);

        // Integer -> int
        int c = b.intValue();
    }

    // 大整数
    @Test
    public void testBigInteger() {
        BigInteger b1 = new BigInteger("22312321312321312312312312321312312");
        System.out.println(b1);

        BigInteger b2 = new BigInteger("2");

        System.out.println(b1.add(b2));
        System.out.println(b1.subtract(b2));
        System.out.println(b1.multiply(b2));
        System.out.println(b1.divide(b2));

        System.out.println(b1.max(b2));
        System.out.println(b1.min(b2));

        System.out.println(b1.sqrt());

        System.out.println(b1.pow(2));
    }

    // 大数字
    @Test
    public void testBigDecimal() {
        BigDecimal decimal = new BigDecimal("123456789.1234567890123");
        System.out.println(decimal);
        System.out.println(decimal.movePointLeft(2));
        System.out.println(decimal.movePointRight(2));
    }

    // 数字格式化
    @Test
    public void testDecimalFormat() {
        DecimalFormat decimalFormat = new DecimalFormat("###,###.##");
        String format = decimalFormat.format(12312123.123);
        System.out.println(format);

        DecimalFormat df = new DecimalFormat("####,####.0000");
        String format1 = df.format(123123.123);
        String format2 = df.format(123123.123123);
        System.out.println(format1);
        System.out.println(format2);
    }
}






