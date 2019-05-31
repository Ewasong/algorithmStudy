package leetcode.l_896;


/**
 * Created by 81929 on 2019/5/25.
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums1 = new int[]{11,11,9,4,3,3,3,1,-1,-1,3,3,3,5,5,5};
        Solution solution = new Solution();
        System.out.println(solution.isMonotonic(nums1));
    }
    public boolean isMonotonic(int[] A) {
        if(A.length <= 2){
            return true;
        }
        boolean inc = true, judge = false;
        for(int i = 1; i < A.length; i++){
            //不全相等
            if(!judge && A[i] != A[i - 1]){
                judge = true;
                inc = A[i] > A[i - 1];
            }
            if(judge && (inc && A[i] < A[i - 1] || !inc && A[i] > A[i - 1]) ){
                return false;
            }
        }
        return true;
    }
}
