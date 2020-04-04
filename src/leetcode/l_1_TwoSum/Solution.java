package l_1_TwoSum;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Solution {

    /**
     * 思路:
     *  边循环边构建一个差值对index的map
     *  如果该map包含cur,那么直接返回 [leftNumToIndex.get(cur), i]即可
     *  结果: 通过， 时间消耗2ms, 内存消耗39.8 MB
     * @param nums   :
     * @param target
     * @return
     * @author soriee
     * @date 2020/4/4 22:01
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> leftNumToIndex = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i ++){
            int cur = nums[i];
            if (leftNumToIndex.containsKey(cur)) {
                return new int[]{leftNumToIndex.get(cur), i};
            }
            int left = target - nums[i];
            leftNumToIndex.put(left, i);
        }

        return null;
    }

    /**
     * 改为LinkedHashMap并没有节省多少空间
     * 思路:
     *  边循环边构建一个差值对index的map
     *  如果该map包含cur,那么直接返回 [leftNumToIndex.get(cur), i]即可
     *  结果: 通过， 时间消耗5ms, 内存消耗39.7 MB
     * @param nums   :
     * @param target
     * @return
     * @author soriee
     * @date 2020/4/4 22:01
     */
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> leftNumToIndex = new LinkedHashMap<>();
        for (int i = 0; i < nums.length; i ++){
            int cur = nums[i];
            if (leftNumToIndex.containsKey(cur)) {
                return new int[]{leftNumToIndex.get(cur), i};
            }
            int left = target - nums[i];
            leftNumToIndex.put(left, i);
        }

        return null;
    }

}
