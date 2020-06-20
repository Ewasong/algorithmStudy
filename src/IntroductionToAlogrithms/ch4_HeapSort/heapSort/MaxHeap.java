package IntroductionToAlogrithms.ch4_HeapSort.heapSort;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxHeap {
    private int[] tab;
    private int size;
    public int parent(int i) {
        return i >> 1;
    }
    public int left(int i) {
        return i << 1;
    }

    public int right(int i) {
        return (i << 1) + 1;
    }

    /***
     * 维护堆性质
     * @param i
     */
    public void maxHeapIfy(int i) {
        int l = left(i);
        int r = right(i);
        int largest;
        if (l <= size && tab[l] > tab[i]) {
            largest = l;
        } else {
            largest = i;
        }
        if (r <= size && tab[r] > tab[largest]) {
            largest = r;
        }
        if (largest != i) {
            int temp = tab[i];
            tab[i] = tab[largest];
            tab[largest] = temp;
            maxHeapIfy(largest);
        }
    }

    public void buildMaxHeap(int[] A) {
        tab = new int[A.length + 1];
        size = A.length;
        System.arraycopy(A, 0, tab, 1, size);
        for (int i = size / 2; i > 0; i--) {
            maxHeapIfy(i);
        }
    }

    public int pop() {
        if (size < 1) {
            throw new IndexOutOfBoundsException();
        }
        int max = tab[1];
        tab[1] = tab[size];
        size--;
        maxHeapIfy(1);
        return max;
    }

    public void update(int i, int key) {
        if (key < tab[i]) {
            throw new RuntimeException("key变小了");
        }
        tab[i] = key;
        int parentI = parent(i);
        while (i > 1 && tab[parentI] < tab[i]) {
            int temp = tab[i];
            tab[i] = tab[parentI];
            tab[parentI] = temp;
            i = parentI;
            parentI = parent(i);
        }
    }
    public void insert(int key) {
        size++;
        tab[size] = Integer.MIN_VALUE;
        update(size, key);
    }
    public void heapSort() {
        int sizeTemp = size;
        for (int i = size; i >= 2; i--) {
            int temp = tab[i];
            tab[i] = tab[1];
            tab[1] = temp;
            size = size - 1;
            maxHeapIfy(1);
        }
        size = sizeTemp;
    }
    public static void main(String[] args) {
        int[] a = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.buildMaxHeap(a);
        maxHeap.heapSort();
        for (int i = 1; i <= maxHeap.size; i++) {
            System.out.println(maxHeap.tab[i]);
        }
    }


}
