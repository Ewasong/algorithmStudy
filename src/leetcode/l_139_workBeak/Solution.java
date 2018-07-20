package leetcode.l_139_workBeak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 81929 on 2018/7/20.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> list = new ArrayList<String>(Arrays.asList("apple", "pen"));
        System.out.println(solution.wordBreak("applepenapple", list));
    }


    public boolean wordBreak(String s, List<String> wordDict) {
        int dp[] = new int[1000];
        Arrays.fill(dp, 0);
        if(s == null || wordDict == null){
            return false;
        }
        int sLen = s.length();

        int wdSize = wordDict.size();

        //初始化
        for(int j = 0; j < wdSize; j++){
            String perWord = wordDict.get(j);
            int perWordLen = perWord.length();
            if(s.startsWith(perWord)){
                dp[perWordLen] = 1;
            }
        }

        //dp[i][j] 为1 代表 前i位子串能够分解成功 否则 代表不成功
        for(int i = 2; i <= sLen; i++){
            for(int j = 0; j < wdSize; j++) {
                String perWord = wordDict.get(j);
                int perWordLen = perWord.length();
                int lastLen = i - perWordLen;
                if( lastLen > 0 && dp[lastLen] == 1){
                    String subStr = s.substring(lastLen , i);
                    if(subStr.equals(perWord)){
                        dp[i] = 1;
                    }
                }
            }
        }

        return dp[sLen] == 1;

    }
}