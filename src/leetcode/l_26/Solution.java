package leetcode.l_26;

/**
 * Created by 81929 on 2018/7/21.
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        int len = 0;
        Integer preNum = null;

        for(int per : nums){
            if(preNum == null || per != preNum){
                preNum = per;
                nums[len] = per;
                len ++;
            }

        }

        return len;
    }

}
