package challenge.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kruskal {
    final int MAX_V = 1000, MAX_E = 1000;
    List<Edge> edges = new ArrayList<>();
    int V, E;

    int kruskal() {
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.cost - o2.cost;
            }
        });
        initUnion(V);
        int res = 0;
        for (Edge e : edges) {
            if (!same(e.from, e.to)) {
                unite(e.from, e.to);
                res += e.cost;
            }
        }
        return res;
    }

    int par[] = new int[MAX_V];
    int rank[] = new int[MAX_V];
    void initUnion(int n) {
        for (int i = 0; i < V; i++) {
            rank[i] = 0;
            par[i] = i;
        }
    }

    int find(int x) {
        if (par[x] == x) {
            return x;
        }
        par[x] = find(par[x]);
        return par[x];
    }

    void unite(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) {
            return;
        }
        if (rank[py] < rank[px]) {
            par[py] = px;
        } else {
            par[px] = py;
            if (rank[py] == rank[px]) {
                rank[py]++;
            }
        }
    }
    boolean same(int x, int y) {
        return find(x) == find(y);
    }
}
