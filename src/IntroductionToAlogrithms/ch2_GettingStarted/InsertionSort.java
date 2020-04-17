package IntroductionToAlogrithms.ch2_GettingStarted;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] a = {1, 4, 3, 5};
//        InsertionSort.insertionSort(a);
//        for (int i = 0; i < a.length; i++){
//            System.out.println(a[i]);
//        }
        InsertionSort.insertionSortDesc2(a);
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }
    public static void insertionSort(int[] A) {
        for (int j = 1; j < A.length; j++) {
            int key = A[j];
            // insert A[j] into the sorted sequence A[1··j-1]
            int i = j - 1;
            while (i >= 0 && A[i] > key) {
                A[i + 1] = A[i];
                i--;
            }
            A[i+1] = key;
        }
    }

    public static void insertionSortDesc(int[] A) {
        for (int j = A.length - 2; j >= 0; j--) {
            int key = A[j];
            // insert A[j] into the sorted sequence A[1··j-1]
            int i = j + 1;
            while (i < A.length && A[i] > key) {
                A[i - 1] = A[i];
                i++;
            }
            A[i-1] = key;
        }
    }

    public static void insertionSortDesc2(int[] A) {
        for (int j = 1; j < A.length; j++) {
            int key = A[j];
            // insert A[j] into the sorted sequence A[1··j-1]
            int i = j - 1;
            while (i >= 0 && A[i] <= key) {
                A[i + 1] = A[i];
                i--;
            }
            A[i+1] = key;
        }
    }
}
