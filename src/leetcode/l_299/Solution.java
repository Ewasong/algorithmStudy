package leetcode.l_299;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 81929 on 2018/7/21.
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getHint("1807", "7810"));
        System.out.println(solution.getHint("1123", "0111"));

    }
    public String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap<>();
        char[] characterSecretArr = secret.toCharArray();
        char[] characterGuessArr = guess.toCharArray();
        int len = characterGuessArr.length;
        int A = 0, B = 0;

        for(int i = 0; i < len; i++){
            char perSecretChar = characterSecretArr[i];
            char perGuessChar = characterGuessArr[i];

            if(!map.containsKey(perSecretChar)){
                map.put(perSecretChar, 0);
            }
            if(!map.containsKey(perGuessChar)){
                map.put(perGuessChar, 0);
            }
            map.put(perSecretChar, map.get(perSecretChar) + 1);
            if(perGuessChar == perSecretChar){
                A++;
            }
            else{
                B++;
            }
            map.put(perGuessChar, map.get(perGuessChar) - 1);


        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            Integer num = entry.getValue();

            if(num != null && num < 0){
                B += num;
            }
        }
        return "" + A + "A" + B + "B";


    }
}
