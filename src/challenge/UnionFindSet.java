package challenge;

public class UnionFindSet {
    private int[] par = new int[1000];
    private int[] rank = new int[1000];
    void init(int n) {
        for (int i = 1; i <= n; i++) {
            par[i] = i;
            rank[i] = 0;
        }
    }
    int find(int x) {
        if (par[x] == x) {
            return x;
        } else {
            return par[x] = find(par[x]);
        }
    }

    //合并x y的集合
    void unite(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) {
            return;
        }
        if (rank[x] < rank[y]) {
            par[x] = y;
        } else {
            par[y] = x;
            if (rank[x] == rank[y]) {
                rank[x]++;
            }
        }
    }

    //判断是否同一集合
    boolean same(int x, int y) {
        return find(x) == find(y);
    }
}
