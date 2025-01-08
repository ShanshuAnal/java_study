package com.powernode.collection;

/**
 * @Author: 19599
 * @Date: 2025/1/5 20:34
 */
public class MyLinkedList2<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    public MyLinkedList2() {

    }

    private static class Node<E> {
        E data;
        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev, E e, Node<E> next) {
            this.prev = prev;
            data = e;
            this.next = next;
        }
    }

    public void add(E e) {
        linkLast(e);
    }

    public void add(E e, int index) {
        if (index > size) {
            return;
        }
        if (index == size) {
            linkLast(e);
        } else {
            linkBefore(e, node(index));
        }
    }

    public E set(int index, E e) {
        if (index > size) {
            return null;
        }
        Node<E> node = node(index);
        E value = node.data;
        node.data = e;
        return value;
    }

    public E get(int index) {
        if (index > size) {
            return null;
        }
        return node(index).data;
    }

    public E remove(int index) {
        if (index > size) {
            return null;
        }
        return unlink(node(index));
    }

    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.data == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.data)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    private E unlink(Node<E> node) {
        final E e = node.data;
        final Node<E> pre = node.prev;
        final Node<E> next = node.next;

        if (pre == null) {
            first = next;
        } else {
            pre.next = next;
            node.prev = null;
        }

        if (next == null) {
            last = pre;
        } else {
            next.prev = pre;
            node.next = null;
        }

        node.data = null;
        size--;
        return e;
    }

    private void linkBefore(E e, Node<E> node) {
        final Node<E> pre = node.prev;
        final Node<E> newNode = new Node<>(pre, e, node);
        node.prev = newNode;
        if (pre == null) {
            first = newNode;
        } else {
            pre.next = newNode;
        }
        size++;
    }

    private Node<E> node(int index) {
        Node<E> x;
        if (index < (size >> 1)) {
            x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
        } else {
            x = last;
            for (int i = 0; i < index; i++) {
                x = x.prev;
            }
        }
        return x;
    }

    private void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> node = new Node<>(l, e, null);
        last = node;
        if (l == null) {
            first = node;
        } else {
            l.next = node;
        }
        size++;
    }
}