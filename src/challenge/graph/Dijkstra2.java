package challenge.graph;

import challenge.commmon.CommonStatic;
import javafx.util.Pair;

import java.util.*;

public class Dijkstra2 {
    final int MAX_V = 1000, MAX_E = 1000;
    int V;
    List<Edge> G[] = new ArrayList[MAX_V];
    int d[] = new int[MAX_V];
    int pre[] = new int[MAX_V];
    //复杂度 O(|E|log|V|)
    void dijkstra(int s) {
        //key是路径长度，val是顶点
        PriorityQueue<Pair<Integer,Integer>> que = new PriorityQueue<>(
                new Comparator<Pair<Integer,Integer>>() {
                    @Override
                    public int compare(Pair<Integer,Integer> o1, Pair<Integer,Integer> o2) {
                        return o1.getKey() - o2.getKey();
                    }
                }
        );

        Arrays.fill(d, CommonStatic.INF);
        d[s] = 0;
        que.offer(new Pair<>(0, s));
        while (!que.isEmpty()) {
            Pair<Integer, Integer> p = que.poll();
            int v = p.getValue();

            if (d[v] < p.getKey()) continue;
            for (int i = 0; i < G[v].size(); i++) {
                Edge e = G[v].get(i);
                if (d[e.to] > d[v] + e.cost) {
                    d[e.to] = d[v] + e.cost;
                    pre[e.to] = v;
                    que.offer(new Pair<>(d[e.to], e.to));
                }
            }
        }
    }
    List<Integer> getPath(int t) {
        List<Integer> path = new ArrayList<>();
        for (; t != -1; t = pre[t]) path.add(t);
        Collections.reverse(path);
        return path;
    }
}
