package com.powernode.jd;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] shop = new int[n];
        for (int i = 0; i < n; i++) {
            shop[i] = sc.nextInt();
        }

        Map<Integer, Integer> target = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            int num = sc.nextInt();
            if (num != 0) {
                target.put(i, num);
            }
        }

        int valid = 0, minLen = Integer.MAX_VALUE;

        Map<Integer, Integer> window = new HashMap<>();
        for (int left = 0, right = 0; right < n; right++) {
            int no = shop[right];
            window.put(no, window.getOrDefault(no, 0) + 1);
            if (target.containsKey(no) && target.get(no).equals(window.get(no))) {
                valid++;
            }
            while (valid == target.size()) {
                int len = right - left + 1;
                if (len < minLen) {
                    minLen = len;
                }
                int removeNo = shop[left];
                if (target.containsKey(removeNo) && target.get(removeNo).equals(window.get(removeNo))) {
                    valid--;
                }
                window.put(removeNo, window.get(removeNo) - 1);
                left++;
            }
        }
        System.out.println(minLen == Integer.MAX_VALUE ? -1 : minLen);
    }
}
