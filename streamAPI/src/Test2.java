import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @Author: 19599
 * @Date: 2024/12/4 14:50
 * <p>
 * 中间操作
 * 筛选 filter
 * 映射 map
 * 除重 distinct
 * 排序 sorted
 * 合并 concat
 * 截断和跳过
 */
public class Test2 {
    /**
     * 筛选 filter
     */
    @Test
    public void test1() {
        // 筛选出年龄大于二十的学生

        // filter 属于中间操作，过滤
        // forEach属于终止操作，遍历
        // filter和forEach都是Stream接口中的方法，都可以链式调用
        StudentService.getStudent()
                .stream()
                .filter(student -> student.getAge() > 20)
                .forEach(System.out::println);


        // 筛选出字符串长度大于3的元素
        Stream.of("123", "12", "qwe123", "12312", "as")
                .filter(s -> s.length() > 3)
                .forEach(System.out::println);

        // 筛选学生名字长度大于4
        StudentService.getStudent()
                .stream()
                .filter(student -> student.getName().length() > 5)
                .forEach(System.out::println);
    }

    /**
     * 映射 map  实际上就是转换
     */
    @Test
    public void test2() {
        // 将字符串中的字母全部转化为大写
        Stream.of("asqQE", "weW2", "weqWQE123$%")
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // 获取所有学生名字
        StudentService.getStudent()
                .stream()
                .map(Student::getName)
                .forEach(System.out::println);

        // 获取所有性别为男的学生的名字
        StudentService.getStudent()
                .stream()
                .filter(student -> "男".equals(student.getGender()))
                .map(Student::getName)
                .forEach(System.out::println);


        // flatMap 将多个集合中的数据合并到一个Stream中
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 6);

        Stream<List<Integer>> list11 = Stream.of(list1, list2);
        // [1, 2, 3, 4, 5, 6]
        // [1, 2, 3, 4, 5, 6] 这不是我们想要的
//        list11.forEach(System.out::println);

        list11.flatMap(List<Integer>::stream)
                .forEach(System.out::print);


    }

    /**
     * 去重 distinct
     * <p>
     * 排序 sorted
     */
    @Test
    public void test3() {
        Stream.of(1, 3, 4, 5, 6, 2, 4, 1, 4, 5, 3, 4)
                .distinct()
                .sorted()
                .forEach(System.out::print);

        // 对学生去重
        StudentService.getStudent()
                .stream()
                .distinct()
                .forEach(System.out::println);

        // 除去年龄相同的学生，然后输出学生年龄
        // 先映射，后去重
        StudentService.getStudent()
                .stream()
                .map(Student::getAge)
                .distinct()
                // 升序排序
                .sorted()
                .forEach(System.out::println);

        System.out.println("***");
        // 降序排序
        StudentService.getStudent()
                .stream()
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .distinct()
                .forEach(System.out::println);

        StudentService.getStudent()
                .stream()
                .map(Student::getAge)
                .distinct()
                .sorted((o1, o2) -> o2.compareTo(o1))
                .forEach(System.out::print);

    }

    /**
     * 合并 concat
     * <p>
     * 与flatMap不一样
     * concat是通过Stream接口对两个Stream对象进行合并的
     * flatMap是Stream对象调用来合并它内部的多个集合
     */
    @Test
    public void test4() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);
        Stream<Integer> integerStream1 = Stream.of(2, 3, 4, 5, 6);
        Stream<Integer> concat = Stream.concat(integerStream, integerStream1);
        concat.forEach(System.out::print);
    }

    /**
     * 截断limit和跳过skip
     * 跳过：跳过n个元素进行操作
     * 截断：指的是截取n个元素
     */
    @Test
    public void test5() {
        Stream.of(1, 2, 3, 4, 5, 6, 7).limit(3).forEach(System.out::print);
        System.out.println("\n****");
        Stream.of(1, 2, 3, 4, 5, 6, 7).skip(3).forEach(System.out::print);
    }

}

