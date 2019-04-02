package com.mana.solutions.general;

public class Heap {
    int[] heap;
    int size;
    int capacity;

    Heap(int capacity) {
        this.heap = new int[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    void push(int value) {
        if (size == capacity) {
            this.resize();
        }

        heap[size++] = value;
        int index = size - 1;
        int parent = (index - 1) / 2;

        while (parent >= 0 && heap[index] < heap[parent]) {
            heap[index] = heap[parent];
            index = parent;
            parent = (index - 1) / 2;
        }
        heap[index] = value;
    }

    int pop() {
        int val = heap[0];
        heap[0] = heap[size - 1];
        size = size - 1;
        percolateDown(0);
        return val;
    }

    void percolateDown(int index) {
        int right = getRightChild(index);
        int left = getLeftChild(index);

        int min = heap[index];
        int min_i = index;

        if (right != -1 && heap[right] < min) {
            min = heap[right];
            min_i = right;
        }
        if (left != -1 && heap[left] < min) {
            min = heap[left];
            min_i = left;
        }
        if (min != heap[index]) {
            swap(index, min_i);
            percolateDown(min_i);
        }
    }

    private int getRightChild(int index) {
        int right = 2 * index + 2;
        if (right >= size)
            return -1;
        return right;
    }

    private int getLeftChild(int index) {
        int left = 2 * index + 1;
        if (left >= size)
            return -1;
        return left;
    }

    private void swap(int index, int min) {
        int temp = heap[index];
        heap[index] = heap[min];
        heap[min] = temp;
    }

    public void resize() {
        int[] new_heap = new int[capacity * 2];
        for (int i = 0; i < heap.length; i++) {
            new_heap[i] = heap[i];
        }
        capacity = capacity * 2;
        heap = new_heap;
    }

    public void printHeap() {
        for (int a : heap)
            System.out.println(a);
    }

    public static void main(String[] args) {
        Heap h = new Heap(10);
        h.push(6);
        h.push(7);
        h.push(5);
        h.push(8);
        h.pop();
        h.printHeap();
    }
}