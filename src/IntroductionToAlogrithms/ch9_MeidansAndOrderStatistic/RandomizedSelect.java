package IntroductionToAlogrithms.ch9_MeidansAndOrderStatistic;

import IntroductionToAlogrithms.ch7_quickSort.QuickSort;
import IntroductionToAlogrithms.ch7_quickSort.RandomQuickSort;

public class RandomizedSelect {
    public static void main(String[] args) {
        int[] a = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};

        System.out.println(
                RandomizedSelect.randomSelect(a, 0, a.length - 1, 4));

    }
    /**
     * 返回第i小
     * @param A
     * @param p
     * @param r
     * @param i
     * @return
     */
    public static int randomSelect(int[] A, int p, int r, int i) {
        if(p == r) {
            return A[p];
        }
        int q = RandomQuickSort.randomPartition(A, p, r);
        int k = q - p + 1;
        if (i == k) {
            return A[q];
        } else if( i < k) {
            return randomSelect(A, p , q - 1, i);
        } else {
            return randomSelect(A, q + 1, r, i - k);
        }
    }
}
