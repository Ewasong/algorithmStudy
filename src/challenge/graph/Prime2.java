package challenge.graph;

import challenge.commmon.CommonStatic;
import javafx.util.Pair;

import java.util.*;
// 不太确定写得对不对
public class Prime2 {
    final int MAX_V = 1000, MAX_E = 1000;
    int V;
    List<Edge> G[] = new ArrayList[MAX_V];
    int mincost[] = new int[MAX_V];
    boolean used[] = new boolean[MAX_V];

    int prime2() {
        Arrays.fill(mincost, CommonStatic.INF);
        Arrays.fill(used, false);
        mincost[0] = 0;
        int res = 0;
        PriorityQueue<Pair<Integer,Integer>> que = new PriorityQueue<>(
                new Comparator<Pair<Integer,Integer>>() {
                    @Override
                    public int compare(Pair<Integer,Integer> o1, Pair<Integer,Integer> o2) {
                        return o1.getKey() - o2.getKey();
                    }
                }
        );
        for (Edge e : G[0]) {
            que.offer(new Pair<>(e.to, e.cost));
            mincost[e.to] = e.cost;
        }
        while (!que.isEmpty()) {
            Pair<Integer, Integer> p = que.poll();
            used[p.getKey()] = true;
            res += mincost[p.getKey()];
            for (Edge e: G[p.getKey()]) {
                mincost[e.to] = Math.min(mincost[e.to], e.cost);
            }
        }
        return res;
    }
}
