package IntroductionToAlogrithms.ch2_GettingStarted;

public class MergeSort {

    /**
     * 合并A[left··mid]以及A[mid··right]
     *
     * @param A     :
     * @param left  :
     * @param mid   :
     * @param right
     * @return
     * @author soriee
     * @date 2020/4/11 13:04
     */
    public static void merge(int[] A, int left, int mid, int right) {
        int l1 = left;
        int l2 = mid + 1;
        int r1 = mid;
        int r2 = right;
        int[] sorted = new int[right - left + 1];
        int i = 0;
        while (l1 <= r1 && l2 <= r2) {
            if (A[l1] < A[l2]) {
                sorted[i] = A[l1++];
            } else {
                sorted[i] = A[l2++];
            }
            i++;
        }
        while (l1 <= r1) {
            sorted[i++] = A[l1++];
        }
        while (l2 <= r2) {
            sorted[i++] = A[l2++];
        }
        i = 0;
        while (left <= right) {
            A[left++] = sorted[i++];
        }
    }

    /**
     *
     * @param A     : 数组
     * @param left  : 左边界
     * @param right ：右边界
     * @return
     * @author soriee
     * @date 2020/4/11 12:53
     */
    public static void mergeSort(int[] A, int left, int right) {
        if (left < right) {
    //      int mid = (left + right) / 2;
            //避免溢出
            int mid = left + (right - left) / 2;
            mergeSort(A, left, mid);
            mergeSort(A, mid + 1, right);
            merge(A, left, mid, right);
        }
    }
}
