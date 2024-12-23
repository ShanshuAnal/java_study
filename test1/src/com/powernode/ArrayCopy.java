package com.powernode;

import java.awt.geom.Area;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * @Author: Ryan Gosling Literally me
 * @Package: com.powernode
 * @name: ArrayCopy
 * @Date: 2024/9/21 15:45
 */
public class ArrayCopy {
    public static void main(String[] args) {

        int[] a = {0, 1, 2, 3, 4, 5, 6, 7};
        int[] b = new int[a.length * 2];
        // 从 a数组的 srcPos 位置开始 复制到 b数组的 destPos位置， 长度为4
        System.arraycopy(a, 1, b, 2, 4);
        System.out.println(Arrays.toString(b));

        System.out.println("-----------------");

        int[][] nums = new int[3][];
        nums[0] = new int[]{1, 2, 3, 3};
        nums[1] = new int[]{1, 2};
        nums[2] = new int[]{3};

        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString (nums[i]));
        }

        System.out.println(Arrays.deepToString(nums));

        System.out.println("--------------------");
        /**
         * Arrays工具类
         */
        // 1. Arrays.toString()
        //    Arrays.deepToString()
        int[] arr1 = {1, 2, 2, 3, 4};
        System.out.println(arr1.toString());
        System.out.println(Arrays.toString(arr1));
        System.out.println("--------------------");

        int[][] arr2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 8, 9}
        };
        System.out.println(arr2.toString());
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.deepToString(arr2));

        System.out.println("--------------------");


        // 2. Arrays.equals(Object[] a1, Object[] a2)
        //      元素值一样但顺序不一样为false
        int[] arr3 = {1, 2, 2, 3, 4, 5};
        int[] arr4 = {1, 2, 2, 3, 4};
        int[] arr5 = {2, 1, 2, 3, 4};
        System.out.println(Arrays.equals(arr1, arr3));
        System.out.println(Arrays.equals(arr1, arr4));
        System.out.println(Arrays.equals(arr1, arr5));


        System.out.println("--------------------");

        // 3. Arrays.sort() 快排，字符串也可以

        int[] arr6 = {6, 5, 4, 3, 2, 1};
        Arrays.sort(arr6);
        System.out.println(Arrays.toString(arr6));
        String[] arr7 = {"bb", "CC", "A", "aa"};
        Arrays.sort(arr7);
        System.out.println(Arrays.toString(arr7));

        System.out.println("--------------------");

        int[][] arr8 = new int[10][];

        Arrays.sort(arr8, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        Arrays.sort(arr8, Comparator.comparingInt(aa -> aa[0]));

        Arrays.sort(arr7);

        Arrays.sort(arr7, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });




        Person p1 = new Person(1);
        Person p2 = new Person(2);
        Person p3 = new Person(3);
        Person p4 = new Person(3);
        Person p5 = new Person(4);
        Person[] arr89 = {p1, p2, p3, p4, p5};
        Arrays.sort(arr8);
        System.out.println(Arrays.toString(arr8));

        System.out.println("--------------------");



        // 4.Arrays.parallelSort() 基于分治法的归并排序，支持多核CPU排序，适合大数据量排序
        int[] arr9 = new int[100000000];
        Random random = new Random();
        for (int i = 0; i < arr9.length; i++) {
            arr9[i] = random.nextInt(100000000);
        }

        long begin = System.currentTimeMillis();
        Arrays.parallelSort(arr9);
        long end = System.currentTimeMillis();
        System.out.println(end - begin);


        System.out.println("--------------------");


        // 5. Arrays.copyOf() 数组拷贝
        int[] arr10 = {0, 1, 2, 3, 4, 5, 6, 7};
        int[] arr11 = new int[a.length * 2];

        System.arraycopy(arr10, 1, arr11, 2, 4);
        System.out.println(Arrays.toString(arr11));

        int[] temp = Arrays.copyOf(arr10, 3);
        System.out.println(Arrays.toString(temp));

        int[] temp1 = Arrays.copyOfRange(arr10, 1, 3);
        System.out.println(Arrays.toString(temp1));


    }
}
