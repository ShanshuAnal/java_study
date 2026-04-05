package com.powernode.xhs;

/**
 * @Author: 19599
 * @Date: 2025/10/17 4:57
 * @Description:
 */
public class ReverseList {
    public static void main(String[] args) {
        Node node = new Node(-1, null);
        Node newHead = reverse(node);
    }

    private static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    static class Node {
        int val;
        Node next;
        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
