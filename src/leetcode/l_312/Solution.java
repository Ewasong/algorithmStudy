package leetcode.l_312;

import java.util.Stack;

/**
 * Created by 81929 on 2019/5/25.
 */
public class Solution {
    //还没解决
    public static void main(String[] args) {
        int[] nums1 = new int[]{3, 4, 6, 5};
        int[] nums2 = new int[]{9, 1, 2, 5, 8, 3};
        Solution solution = new Solution();
        System.out.println(solution.maxNumber(nums1, nums2, 5));
    }
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] mergedArr = this.merge(nums1, nums2);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < mergedArr.length; i++){
            while (!stack.isEmpty()){
                int stackLen = stack.size();
                int left = mergedArr.length - i;
                int endNode = stack.lastElement();
                if(endNode >= mergedArr[i] || stackLen + left <= k){
                    break;
                }
                else {
                    stack.pop();
                }
            }
            stack.push(mergedArr[i]);
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = stack.elementAt(i);
        }
        return res;
    }

    /**
     * 按顺序合并nums1和nums2,更大的数排在前面
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] merge(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int[] resArr = new int[totalLength];
        int j = 0, k = 0;
        for (int i = 0; i < totalLength; i++) {
            if (greater(nums1, nums2, j, k)){
                resArr[i] = nums1[j++];
            }
            else {
                resArr[i] = nums2[k++];
            }
        }

        return resArr;
    }

    /***
     * 判断该取nums1的j还是nums2的k
     * @param nums1
     * @param nums2
     * @param j
     * @param k
     * @return
     */
    public boolean greater(int[] nums1, int[] nums2, int j, int k) {
        if (j >= nums1.length) {
            return false;
        } else if (k >= nums2.length) {
            return true;
        } else {
            return nums1[j] > nums2[k];
        }
    }
}
