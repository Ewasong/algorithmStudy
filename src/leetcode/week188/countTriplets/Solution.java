package week188.countTriplets;
//ac
public class Solution {
    public static void main(String[] args) {
        int[] target = {1,1,1,1,1};
        System.out.println(new Solution().countTriplets(target));
    }

    public int countTriplets(int[] arr) {
        Integer cur = 0;
        int ans = 0;
        for (int i = 0; i < arr.length; i ++) {

            cur = 0;
            for (int j = i + 1; j < arr.length; j++) {
                cur ^= arr[j-1];
                int another = 0;
                for (int k = j; k < arr.length; k ++) {
                    another ^= arr[k];
                    if (cur == another) {
                        ans ++;
                    }
                }
            }
        }
        return ans;
    }

}
