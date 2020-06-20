package challenge.graph;

import java.util.Arrays;

public class BellmanFord {


    Edge edges[] = new Edge[1000];
    //到起点的最短距离
    int d[] = new int[1000];
    int V, E; //V是起点数，E是边数。
    int INF = 0x3fffffff;
    void shortestPath(int s) {
        Arrays.fill(d, 0, V, INF);
        d[s] = 0;
        while (true) {
            boolean updateFlag = false;
            for (int i = 0; i < E; i++) {
                Edge e = edges[i];

                if (d[e.from] != INF && d[e.to] > d[e.from] + e.cost) {
                    d[e.to] = d[e.from] + e.cost;
                    updateFlag = true;
                }
            }
            if (!updateFlag) {
                break;
            }
        }
    }

    boolean findNegativeLoop() {
        Arrays.fill(d, 0);
        for (int i = 0; i < V; i++) {
            for(int j = 0; j < E; j++) {
                Edge e = edges[j];
                if (d[e.to] > d[e.from] + e.cost) {
                    d[e.to] = d[e.from] + e.cost;
                    if (i == V - 1) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
