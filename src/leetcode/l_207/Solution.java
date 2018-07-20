package leetcode.l_207;

/**
 * Created by 81929 on 2018/7/20.
 */
//拓扑排序
public class Solution {

    private static  int n;
    private int[] hadSorted;
    private int[] sortedArr;

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        int[][] a = new int[][]{{0,1}};
//
//        System.out.println(s.canFinish(2, a));
//    }

    boolean dfs(int numCourses,boolean[][] G, int u){

        hadSorted[u]=-1;
        for(int v = 0; v < numCourses; v++){
            if(G[u][v]){
                if(hadSorted[v] < 0){
                    return false;
                }
                else if (hadSorted[v] == 0 && !dfs(numCourses, G, v)){
                    return false;
                }
            }
        }
        sortedArr[--n] = u;
        hadSorted[u]=1;

        return true;
    }

    boolean topoSort(int numCourses,int[][] prerequisites){
        n = numCourses;
        hadSorted = new int[numCourses];
        sortedArr = new int[numCourses];
        boolean[][] G = new boolean[numCourses][numCourses];
        for(int[] perRow : prerequisites){
            G[perRow[1]][perRow[0]] = true;
        }
        for(int i = 0; i < numCourses; i++){
            if(hadSorted[i] == 0 && !dfs(numCourses, G, i)){
                return false;
            }
        }
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        return topoSort(numCourses, prerequisites);
    }
}
