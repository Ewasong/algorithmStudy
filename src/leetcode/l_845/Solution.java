package leetcode.l_845;

/**
 * Created by 81929 on 2018/7/21.
 */
public class Solution {
    public static void main(String[] args) {
        int[] a = {2,1,4,7,3,2,5};
        System.out.println(new Solution().longestMountain(a));
    }
    public int longestMountain(int[] A) {

        int maxLen = 0;
        int curLen = 0;
        int duration = -1;  //方向 代表单调0向下 1代表向上 -1代表暂无方向 2代表是向上后又向下 的
        int len = A.length;
        for(int i = 0; i < len ; i++){
            if(i == 0){
                curLen++;
            }
            else {
                if(A[i-1] == A[i]){
                    duration = -1;
                    curLen = 1;
                }
                else if(A[i] > A[i - 1]){
                    if(duration == 0 || duration == 2){
                        curLen = 1;
                    }
                    curLen++;
                    duration = 1;

                }
                else if(A[i] < A[i-1]){
                    curLen++;
                    if(duration == 1 || duration == 2){
                        duration = 2;
                    }
                    else{
                        duration = 0;

                    }
                }
            }
            if(curLen >= 3 && duration == 2){
                maxLen = Math.max(maxLen, curLen);
            }
        }

        return maxLen;
    }
}
