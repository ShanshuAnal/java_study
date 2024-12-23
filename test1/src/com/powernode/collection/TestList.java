package com.powernode.collection;



import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @Author: RG
 * @Package: com.powernode.collection
 * @name: TestKist
 * @Date: 2024/11/13 14:55
 */
public class TestList {
    /**
     * List 可重复 有序
     *
     *
     * 常见实现类：
     *      1. ArrayList ： 数组
     *      2. Vector, Stack ： 数组（线程安全）
     *      3. LinkedList ： 链表
     *
     *
     * 特有方法（都与下标有关）：
     *      1. add(index, element)
     *      2. set(index, element)
     *      3. get(index)
     *      4. remove(index) Collection中只有remove(对象)
     *      5. indexOf(Object o):获取对象o的第一次出现位置
     *      6. lastIndexOf(Object o):获取对象o的最后一次出现位置
     *      7. List<E> subList(int fromIndex, int toIndex):截取List集合生成一个新集合
     *      8. static List<E> of(Element e):静态方法，返回包含任意数量元素的不可修改(只可读)列表
     *
     *
     *
     * List接口特有的迭代方法 listIterator()
     *                    listIterator(int index) 从指定位置开始
     * 特有方法
     *      void add(E e)       将元素添加到光标指向的位置，光标再向下移动
     *      int nextIndex()     后去光标指向的那个位置的下标
     *
     *      boolean previous()  判断光标指向当前位置的上一个位置是否有元素
     *      E previous()        获取光标指向的元素，光标向前移动
     *      int previousIndex() 获取光标指向的那个位置的下标
     *
     *      void set(E e)       修改的是next()方法返回的那个数据，与remove()类似，都要先使用next()
     *
     * 排序 比较器
     * void sort(Comparator<? super E> c)
     * 它相比较于Comparable的优点在于，他对原来的类不造成影响，Comparable需要在类中实现compareTo()方法
     *
     */
    @Test
    public void test2() {
        List<Student> list = new ArrayList<>();
        list.add(new Student("c", 3));
        list.add(new Student("d", 4));
        list.add(new Student("e", 5));
        list.add(new Student("a", 1));
        list.add(new Student("b", 2));

        // 这是实现Comparable接口的方法
        Collections.sort(list, Comparator.comparingInt(Student::getAge));
        System.out.println(list);

        List<int[]> papa = new ArrayList<>();
        int[][] array = papa.toArray(new int[0][]);

        List<Integer> qwe = new ArrayList<>();

        Integer[] array1 = qwe.toArray(new Integer[0]);

        List<Integer> pa = new ArrayList<>();
        Integer[] a = pa.toArray(new Integer[0]);


        // 这是定义一个比较器的写法
//        list.sort(new StudentComparator());

        // 这是使用匿名内部类的写法 这种好点
        list.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        list.sort(new Comparator<>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        list.sort((o1, o2) -> o1.getAge() - o2.getAge());

        list.sort(Comparator.comparingInt(Student::getAge));

        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()) {
            Student next = iterator.next();
            System.out.println(next);
        }

        int[][] ints = new int[10][];
        Arrays.sort(ints, Comparator.comparingInt(aa -> aa[0]));

        // 打乱顺序
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
        Collections.shuffle(nums);
        System.out.println(nums);

        // 反转
        Collections.reverse(nums);
        System.out.println(nums);

        // 替换/填充所有元素
        Collections.fill(nums, 999);
        System.out.println(nums);

    }


    @Test
    public void test1() {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(5);

        System.out.println(nums);


        ListIterator<Integer> iterator = nums.listIterator();

        iterator.add(0);
        while (iterator.hasNext()) {
            Integer num = iterator.next();
            System.out.print(num + ",");
            if (num == 3) {
                iterator.add(4);
            }
        }

        System.out.println(nums);



        while (iterator.hasPrevious()) {
            Integer previous = iterator.previous();
            if (previous == 2) {
                iterator.add(0);
            }
        }
        System.out.print(nums);


        ListIterator<Integer> li = nums.listIterator();
        while (li.hasNext()) {
            Integer next = li.next();
            if (next == 0) {
                // index 从1开始
                System.out.println(li.nextIndex());
            }
        }
        System.out.println(nums);


        ListIterator<Integer> iterator1 = nums.listIterator();
        while (iterator1.hasNext()) {
            Integer next = iterator1.next();
            if (next == 0) {
                iterator1.set(9);
            }
        }
        System.out.println(nums);


        ListIterator<Integer> iterator2 = nums.listIterator();
        while (iterator2.hasNext()) {
            Integer next = iterator2.next();
            System.out.println(next);
            if (next == 9) {
                iterator2.remove();
            }
        }
        System.out.println(nums);
    }






}
