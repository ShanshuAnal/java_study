package com.powernode.leetcode.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 19599
 * @Date: 2025/6/1 14:23
 * @Description:
 */
public class LRU {
    Node head, tail;
    int capacity;
    Map<Integer, Node> map;

    public LRU(int capacity) {
        head = new Node(-1, -1, null, null);
        tail = new Node(-1, -1, null, null);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public void put(int key, int val) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            moveToHead(node);
            node.val = val;
        } else {
            Node newNode = new Node(key, val, null, null);
            map.put(key, newNode);
            addToHead(newNode);

            if (map.size() > capacity) {
                Node removeNode = removeLast();
                map.remove(removeNode.key);
            }
        }
    }

    private Node removeLast() {
        Node removeNode = tail.prev;
        removeNode(removeNode);
        return removeNode;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {

        return 0;
    }

    static class Node {
        int key;
        int val;
        Node prev, next;

        public Node(int key, int val, Node prev, Node next) {
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
}
