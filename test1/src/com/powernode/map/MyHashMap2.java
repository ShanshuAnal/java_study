package com.powernode.map;

import java.util.Objects;

/**
 * @Author: 19599
 * @Date: 2025/1/8 0:22
 */
public class MyHashMap2<K, V> {
    private Node<K, V>[] table;
    private int size;

    public MyHashMap2() {
        table = new Node[16];
        size = 0;
    }


    private static class Node<K, V> {
        int hash;
        K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "(" +
                    "hash=" + hash +
                    ", key=" + key +
                    ')';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node<?, ?> node = (Node<?, ?>) o;
            return Objects.equals(key, node.key) && Objects.equals(value, node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(key);
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V newValue) {
            V oldValue = value;
            this.value = newValue;
            return oldValue;
        }
    }

    public int getSize() {
        return size;
    }

    public V put(K key, V value) {
        if (key == null) {
            return putForNullKey(value);
        }

        int hash = key.hashCode();
        int index = Math.abs(hash % table.length);
        Node<K, V> node = table[index];

        if (node == null) {
            table[index] = new Node<>(hash, key, value, null);
            size++;;
            return null;
        }

        Node<K, V> pre = null;
        while (node != null) {
            if (key.equals(node.key)) {
                V oldValue = node.value;
                node.value = value;
                return oldValue;
            }
        }

        pre.next = new Node<>(hash, key, value, null);
        size++;
        return null;
    }

    private V putForNullKey(V value) {
        Node<K, V> node = table[0];
        if (node == null) {
            table[0] = new Node<>(0, null, value, null);
            size++;
            return null;
        }

        Node<K, V> pre = null;
        while (node != null) {
            if (node.key == null) {
                V oldValue = node.value;
                node.setValue(value);
                return oldValue;
            }
            pre = node;
            node = node.next;
        }

        pre.next = new Node<>(0, null, value, null);
        size++;
        return null;
    }

    public V get(K key) {
        if (key == null) {
            Node<K, V> node = table[0];
            if (node == null) {
                return null;
            }
            while (node != null) {
                if (key.equals(node.key)) {
                    return node.value;
                }
                node = node.next;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                sb.append("[");
                Node<K, V> node = table[i];
                while (node != null) {
                    sb.append(node.toString());
                }
                sb.append("],");
            }
        }
        sb.setCharAt(sb.length() - 1, '}');
        return new String(sb);
    }
}
