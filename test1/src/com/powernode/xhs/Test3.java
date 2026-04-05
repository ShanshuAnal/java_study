package com.powernode.xhs;

import java.util.*;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            int[][] grid = new int[n + 1][n + 1];
            List<List<Integer>> adjList = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                adjList.add(new ArrayList<>());
            }

            int[] degree = new int[n + 1];

            for (int i = 1; i <= n - 1; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                adjList.get(s).add(e);
                adjList.get(e).add(s);
                degree[s]++;
                degree[e]++;
            }

            int res = 0;
            for (int dg = 4; dg >= 1; dg--) {
                List<Integer> nos = new ArrayList<>();
                for (int s = 1; s <= n; s++) {
                    if (degree[s] == dg) {
                        res += x;
                        for (int e : adjList.get(s)) {
                            degree[e]--;
                        }
                        degree[s] = -1;
                    }
                }

            }
            y = Math.max(x, y);
            for (int i = 1; i <= n; i++) {
                if (degree[i] == 0) {
                    res += y;
                }
            }
            System.out.println(res);
        }
    }
}
