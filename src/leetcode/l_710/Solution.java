package leetcode.l_710;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Solution {
    Random r = new Random();
    public static void main(String[] args) {
        int[] black = {2,1};
        Solution solution = new Solution(4, black);
        System.out.println(solution.pick());
        System.out.println(solution.pick());
        System.out.println(solution.pick());
        System.out.println(solution.pick());

    }
    Map<Integer, Integer> map;
    int len;
    int M;
    public Solution(int N, int[] blacklist) {
        len = blacklist.length;
        M = N -len;
        map = new HashMap<>();
        for(int per : blacklist){
            map.put(per, -1);
        }

        for(int per : blacklist){
            if(per < M) {
                while (map.containsKey(N - 1)) {
                    N--;
                }
                map.put(per, N - 1);
                N--;
            }
        }
    }

    public int pick() {

        int rd = r.nextInt(M);
        if(map.containsKey(rd)){
            return map.get(rd);
        }

        return rd;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(N, blacklist);
 * int param_1 = obj.pick();
 */