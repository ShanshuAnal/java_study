import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @Author: 19599
 * @Date: 2024/12/4 14:29
 *
 * 获取Stream流对象的方式
 * 1. 通过Collections接口的stream()方法来获取Stream对象
 * 2. 通过Arrays类提供的方法
 * 3. 使用Stream接口提供的of(可变长度参数)方法
 *      可变长度参数可以一个一个传入，也能传一个数组进去
 *
 */
public class Test1 {
    @Test
    public void test1() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // 这个流属于顺序流，本质是单线程
        // 通过stream可以对集合内的元素进行计算，对集合内的元素不作影响
        Stream<Integer> stream = list.stream();
        System.out.println(stream);

        // 这是一个并行流，底层在计算时自动启动多线程
        // 再数据量非常庞大的时候再用
        Stream<Integer> parallelStream = list.parallelStream();
        System.out.println(parallelStream);
    }

    @Test
    public void test2() {
        int[] nums = {1, 2, 3 ,4 ,5, 1, 2, 3, 4, 5};
        IntStream stream = Arrays.stream(nums);

        String[] names = {"ad", "qwe", "fdg", "ghj"};
        Stream<String> stream1 = Arrays.stream(names);

        long[] lnums = {1L, 2L, 3L};
        LongStream stream2 = Arrays.stream(lnums);

    }

    @Test
    public void test3() {
        Stream<String> stringStream = Stream.of("12", "sdf", "fgh");
        System.out.println(stringStream);

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);
        System.out.println(integerStream);

        // false
        System.out.println(stringStream.isParallel());

        // 变成并行流后，地址还是一样的
        Stream<String> parallel = stringStream.parallel();
        System.out.println(parallel);
        // true
        System.out.println(parallel == stringStream);
        // true
        System.out.println(parallel.isParallel());

    }
}











