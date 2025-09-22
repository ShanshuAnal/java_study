package com.powernode.leetcode.heap;

/**
 * @Author: 19599
 * @Date: 2025/6/1 14:21
 * @Description:
 */
public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.heap = new int[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public int size() {
        return size;
    }

    public int peek() {
        if (size == 0) {
            throw new RuntimeException("当前堆为空");
        }
        return heap[0];
    }

    public void add(int val) {
        if (size == capacity) {
            throw new RuntimeException("容量不足");
        }
        heap[size] = val;
        siftUp(size);
        size++;
    }

    private void siftUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap[i] >= heap[parent]) {
                break;
            }
            swap(i, parent);
            i = parent;
        }
    }

    public int poll() {
        if (size == 0) {
            throw new RuntimeException("当前堆为空");
        }
        int res = heap[0];
        heap[0] = heap[size - 1];
        size--;
        siftDown(0);
        return res;
    }

    private void siftDown(int i) {
        while (i * 2 + 1 < size) {
            int leftChild = i * 2 + 1, rightChild = i * 2 + 2;
            int minChild = leftChild;
            if (rightChild < size && heap[rightChild] < heap[leftChild]) {
                minChild = rightChild;
            }
            if (heap[i] <= heap[minChild]) {
                break;
            }
            swap(i, minChild);
            i = minChild;
        }
    }

    private void swap(int i, int j) {
        int t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }
}