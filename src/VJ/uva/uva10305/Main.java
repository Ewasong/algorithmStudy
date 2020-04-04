package VJ.uva.uva10305;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 拓扑排序
 */
public class Main {
    static final int maxn = 105;
    static int[] vis = new int[maxn];
    static List<List<Integer>> g = new ArrayList<>(maxn);
    static int n, edgeNum;
    static int cnt;
    static int[] ans = new int[maxn];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < maxn; i++) {
            g.add(i, new ArrayList<>());
        }

        while (scan.hasNextInt()) {
            n = scan.nextInt();
            edgeNum = scan.nextInt();
            if (n == 0 && edgeNum == 0) {
                break;
            }
            init();
            for (int i = 0; i < edgeNum; i++) {
                int a = scan.nextInt();
                int b = scan.nextInt();
                g.get(a).add(b);
            }
            topoSort();
            for (int i = 0; i < n; i++) {
                if (i != 0) {
                    System.out.print(" ");
                }
                System.out.print(ans[i]);
            }
            System.out.println();

        }

        List<Character> contents = new ArrayList<>();


    }


    public static void init(){
        for(int i = 0; i < maxn; i++){
            g.get(i).clear();
            vis[i] = 0;
        }
    }

    public static boolean topoSort(){
        cnt = n;
        for(int i = 1; i <= n; i++){
            if(vis[i] == 0){
                if(!dfs(i)){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean dfs(int u){
        vis[u] = -1;
        List<Integer> edge = g.get(u);
        for(int i = 0; i < edge.size(); i++){
            int v = edge.get(i);
            if(vis[v] == -1){
                return false;
            }
            if(vis[v] == 0 && !dfs(v)){
                return false;
            }
        }
        vis[u] = 1;
        ans[--cnt] = u;
        return true;
    }


}
