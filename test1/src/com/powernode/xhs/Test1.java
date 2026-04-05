package com.powernode.xhs;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            if (n == 1) {
                System.out.println("NO");
                continue;
            }
            List<Integer> nums = new ArrayList<>();
            if (n % 2 == 0) {
                nums.add(2);
                n /= 2;
            }
            for (int i = 1; i < Math.sqrt(n); i += 2) {
                if (n % i == 0) {
                    nums.add(i);
                }
            }
            int sum = 0;
            for (Integer num : nums) {
                sum += num;
            }
            if (sum % 2 == 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
