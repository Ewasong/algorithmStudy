package week188.minTime;

import java.util.*;
//ac
public class Solution {
    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
        List<Boolean> ap =
                new ArrayList<Boolean>(Arrays.asList(false,false,true,false,true,true,false));
        System.out.println(new Solution().minTime(7, edges, ap));
    }



    static Map<Integer, List<Integer>> edgesMap;
    static Set<Integer> apples ;
    static int ans = -1;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        edgesMap = new HashMap<>();
        apples = new HashSet<>(n);
        //苹果
        for (int i = 0; i < n; i++) {
            if (hasApple.get(i) == true) {
                apples.add(i);
            }
        }
        //构造边
        for (int[] per : edges) {
            if (!edgesMap.containsKey(per[0])) {
                edgesMap.put(per[0], new ArrayList<>());
            }
            if (!edgesMap.containsKey(per[1])) {
                edgesMap.put(per[1], new ArrayList<>());
            }
            edgesMap.get(per[0]).add(per[1]);
            edgesMap.get(per[1]).add(per[0]);

        }
        Step step = dfs(0,-1 );
        return step.apple ? step.x : 0;
    }

    static class Step {
        int x;
        boolean apple;
        public Step(int x, boolean apple) {
            this.x = x;
            this.apple = apple;
        }
    }
    public static Step dfs(int cur, int pre) {

        boolean find = false;
        if (apples.contains(cur)) {
            find = true;
            apples.remove(cur);
        }
        List<Integer> eg = edgesMap.get(cur);

        int sum = 0;
        if (eg != null) {
            for (int i = 0; i < eg.size(); i++) {
                if (eg.get(i) != pre) {
                    Step step = dfs(eg.get(i), cur);
                    if (step.apple) {
                        find = true;
                        sum += step.x + 2;
                    }
                }
            }
        }

        return new Step(sum, find);
    }

}
