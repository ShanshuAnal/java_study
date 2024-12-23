package com.powernode;

import org.junit.jupiter.api.Test;

/**
 * @Author: RG
 * @Package: com.powernode
 * @name: EnumTest
 * @Date: 2024/10/15 22:19
 */
public class EnumTest {

    @Test
    public void testEnum1() {
        Season i = get();
        switch (i) {
            case SPRING -> System.out.println(Season.SPRING.getDesc());
            case SUMMER -> System.out.println(Season.SUMMER.getDesc());
            case AUTUMN -> System.out.println(Season.AUTUMN.getDesc());
            case WINTER -> System.out.println(Season.WINTER.getDesc());
        }


        System.out.println(Season.getA());

        System.out.println("____________________");
        // 通过values获取所有枚举值并遍历
        Season[] values = Season.values();
        for (Season season : values) {
            System.out.println(season.name());
            System.out.println(season.getName() + "->" + season.getDesc());
            System.out.println(season.geta());
            season.eat();
            System.out.println("-----------------------------");
        }

    }

    public static Season get() {
        return Season.SPRING;
    }

}

