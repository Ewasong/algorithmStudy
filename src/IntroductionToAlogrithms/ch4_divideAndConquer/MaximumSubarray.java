package IntroductionToAlogrithms.ch4_divideAndConquer;

/***
 * 寻找子数组A[low...high]的最大连续子数组，使用分治技术意味着我们需要将子数组划分为规模尽量相等的两个子数组，A[low...mid]和A[mid+1...high]
 *
 * A[low...high]的子数组只能是这三种情况
 *
 * * 完全位于子数组A[low...mid]中
 * * 完全位于子数组A[mid+1...high]中
 * * 跨越了中点。
 */
public class MaximumSubarray {

    public int findMaxCrossingSub(int[] A, int low, int high, int mid){
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        //处理左半部分
        for (int i = mid; i >= 0; i--) {
            sum += A[i];
            leftSum = Math.max(sum, leftSum);
        }

        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        //处理右半部分
        for (int i = mid + 1; i < high; i++) {
            sum += A[i];
            rightSum = Math.max(sum, rightSum);
        }
        int result = Math.max(leftSum, rightSum);
        result = Math.max(result, leftSum + rightSum);
        return result;
    }

    public int findMaxSub(int[] A, int low, int high){
        if (low == high) {
            return A[low];
        }
        else {
            int mid = low + (high - low) / 2;
            int leftSum = findMaxSub(A, low, mid);
            int rightSum = findMaxSub(A, mid + 1, high);
            int midSum = findMaxCrossingSub(A, low, high, mid);
            int result = Math.max(leftSum, rightSum);
            result = Math.max(result, midSum);
            return result;
        }
    }
}
