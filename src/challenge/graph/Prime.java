package challenge.graph;

import challenge.commmon.CommonStatic;

import java.util.Arrays;

public class Prime {
    final int MAX_V = 1000, MAX_E = 1000;
    int cost[][] = new int[MAX_V][MAX_V];
    int mincost[] = new int[MAX_V];
    boolean used[] = new boolean[MAX_V];
    int V;

    int prime() {
        Arrays.fill(mincost, CommonStatic.INF);
        Arrays.fill(used, false);
        mincost[0] = 0;
        int res = 0;

        while (true) {
            int v = -1;
            for (int u = 0; u < V; u ++) {
                if (!used[u] && (v == -1 || mincost[u] < mincost[v])) v = u;
            }
            if (v == -1) break;
            used[v] = true;
            res += mincost[v];
            for (int u = 0; u < V; u ++) {
                mincost[u] = Math.min(mincost[u], cost[v][u]);
            }
        }
        return res;
    }
}
