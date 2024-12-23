package com.powernode.collection;

import java.util.LinkedList;

/**
 * @Author: RG
 * @Package: com.powernode.collection
 * @name: MyLinked
 * @Date: 2024/11/17 15:53
 */
public class MyLinked<E> {

    private Node<E> first;
    private int size;

    public MyLinked() {
        first = new Node<>();

    }

    public MyLinked(Node first, int size) {
        this.first = first;
        this.size = size;
    }

    public void add(E e) {
        linkLast(e);
    }

    public void add(int index, E e) {
        if (index == size) {
            linkLast(e);
        } else {
            linkAfter(e, node(index - 1));
        }
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return unlink(index);
    }

    public E remove(E e) {
        int index = 0;
        Node<E> node = first.next;
        while (node.data != e) {
            node = node.next;
            index++;
        }
        return unlink(index);
    }

    public E set(int index, E e) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node<E> node = node(index);
        E value = node.data;
        node.data = e;
        return value;
    }

    public E get(int index) {
        return node(index).data;
    }

    private E unlink(int index) {
        Node<E> pre = node(index - 1);
        E value = pre.next.data;
        pre.next = pre.next.next;
        size--;
        return value;
    }

    private void linkAfter(E e, Node<E> node) {
        Node<E> newNode = new Node<>(e, node.next);
        node.next = newNode;
        size++;
    }

    private Node<E> node(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node<E> current = first;
        for (int i = 0; i <= index; i++) {
            current = current.next;
        }
        return current;
    }

    private void linkLast(E e) {
        Node<E> node = new Node<>(e, null);
        if (first.next == null) {
            first.next = node;
        } else {
            Node<E> current = first.next;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        size++;
    }

    private static class Node<E> {
        E data;
        Node<E> next;

        public Node() {
        }

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }
}