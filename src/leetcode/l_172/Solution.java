package leetcode.l_207;

/**
 * Created by 81929 on 2018/7/20.
 */
//阶乘后的零
public class Solution {

    public static void main(String[] args) {
//        System.out.println(new Solution().trailingZeroes(125));
        for(int i = 5; i < 1000; i++) {
            if(new Solution().trailingZeroes3(i) != new Solution().trailingZeroes1(i)){
                System.out.println(i);
                System.out.println(new Solution().trailingZeroes3(i));
                System.out.println(new Solution().trailingZeroes1(i));
                break;

            }
        }
    }

    public int trailingZeroes(int n) {

        int res = 0;
        while(n >= 5){

            n /= 5;
            res += n;
        }
        return res;
    }

    public int trailingZeroes1(int n) {
        return n < 5 ? 0 : n/5 + trailingZeroes1(n/5);
    }

    public int trailingZeroes3(int n) {
        int lg = (int) (Math.log(n) / Math.log(5));
        int res = (lg) * (lg + 1) / 2 + (n - (int)(Math.pow(5, lg))) / 5;
        return res;
    }
}
