package com.powernode.leetcode.meituan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: 19599
 * @Date: 2025/5/28 1:53
 * @Description:
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        // 注意 hasNext 和 hasNextLine 的区别
        while (t-- > 0) {
            int n = in.nextInt();
            String s = in.next();
            char[] chars = s.toCharArray();
            char[] sorted = s.toCharArray();
            Arrays.sort(sorted);

            List<Integer> diff = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (chars[i] != sorted[i]) {
                    diff.add(i);
                }
            }

            if (diff.isEmpty()) {
                System.out.println("NO");
            } else if (diff.size() == 2) {
                System.out.println();
                swap(chars, diff.get(0), diff.get(1));
                if (Arrays.equals(chars, sorted)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println("NO");
            }
        }
    }

    private static void swap(char[] chars, Integer integer, Integer integer1) {
        char t = chars[integer];
        chars[integer] = chars[integer1];
        chars[integer1] = t;
    }

}
