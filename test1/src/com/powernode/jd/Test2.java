package com.powernode.jd;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int z = 0; z < t; z++) {
            int n = sc.nextInt();
            if (n == 3) {
                System.out.println(0);
                continue;
            }
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            long res = 0L;
            for (int i = 0; i < n - 3; i++) {
                for (int j = i + 1; j <= n - 3; j++) {
                    int count = 0;
                    count += nums[i] == nums[j] ? 0 : 1;
                    count += nums[i + 1] == nums[j + 1] ? 0 : 1;
                    count += nums[i + 2] == nums[j + 2] ? 0 : 1;
                    res += count == 1 ? 1 : 0;
                }
            }
            System.out.println(res);
        }
    }
}


//List<int[]> list = new ArrayList<>();
//for (int i = 0; i < nums.length - 2; i++) {
//    list.add(new int[]{nums[i], nums[i + 1], nums[i + 2]});
//}
//list.sort((a, b) -> {
//    int compare = Integer.compare(a[0], b[0]);
//    if (compare != 0) {
//        return compare;
//    }
//    compare = Integer.compare(a[1], b[1]);
//    if (compare != 0) {
//        return compare;
//    }
//    return Integer.compare(a[2], b[2]);
//});
////list.forEach(a -> System.out.println(Arrays.toString(a)));
//
//for (int i = 0; i < list.size() - 1; i++) {
//    for (int j = i + 1; j < list.size(); j++) {
//        int count = 0;
//        count =
//    }
//}
//        }
//    }
//}
