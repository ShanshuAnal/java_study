package com.powernode.map;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author: RG
 * @Package: com.powernode.map
 * @name: MyHashMap
 * @Date: 2024/11/18 23:56
 */
public class MyHashMap<K, V> {

    /**
     * 哈希表
     */
    private Node<K, V>[] table;

    /**
     * 键对值的个数
     */
    private int size;

    private static class Node<K, V> {
        /**
         * 哈希码
         * key的hashCode()方法的返回值
         */
        int hash;

        /**
         * key
         */
        K key;

        /**
         * value
         */
        V value;

        /**
         * 下个节点的内存地址
         */
        Node<K, V> next;

        /**
         * 构造一个节点对象
         * @param hash 哈希值
         * @param key 键
         * @param value 值
         * @param next 下一个节点地址
         */
        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
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

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        // new 数组的时候不能用 泛型
        // table = new Node<K, V>[16]; 这样不对
        table = new Node[16];
    }

    /**
     * 获取哈希表的大小
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 向MyHashMap中添加键值对
     * @param key
     * @param value
     * @return value，如果key重复，则返回oldValue；否则返回newValue
     */
    public V put(K key, V value) {
        if (key == null) {
            return putForNullNode(value);
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
        return value;
    }

    /**
     * 添加key为null的键值对
     * @param value
     * @return
     */
    private V putForNullNode(V value) {
        Node<K, V> node = table[0];
        // 规定key为null的键值对哈希值为0
        if (node == null) {
            table[0] = new Node<>(0, null, value, null);
            size++;
            return value;
        }
        // 执行到这，说明哈希值为0所对应的单向链表中已经有节点了，那就插入到最后面（实际就是链表尾插法）
        Node<K, V> pre = null;
        while (node != null) {
            // 哈希值为0所对应的单链表中要是有key为null的节点，那么直接覆盖就行了，返回oldValue
            if (node.key == null) {
                V oldValue = node.value;
                node.value = value;
                return oldValue;
            }
            pre = node;
            node = node.next;
        }
        // 哈希值为0所对应的单链表中没有key为null的节点，使用尾插法
        pre.next = new Node<>(0, null, value, null);
        size++;
        return value;
    }

    /**
     * 通过key返回value
     * @param key
     * @return
     */
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

        int hash = 0;
        int index = Math.abs(hash % table.length);
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
        for (int i = 0; i < table.length; i++ ) {
            Node<K, V> node = table[i];
            while (node != null) {
                sb.append(node.toString());
                sb.append('\n');
                node = node.next;
            }
        }
        return new String(sb);
    }
}
