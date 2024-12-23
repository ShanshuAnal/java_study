package com.study.javase;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: 19599
 * @Date: 2024/12/3 14:41
 *
 * Lambda表达式的使用
 * 1. lambda语法格式
 * （形参）-> （方法体）
 *
 * 2. 无返回值函数式接口
 * （1）无返回值无参数
 * （2）无返回值一个参数
 * （3）无返回值多个参数
 *
 * 3. 有返回值函数式接口
 * （1）有返回值无参数
 * （2）有返回值一个参数
 * （3）有返回值多个参数
 *
 * 4. 语法精简
 * （1）形参类型可以省略
 * （2）如果形参列表中只有一个形参，那么形参类型和小括号都可以省去(若没有参数，小括号必须有)
 * （3）如果方法体中只有一条语句，那么方法体的大括号也可以省去
 * （4）如果方法体中只有一条语句，且是return语句，那么省去大括号的同时，return也要省去
 */
public class LambdaTest2 {
    /**
     * 基本使用
     * 1. lambda语法格式
     * （形参）-> （方法体）
     */
    @Test
    public void test() {
        List<Integer> list = Arrays.asList(1, 2, 6, 7, 1, 2, 3, 4);

        Collections.sort(list, (o1, o2) -> Integer.compare(o1, o2));

        System.out.println(list);

        list.sort((o1, o2) -> (o2 - o1));

        System.out.println(list);
    }

    /**
     * 无返回值的函数式接口
     */
    @Test
    public void test1() {
        // 无参
        // 匿名内部类
        NoParamNoReturn noParamNoReturn = new NoParamNoReturn() {
            @Override
            public void run() {
                System.out.println("无返回值无参数函数式接口 匿名内部类");
            }
        };
        noParamNoReturn.run();

        // Lambda表达式
        NoParamNoReturn noParamNoReturn1 = () -> System.out.println("无返回值无参数函数式接口 lambda");

        noParamNoReturn1.run();

        // 一个参数
        // 匿名内部类
        OneParamNoReturn oneParamNoReturn = new OneParamNoReturn() {
            @Override
            public void run(int a) {
                System.out.println("无返回值一个参数函数式接口 匿名内部类:" + a);
            }
        };
        oneParamNoReturn.run(12);

        // lambda
        OneParamNoReturn oneParamNoReturn1 = a -> System.out.println("无返回值一个参数函数式接口 lambda:" + a);
        oneParamNoReturn1.run(12);


        // 多个参数
        // 匿名内部类
        ParamsNoReturn paramsNoReturn = new ParamsNoReturn() {

            @Override
            public void run(int a, int b) {
                System.out.println("无返回值多个参数函数式接口 匿名内部类:" + (a + b));
            }
        };
        paramsNoReturn.run(1, 2);

        // lambda
        ParamsNoReturn paramsNoReturn1 = (a, b) -> System.out.println("无返回值多个参数函数式接口 lambda:" + (a + b));
        paramsNoReturn1.run(1, 2);
    }

    /**
     * 有返回值的函数式接口
     */
    @Test
    public void test2() {
        // 无参数
        // 匿名内部类
        NoParamReturn noParamReturn = new NoParamReturn() {
            @Override
            public String getName() {
                return "jiege";
            }
        };
        System.out.println("有返回值无参数 匿名内部类 " + noParamReturn.getName());

        // lambda
//        NoParamReturn noParamReturn1 = () -> {
//            return "jiege";
//        };
        NoParamReturn noParamReturn1 =  () -> "jiege";
        System.out.println("有返回值无参数 lambda " + noParamReturn1.getName());


        // 一个参数
        // 匿名内部类
        OneParamReturn oneParamReturn = new OneParamReturn() {
            @Override
            public String setName(String name) {
                String s = "有返回值一个参数 匿名内部类 " + name;
                return s;
            }
        };
        System.out.println(oneParamReturn.setName("hello"));

        // lambda
        OneParamReturn oneParamReturn1 = name ->  "有返回值一个参数 lambda " + name;
        System.out.println(oneParamReturn1.setName("world"));


        // 多个参数
        // 匿名内部类
        ParamsReturn paramsReturn = new ParamsReturn() {
            @Override
            public int sum(int a, int b, int c) {
                return a + b +c;
            }
        };
        System.out.println("有返回值多个参数 匿名内部类 " + paramsReturn.sum(1, 2, 3));

        // lambda
        ParamsReturn paramsReturn1 = (a, b, c) -> (a + b+ c);

        System.out.println("有返回值多个参数 lambda " + paramsReturn1.sum(1 ,2, 3));

    }
}


/**
 * 无返回值无参数
 */
@FunctionalInterface
interface NoParamNoReturn {
    void run();
}

/**
 * 无返回值一个参数
 */
@FunctionalInterface
interface OneParamNoReturn {
    void run(int a);
}

/**
 * 无返回值多个参数
 */
@FunctionalInterface
interface ParamsNoReturn {
    void run(int a, int b);
}

/**
 * 有返回值无参数
 */
@FunctionalInterface
interface NoParamReturn {
    String getName();
}

/**
 * 有返回值一个参数
 */
@FunctionalInterface
interface OneParamReturn {
    String setName(String name);
}


/**
 * 有返回值 多个参数
 */
@FunctionalInterface
interface ParamsReturn {
    int sum(int a, int b, int c);
}
