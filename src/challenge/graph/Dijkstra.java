package challenge.graph;

import challenge.commmon.CommonStatic;

import java.util.Arrays;

public class Dijkstra {
    final int MAX_V = 1000, MAX_E = 1000;
    int cost[][] = new int[MAX_V][MAX_V];   //邻接表
    int d[] = new int[MAX_V];   //最短距离
    boolean used[] = new boolean[MAX_V];    //已经使用过的顶点
    int V;  //顶点数
    //求最短路径
    //O(|V|^2)
    void dijkstra(int s) {
        Arrays.fill(d, CommonStatic.INF);
        Arrays.fill(used, false);
        d[s] = 0;

        while (true) {
            int v = -1;
            for (int u = 0; u < V; u++) {
                if(!used[u] && (v == -1 || d[u] < d[v])) {
                    u = v;
                }
            }
            if (v == -1) {
                break;
            }
            used[v] = true;
            for (int u = 0; u < V; u++) {
                d[u] = Math.min(d[u], d[v] + cost[v][u]);
            }
        }
    }

}
