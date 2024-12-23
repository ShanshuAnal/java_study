package com.powernode;

import org.junit.jupiter.api.*;

import java.util.Random;

/**
 * @Author: Ryan Gosling Literally me
 * @Package: com.powernode
 * @name: MathTest
 * @Date: 2024/9/21 16:23
 */
public class MathTest {

    @Test
    public void testSum() {
        System.out.println("testSum");
        int acutal = Math.sum(1, 2);
        int exception = 3;
        Assertions.assertEquals(acutal, exception);
    }

    @Test
    public void testSub() {
        System.out.println("testSub");
        int acutal = Math.sub(1, 2);
        int exception = -1;
        Assertions.assertEquals(acutal, exception);
    }

    @Test
    public void testMul() {
        System.out.println("testMul");
        int acutal = Math.mul(1, 2);
        int exception = 2;
        Assertions.assertEquals(acutal, exception);
    }

    @Test
    public void testDiv() {
        System.out.println("testDiv");
        int acutal = Math.div(1, 2);
        int exception = 0;
        Assertions.assertEquals(acutal, exception);
    }

    /**
     * 这些是每个测试前面的
     */
    @BeforeAll
    public static void before() {
        System.out.println("before");
    }

    @AfterAll
    public static void after() {
        System.out.println("after");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("beforeEach");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("afterEach");
    }

    @Test
    public void testFun() {
        //向上取整
        System.out.println(java.lang.Math.ceil(4.98));

        // 向下取
        System.out.println(java.lang.Math.floor(4.98));

        // 小数四舍五入
        System.out.println(java.lang.Math.round(15));
        System.out.println(java.lang.Math.round(14));
        System.out.println(java.lang.Math.round(15.5));
        System.out.println(java.lang.Math.round(15.4));
        System.out.println(java.lang.Math.round(-15.4));



        // 随机数  [0.0, 1.0)
        double random = java.lang.Math.random();
        System.out.println(random);
        // [0, 100) 随机整数
        int i = (int) (java.lang.Math.random() * 100);
        System.out.println(i);

    }

    /**
     * 随机数
     */
    @Test
    public void testRandom() {
        Random random = new Random();

        // nextInt() 整数范围内随机整数
        System.out.println(random.nextInt());
        // nextInt(int round) [0, round)区间内的随机整数
        System.out.println(random.nextInt(6));

        // [0.0, 1.0) 的随机数
        System.out.println(random.nextDouble());


        // 生成5个不重复的随机数
        int[] a = {-1, -1, -1, -1, -1};
        int pos = 0;
        while (pos < 5) {
            int num = random.nextInt(6);
            if (!contains(a, num)) {
                a[pos++] = num;
            }
        }
        for (int i : a) {
            System.out.println(i);
        }
    }

private boolean contains(int[] a, int num) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == num) {
                return true;
            }
        }
        return false;
    }

}
