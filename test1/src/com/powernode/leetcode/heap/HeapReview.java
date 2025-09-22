package com.powernode.leetcode.heap;

import java.util.Arrays;
import java.util.Comparator;


/**
 * @Author: 19599
 * @Date: 2025/6/2 17:25
 * @Description:
 */
public class HeapReview<T> {
    private Object[] heap;
    private int capacity;
    private int size;
    private Comparator<T> comparator;


    HeapReview(int capacity, Comparator<T> comparator) {
        this.capacity = capacity;
        heap = new Object[capacity];
        this.comparator = comparator;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (size == 0) {
            throw new RuntimeException("Heap is Empty!");
        }
        return (T) heap[0];
    }

    public T poll() {
        if (size == 0) {
            throw new RuntimeException("Heap is Empty!");
        }
        T min = (T) heap[0];
        heap[0] = heap[size - 1];
        size--;
        siftDown(0);
        return min;
    }

    private void siftDown(int i) {
        while (i * 2 + 1 < size) {
            int leftChild = i * 2 + 1, rightChild = i * 2 + 2;
            int minChild = leftChild;
            if (rightChild < size && comparator.compare((T) heap[rightChild], (T) heap[leftChild]) < 0) {
                minChild = rightChild;
            }
            if (comparator.compare((T) heap[i], (T) heap[minChild]) <= 0) {
                break;
            }
            swap(minChild, i);
            i = minChild;
        }

    }

    public void offer(int i) {
        ensureCapacity();
        heap[size++] = i;
        siftUp(size - 1);
    }

    private void ensureCapacity() {
        if (capacity == size) {
            capacity *= 2;
            heap = Arrays.copyOf(heap, capacity);
        }
    }

    private void siftUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (comparator.compare((T) heap[parent], (T) heap[i]) <= 0) {
                break;
            }
            swap(parent, i);
            i = parent;
        }
    }

    private void swap(int i, int j) {
        T t = (T) heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }
}