package com.powernode.leetcode.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 19599
 * @Date: 2025/6/20 10:03
 * @Description:
 */
public class LRUWithTTL {
    Node head, tail;
    int capactity;
    Map<Integer, Node> map;

    public LRUWithTTL(int capactity) {
        this.capactity = capactity;
        head = new Node(-1, -1, null, null, 0);
        tail = new Node(-1, -1, null, null, 0);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    public void put(int key, int val, long ttl) {
        long expireTime;
        if (ttl > 0) {
            expireTime = System.currentTimeMillis() + ttl;
        } else {
            expireTime = Long.MAX_VALUE;
        }

        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = val;
            node.expireTime = expireTime;
            moveToHead(node);
        } else {
            Node newNode = new Node(key, val, null, null, expireTime);
            map.put(key, newNode);
            addToHead(newNode);

            if (map.size() > capactity) {
                Node removeNode = removeLast();
                map.remove(removeNode);
            }
        }
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        if (System.currentTimeMillis() > node.expireTime) {
            removeNode(node);
            map.remove(key);
            System.out.println("this node has expired and is removed");
        }

        moveToHead(node);
        return node.val;
    }

    private Node removeLast() {
        Node last = tail.prev;
        removeNode(last);
        return last;
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
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    static class Node {
        int key, val;
        Node prev, next;
        long expireTime;

        public Node(int key, int val, Node prev, Node next, long expireTime) {
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.expireTime = expireTime;

        }
    }
}
