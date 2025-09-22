package com.powernode.leetcode.heap;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: 19599
 * @Date: 2025/7/9 23:22
 * @Description:
 */
@SuppressWarnings("unchecked")
public class MinHeapPlus<T> {
    private static final int DEFAULT_INITIAL_CAPACITY = 11;

    private Object[] heap;
    private int size;
    private final Comparator<? super T> comparator;

    public MinHeapPlus(Comparator<? super T> comparator) {
        this(DEFAULT_INITIAL_CAPACITY, comparator);
    }

    public MinHeapPlus(int initCapacity) {
        this(initCapacity, null);
    }

    public MinHeapPlus(int initCapacity, Comparator<? super T> comparator) {
        if (initCapacity < 1) {
            throw new IllegalArgumentException("init capacity is illegal");
        }
        heap = new Object[initCapacity];
        this.comparator = comparator;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T peek() {
        return (size != 0) ? (T) heap[0] : null;
    }

    public void offer(T e) {
        if (e == null) {
            throw new NullPointerException("null~");
        }
        int i = size;
        if (i >= heap.length) {
            resize();
        }
        size = i + 1;
        if (i == 0) {
            heap[0] = e;
        } else {
            siftUp(e, i);
        }

    }

    public T poll() {
        if (size == 0) {
            return null;
        }
        int s = --size;
        T res = (T) heap[0];
        T x = (T) heap[s];
        heap[s] = null;
        if (s != 0) {
            siftDown(0, x);
        }
        return res;
    }

    private void siftDown(int k, T x) {
        if (comparator != null) {
            siftDownUsingComparator(k, x);
        }
    }

    private void siftDownUsingComparator(int k, T x) {
        int boundary = size >>> 1;
        while (k < boundary) {
            int childIndex = (k >> 1) + 1;
            Object child = heap[childIndex];
            int rightIndex = childIndex + 1;
            if (rightIndex < size && comparator.compare((T) heap[rightIndex], x) <= 0) {
                child = heap[childIndex = rightIndex];
            }
            if (comparator.compare(x, (T) child) <= 0) {
                break;
            }
            heap[k] = child;
            k = childIndex;
        }
        heap[k] = x;
    }

    private void siftUp(T e, int k) {
        if (comparator != null) {
            siftUpUsingComparator(k, e);
        } else {
            siftUpUsingComparable(k ,e);
        }
    }

    private void siftUpUsingComparable(int k, T e) {
        Comparable<? super T> key = (Comparable<? super T>) e;
        while (k > 0) {
            int parentIndex = (k - 1) >> 1;
            Object parent = heap[parentIndex];
            if (key.compareTo((T) parent) >= 0) {
                break;
            }
            heap[k] = parent;
            k = parentIndex;
        }
        heap[k] = key;
    }

    private void siftUpUsingComparator(int k, T e) {
        while (k > 0) {
            int parentIndex = (k - 1) >> 1;
            Object parent = heap[parentIndex];
            if (comparator.compare((T) parent, e) <= 0) {
                break;
            }
            heap[k] = parent;
            k = parentIndex;
        }
        heap[k] = e;
    }

    private void resize() {
        int oldCapacity = heap.length;
        int newCapacity = oldCapacity + ((oldCapacity < 64) ?
                (oldCapacity + 2) :
                (oldCapacity >> 1));
        heap = Arrays.copyOf(heap, newCapacity);
    }

}
