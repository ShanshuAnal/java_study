package com.powernode.dewu;

import java.util.*;

/**
 * @Author: 19599
 * @Date: 2025/10/11 11:49
 * @Description:
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node();
        }

        for (int i = 1; i <= n - 1; i++) {
            nodes[i].parentNo = sc.nextInt();
        }
        nodes[n].parentNo = -1;

        for (int i = 1; i <= n; i++) {
            nodes[i].cap = sc.nextInt();
        }

        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            Node node = nodes[i];
            int minDis = Integer.MAX_VALUE;
            int parentNo = node.parentNo;
            res[i] = parentNo;
            while (parentNo != -1) {
                Node parent = nodes[parentNo];
                int dis = Math.abs(node.cap - parent.cap);
                if (dis < minDis) {
                    minDis =dis;
                    res[i] = parentNo;
                }
                parentNo = parent.parentNo;
            }
        }

        for (int i = 1; i < n - 1 ; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.print(res[n - 1]);
    }

    static class Node {
        int cap;
        int parentNo;
    }
}
