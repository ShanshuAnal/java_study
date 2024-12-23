package com.powernode.collection;

/**
 * @Author: RG
 * @Package: com.powernode.collection
 * @name: MyLinked1
 * @Date: 2024/11/19 16:35
 */
public class MyLinked1<E> {

    private Node<E> first;

    private int size;

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

    public MyLinked1() {
        size = 0;
        first = new Node<>();
    }

    public void add(E e) {
        linkLast(e);
    }

    private void linkLast(E e) {
        Node node = new Node<>(e, null);
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

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == size) {
            add(e);
        } else {
            link(index, e);
        }
    }

    private void link(int index, E e) {
        Node<E> pre = first;
        Node<E> node = new Node<>(e, null);
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        node.next = pre.next;
        pre.next = node;
        size++;
    }


    public E remove(int index) {
        if (index < 0 || index > size) {
            return null;
        }
        return unlink(index);
    }

    private E unlink(int index) {
        Node<E> pre = node(index - 1);
        E removeData = pre.next.data;
        pre.next = pre.next.next;
        size--;
        return removeData;
    }

    public E remove(E e) {
        Node<E> pre = first;
        while (pre.next != null) {
            if (pre.next.data != e) {
                pre = pre.next;
            } else {
                E oldData = pre.next.data;
                pre.next = pre.next.next;
                size--;
            }
        }
        return null;
    }

    public E set(int index, E e) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node<E> node = node(index);
        E oldData = node.data;
        node.data = e;
        return oldData;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return node(index).data;

    }

    public int size() {
        return size;
    }

    private Node<E> node(int index) {
        Node<E> node = first;
        for (int i = 0; i <= index; i++) {
            node = node.next;
        }
        return node;
    }


}





























