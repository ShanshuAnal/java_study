package com.powernode.xhs;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            int left = 0, right = n - 1;
            while (left <= right && s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            }
            if (left > right) {
                System.out.println(0);
                continue;
            }
            int count = 0;
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    count++;
                    while (left + 1 < right - 1 && s.charAt(left + 1) != s.charAt(right - 1)) {
                        left++;
                        right++;
                    }
                }
                left++;
                right--;
            }
            System.out.println(count);
        }
    }
}
