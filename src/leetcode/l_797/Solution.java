package leetcode.l_797;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    private boolean[] flag = new boolean[16];
    private int n;
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] g = {{1,2}, {3}, {3}, {}};
        List<List<Integer>> res = solution.allPathsSourceTarget(g);
        for(int i = 0 ; i < res.size(); i++){
            System.out.println(res.get(i).toString());
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> curRes = new ArrayList<>();
        Arrays.fill(flag, false);
        flag[0] = true;
        curRes.add(0);
        dfs(0, graph, resList, curRes);
        return resList;
    }

    private void dfs(int cur, int[][] graph, List<List<Integer>> resList, List<Integer> curRes) {

        if (cur == graph.length - 1) {
            List<Integer> oneRes = new ArrayList<>();
            oneRes.addAll(curRes);
            resList.add(oneRes);
            return;
        }
        for (int i = 0; i < graph[cur].length; i++) {
            if (flag[graph[cur][i]]) {
                continue;
            }
            curRes.add(graph[cur][i]);
            flag[graph[cur][i]] = true;
            dfs(graph[cur][i], graph, resList, curRes);
            flag[graph[cur][i]] = false;
            curRes.remove(curRes.size() - 1);
        }
    }
}