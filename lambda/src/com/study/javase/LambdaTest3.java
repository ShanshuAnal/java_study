package com.study.javase;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Author: 19599
 * @Date: 2024/12/3 15:29
 *
 * Lambda表达式方法引用
 * 它是为了简化lambda表达式而出现的新语法
 *
 * 1. 实例方法
 * 通过 “对象” 来调用指定的某个 “实例方法”
 * 对象::实例方法
 * 满足条件：
 * 函数式接口中的 “返回值类型和形参” 与  内部调用实例方法的 “返回值和形参” 一致
 *
 * Supplier<String> supplier1 = () -> teacher.getName();
 * Consumer<String> consumer1 = s -> System.out.println(s);
 * 形如这样，括号内的东西相同的，可以用
 *
 * <p>
 * 2. 静态方法
 * 类::静态方法
 * 满足条件：
 * 函数式接口中的 “返回值类型和形参” 与  内部调用某个类的静态方法的 “返回值和形参” 一致
 *
 *
 * 3. 特殊方法
 * 类::实例方法
 * 通过方法的第一个形参来调用指定的某个“实例方法”
 * 满足要求：
 *      把函数式接口抽象方法中的第一个形参作为方法的调用者，并且从第二个形参开始（或无参）可以对应到
 *      被调用实例方法的参数列表中，并且返回类型保持一致
 *      Comparator<Double> comparator = new Comparator<>() {
 *             @Override
 *             public int compare(Double o1, Double o2) {
 *                 return o1.compareTo(o2);
 *             }
 *         };
 *      在这里第一个形参式o1，它是方法compareTo的调用者；
 *      从第二个形参o2开始，可以对应到调用方法compareTo的参数列表；
 *      返回类型都是int，一致
 *
 *
 * 4. 构造方法
 * 类名::new
 * 满足要求：
 *      创建对象所调用构造方法的形参列表 和 函数式接口中的方法形参列表保持一致
 *      并且方法的返回值类型和创建对象的类型保持一致
 *
 * 5. 数组引用
 * 数组类型[]::new
 * 重写的方法有且只有一个整数型的参乎上，并且该参数就是用于设置数组的长度
 * 并且重写方法的返回值类型和创建数组的类型保持一致
 *
 */
public class LambdaTest3 {
    /**
     * 实例方法
     */
    @Test
    public void test1() {
        // 生产型接口
        // 匿名内部类
        Teacher teacher = new Teacher("zhangsan");
        Supplier<String> supplier = new Supplier<>() {
            @Override
            public String get() {
                return teacher.getName();
            }
        };
        System.out.println(supplier.get());

        // 以上是否符合实例方法引用
        // 函数式接口的public String get()    返回形参 String  参数 无
        // 实例方法teacher.getName()         返回形参 String  参数 无
        Supplier<String> supplier1 = () -> teacher.getName();
        System.out.println(supplier1.get());

        Supplier<String> supplier2 = teacher::getName;
        System.out.println(supplier2.get());


        Consumer<String> consumer = new Consumer<>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("你好");

        Consumer<String> consumer1 = s -> System.out.println(s);
        consumer1.accept("中国");

        Consumer<String> consumer2 = System.out::println;
        consumer2.accept("我爱你");


    }

    /**
     * 静态方法
     */
    @Test
    public void test2() {
        // 匿名内部类
        Function<Double, Long> function = new Function<>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };
        Long apply = function.apply(3.14);
        System.out.println(apply);

        // lambda
        Function<Double, Long> function1 = adouble -> Math.round(adouble);
        System.out.println(function1.apply(3.14));


        // 静态方法引用
        Function<Double, Long> function2 = Math::round;
        System.out.println(function2.apply(3.14));

        /*List<User1> res = null;

        Collections.sort(res, new Comparator<User1>() {
            @Override
            public int compare(User1 o1, User1 o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        Collections.sort(res, (o1, o2) -> o1.getAge() - o2.getAge());

        Collections.sort(res, Comparator.comparingInt(User1::getAge));*/
    }

    /**
     * 特殊方法引用
     */
    @Test
    public void test3() {
        Comparator<Double> comparator = new Comparator<>() {
            @Override
            public int compare(Double o1, Double o2) {
                return o1.compareTo(o2);
            }
        };
        int compare = comparator.compare(1.2, 2.1);
        System.out.println(compare);

        Comparator<Double> comparator1 = (o1, o2) -> o1.compareTo(o2);
        int compare1 = comparator1.compare(1.1, 2.1);
        System.out.println(compare1);

        Comparator<Double> comparator2 = Double::compareTo;
        System.out.println(comparator2.compare(1.1, 21.9));


        // 转换型函数接口
        Function<User1, String> function = new Function<User1, String>() {
            @Override
            public String apply(User1 user1) {
                return user1.getName();
            }
        };

        Function<User1, String> function1 = user1 -> user1.getName();

        Function<User1, String> function2 = User1::getName;

    }


    /**
     * 构造方法
     */
    @Test
    public void test4() {
        Supplier<User1> supplier = new Supplier<>() {
            @Override
            public User1 get() {
                return new User1();
            }
        };
        System.out.println(supplier.get());

        Supplier<User1> supplier1 = () -> new User1();
        System.out.println(supplier1.get());

        Supplier<User1> supplier2 = User1::new;
        System.out.println(supplier2.get());


        Function<String, Teacher> function = new Function<>() {
            @Override
            public Teacher apply(String s) {
                return new Teacher(s);
            }
        };

        System.out.println(function.apply("lisi"));

        Function<String, Teacher> function1 = (s) -> new Teacher(s);
        System.out.println(function1.apply("lisi"));

        Function<String, Teacher> function2 = Teacher::new;
        System.out.println(function2.apply("lsi"));
    }

    /**
     * 数组引用
     */
    @Test
    public void test5() {
        Function<Integer, int[]> function = new Function<>() {
            @Override
            public int[] apply(Integer integer) {
                return new int[integer];
            }
        };

        System.out.println(function.apply(14).length);


        Function<Integer, String[]> function1 = i -> new String[i];
        System.out.println(function1.apply(13).length);

        Function<Integer, boolean[]> function2 = boolean[]::new;
        System.out.println(function2.apply(13).length);

    }
}


class Teacher {
    private String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher(String name) {
        this.name = name;
    }
}

class User1 {
    private String name;
    private int age;

    public User1() {
    }

    public User1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User1 user1 = (User1) o;
        return age == user1.age && Objects.equals(name, user1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
