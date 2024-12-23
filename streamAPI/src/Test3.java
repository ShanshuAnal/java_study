import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: 19599
 * @Date: 2024/12/4 16:16
 * <p>
 * 触发终止操作时才会真正地执行中间操作，种植操作执行完毕后会返回计算结果
 * 种植操作执行完毕之后，相应的Stream就失效了
 * <p>
 * 终止操作
 * 1. 遍历 forEach
 * 2. 匹配 match
 * 3. 规约 reduce
 * 4. 收集 collect
 * （1）归集 toList/toSet/toMap
 * （2）统计 count/averaging
 * （3）分组 groupingBy
 * （4）结合 joining
 */
public class Test3 {
    /**
     * 匹配 match
     */
    @Test
    public void test1() {
        // 匹配集合中元素是否都是3
        boolean b = Stream.of(1, 2, 3, 4, 5).allMatch(integer -> integer.equals(3));
        System.out.println(b);
        boolean b1 = Stream.of(3, 3, 3, 3, 3).allMatch(integer -> integer.equals(3));
        System.out.println(b1);

        // 匹配集合中元素是否包含3
        // true
        System.out.println(Stream.of(1, 2, 3, 4, 5, 6, 3).anyMatch(integer -> integer.equals(3)));
        // false
        System.out.println(Stream.of(1, 2, 3, 4, 5, 6).noneMatch(integer -> integer.equals(3)));

        System.out.println(Stream.of(1, 2, 3, 4).findFirst().get());

        // 学生的名字是不是全是zhangsan
        boolean b2 = StudentService.getStudent()
                .stream()
                .allMatch(student -> "zhangsan".equals(student.getName()));
        System.out.println(b2);

        // 学生的名字里是不是没有zhangsan
        boolean b3 = StudentService.getStudent()
                .stream()
                .noneMatch(student -> "zhangsan".equals(student.getName()));
        System.out.println(b3);

        // 获得第一个学生
        Optional<Student> first = StudentService.getStudent()
                .stream()
                .findFirst();

        if (first.isPresent()) {
            Student student = first.get();
//            System.out.println(student);
        }

        first.ifPresent(System.out::print);

    }


    /**
     * 规约 reduce
     * 归纳总结
     * 及那个所有元素按照制定的规则合并成一个结果
     */
    @Test
    public void test2() {
        // 将集合中所有元素求和
        // reduce方法实际上有两个参数，第一个是累加器，第二个是接口
        // integer是累加器的值，integer2是stream流中每个元素的值
        Integer i = Stream.of(1, 2, 3, 4, 5).reduce(Math::addExact).get();
        System.out.println(i);

        // 获取集合元素相乘结果
        System.out.println(Stream.of(2, 2, 2, 2, 2).reduce(Math::multiplyExact).get());

        // 获得最大长度的元素
        System.out.println(Stream.of("asd", "qwewe", "12312edsa")
                .reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2)
                .get());

        // 获取所有学生总年龄
        Optional<Integer> reduce = StudentService.getStudent()
                .stream()
                .map(Student::getAge)
                .distinct()
                .reduce(Math::addExact);
        reduce.ifPresent(System.out::println);

        // 获取10和集合中所有元素相加的结果
        System.out.println(Stream.of(1, 2, 3, 4, 5)
                .reduce(10, Integer::sum));


        // stream对象中的count，max，min等方法，底层调用的还是reduce
        // 获取元素个数
        long count = StudentService.getStudent()
                .stream()
                .count();
        System.out.println(count);

        // 获得年龄最大的学生
        Optional<Student> max = StudentService.getStudent()
                .stream()
                .max(Comparator.comparingInt(Student::getAge));
        max.ifPresent(System.out::println);

        //获得学生的最大年龄
        StudentService.getStudent()
                .stream()
                .map(Student::getAge)
                .max(Integer::compareTo)
                .ifPresent(System.out::println);

    }

    /**
     * 收集 Collect
     * （1）归集 toList/toSet/toMap
     * （2）统计 count/averaging
     * （3）分组 groupingBy
     * （4）结合 joining
     */
    @Test
    public void test3() {
        String ss = "12312312312";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ss);
        stringBuilder.append(ss);
        stringBuilder.append(ss);
        stringBuilder.append(ss);


        String s1 = new String("二哥");
        String intern = "二哥".intern();
        System.out.println(s1 == intern);

        // 将Stream中的数据全部收集到一个集合中，具体哪种List不知道
//        List<Integer> collect = Stream.of(1, 2, 3).collect(Collectors.toList());
        List<Integer> list = Stream.of(1, 2, 3, 4, 5, 6).toList();
        System.out.println(list);
        List<String> list1 = Stream.of("1", "2").toList();

        // 构造方法引用
        ArrayList<Integer> collect = Stream.of(1, 2, 3, 4, 5, 6)
                .collect(Collectors
                        .toCollection(ArrayList::new));

        System.out.println(collect);
        LinkedList<Integer> collect1 = Stream.of(1, 2, 3, 4, 5, 6, 7)
                .collect(Collectors
                        .toCollection(LinkedList::new));
        System.out.println(collect1);


        // 收集为Set集合，具体哪种实现方式不知道
        Set<Integer> set = Stream.of(1, 2, 3, 4, 5, 6, 6, 5, 6).collect(Collectors.toSet());
        System.out.println(set);

        // 收集为map集合
        Map<String, String> map = Stream.of("4:zhangsan", "2:lisi", "3:wanger")
                .collect(Collectors
                        .toMap(s -> s.split(":")[0],
                                s -> s.split(":")[1]));

        System.out.println(map);
        map.forEach((k, v) -> System.out.println(k + "=" + v));

        // 获得年龄小于20岁的男同学，并返回年龄降序排列后的List集合
        List<Student> collect2 = StudentService.getStudent()
                .stream()
                .filter(student -> student.getAge() < 20 && "男".equals(student.getGender()))
                .sorted((o1, o2) -> (o2.getAge() - o1.getAge()))
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(collect2);


        // 归集到数组中 toArray()
        Integer[] array = Stream.of(1, 2, 3, 4, 5, 6).toArray(Integer[]::new);
        System.out.println(Arrays.toString(array));

        String[] array1 = Stream.of("112", "1212", "121").toArray(String[]::new);
        System.out.println(Arrays.toString(array1));


        // 归集的时候进行统计
        // count 获得元素个数
        Long collect3 = Stream.of(1, 1, 1, 2, 3, 3, 4, 5, 5, 5).collect(Collectors.counting());
        System.out.println(collect3);

        // 获得学生的平均年龄
        Double collect4 = StudentService.getStudent()
                .stream()
                .collect(Collectors.averagingDouble(Student::getAge));
        System.out.println(collect4);

        System.out.println(StudentService.getStudent()
                .stream()
                .collect(Collectors.averagingDouble(Student::getAge)));

        // 获得年龄之和
        StudentService.getStudent()
                .stream()
                .map(Student::getAge)
                .reduce(Integer::sum)
                .ifPresent(System.out::println);

        Integer collect5 = StudentService.getStudent()
                .stream()
                .collect(Collectors.summingInt(Student::getAge));
        System.out.println(collect5);

        int sum = StudentService.getStudent()
                .stream()
                .mapToInt(Student::getAge)
                .sum();
        System.out.println(sum);


        // 年龄最大的学生
        StudentService.getStudent()
                .stream()
                .max(Comparator.comparingInt(Student::getAge))
                .ifPresent(System.out::println);

        StudentService.getStudent()
                .stream()
                .collect(Collectors
                        .maxBy(Comparator.comparingInt(Student::getAge)))
                .ifPresent(System.out::println);


        // 获得年龄的所有信息
        DoubleSummaryStatistics collect6 = StudentService.getStudent()
                .stream()
                .collect(Collectors
                        .summarizingDouble(Student::getAge));
        System.out.println(collect6);


        // 分组 grouping
        // 将Stream按照条件分成两个Map
        // 将学生按照性别进行分组
        Map<String, List<Student>> collect7 = StudentService.getStudent()
                .stream()
                .collect(Collectors.groupingBy(Student::getGender));
        collect7.forEach((k, v) -> System.out.println(k + "=" + v));


        // 结合 joining
        // 把Stream计算的数据按照一定的规则进行连接
        // 把学生名字连成一个字符
        String collect8 = StudentService.getStudent()
                .stream()
                .map(Student::getName)
                .collect(Collectors.joining(","));
        System.out.println(collect8);

    }


}
