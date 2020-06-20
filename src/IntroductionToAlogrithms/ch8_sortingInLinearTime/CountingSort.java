package IntroductionToAlogrithms.ch8_sortingInLinearTime;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] a = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7, 10};

        int[] b = CountingSort.countingSort(a, 16);
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }
    public static int[] countingSort(int[] A, int k) {
        int[] C = new int[k+1];
        int[] B = new int[A.length];
        Arrays.fill(C, 0);
        for (int i = 0; i < A.length; i++) {
            C[A[i]] = C[A[i]] + 1;
        }
        for (int i = 1; i <= k; i++) {
            C[i] = C[i] + C[i-1];
        }
        for (int j = A.length - 1; j >= 0; j--) {
            B[C[A[j]]-1] = A[j];
            C[A[j]] = C[A[j]] - 1;
        }
        return B;
    }
}
