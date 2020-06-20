package IntroductionToAlogrithms.ch7_quickSort;

import java.util.Random;

public class RandomQuickSort {
    public static Random random = new Random(System.currentTimeMillis());
    public static void main(String[] args) {
        int[] a = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};

        RandomQuickSort.quickSort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    public static void quickSort(int[] A, int p, int r) {
        if (p < r) {
            int q = randomPartition(A, p, r);
            quickSort(A, p, q - 1);
            quickSort(A, q + 1, r);

        }
    }
    public static int randomPartition(int[] A, int p, int r) {
        int i = random.nextInt(r - p) + p;
        int temp = A[i];
        A[i] = A[r];
        A[r] = temp;
        return partition(A, p, r);
    }

    public static int partition(int[] A, int p, int r) {
        int x = A[r];
        int i = p - 1;
        for (int j = p; j <= r - 1; j++) {
            if (A[j] <= x) {
                i++;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        int temp = A[i + 1];
        A[i + 1] = A[r];
        A[r] = temp;
        return i + 1;
    }
}
