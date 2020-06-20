package l_2_lengthOfLongestSubstring;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("a"));
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new Solution().lengthOfLongestSubstring("tmmzuxt"));

    }

    public int lengthOfLongestSubstring(String s) {
        //需要设置map的容量，避免扩容引起的效率问题
        int initialMapSize = 128;
        Map<Character, Integer> charToIndex = new HashMap<>(initialMapSize);
        int result = 0;
        int preIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charToIndex.containsKey(c)) {
                preIndex = Math.max(preIndex, charToIndex.get(c) + 1);
            }
            result = Math.max(result, i - preIndex + 1);

            charToIndex.put(c, i);
        }
        return result;
    }
}
