package com.powernode.map;

import java.util.Arrays;

/**
 * @Author: RG
 * @Package: com.powernode.map
 * @name: MyHashMap1
 * @Date: 2024/11/19 17:21
 */
public class MyHashMap1<K, V> {
    private Node<K, V>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public MyHashMap1() {
        table = new Node[16];
        size = 0;
    }

    private static class Node<K, V> {
        int hashCode;
        K key;
        V value;
        Node<K, V> next;

        public Node(int hashCode, K key, V value, Node<K, V> next) {
            this.hashCode = hashCode;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    public int size() {
        return size;
    }

    public V put(K key, V value) {
        if (key == null) {
            return putForNullKey(value);
        }

        int hashCode = key.hashCode();
        int index = Math.abs(hashCode % table.length);
        Node<K, V> node = table[index];

        if (node == null) {
            table[index] = new Node<>(hashCode, key, value, null);
            size++;
            return value;
        }

        Node<K, V> pre = null;
        while (node != null) {
            if (node.key.equals(key)) {
                V oldValue = node.value;
                node.value = value;
                return oldValue;
            }
            pre = node;
            node = node.next;
        }
        pre.next = new Node<>(hashCode, key, value, null);
        size++;
        return null;
    }

    private V putForNullKey(V value) {
        Node<K, V> node = table[0];
        if (node == null) {
            table[0] = new Node<>(0, null, value, null);
            size++;
            return value;
        }
        Node<K, V> pre = null;
        while (node != null) {
            if (node.key == null) {
                V oldValue = node.value;
                node.value = value;
                return oldValue;
            }
            pre = node;
            node = node.next;
        }
        pre.next = new Node<>(0, null, value, null);
        size++;
        return value;
    }

    public V get(K key) {
        if (key == null) {
            Node<K, V> node = table[0];
            if (node == null) {
                return null;
            }
            while (node != null) {
                if (node.key == null) {
                    return node.value;
                }
                node = node.next;
            }

            return null;
        }

        int hashCode = key.hashCode();
        int index = Math.abs(hashCode % table.length);
        Node<K, V> node = table[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                sb.append(table[i].toString());
                sb.append("  ");
            }
        }
        return new String(sb);
    }
}
























