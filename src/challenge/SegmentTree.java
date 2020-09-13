package challenge;

/**
 * 线段树
 * 初始化是O(n)
 * 更新查询操作是O(log n)
 */
public class SegmentTree {


    int n, dat[];

    public SegmentTree(int n, int maxn) {
        this.n = n;
        this.dat = new int[2 * maxn - 1];
    }

    void init(int n_) {
        n = 1;
        while (n < n_) n *= 2;
        // 所有值设为INT_MAX
        for (int i = 0; i < 2 * n - 1; i++) {
            dat[i] = Integer.MAX_VALUE;
        }
    }

    //把第k个值更新为a
    void update(int k, int a) {
        if (k < 0 || k > n - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        //叶子节点
        k += n - 1;
        dat[k] = a;
        while (k > 0) {
            k = (k - 1) / 2;
            dat[k] = Math.min(dat[k * 2 + 1], dat[k * 2 + 2]);
        }
    }

    /**
     * 求[a,b)最小值
     * k是节点编号，l,r是表示这个节点对应的是[l,r)节点
     * @param a
     * @param b
     * @param k
     * @param l
     * @param r
     * @return
     */
    int query(int a, int b, int k, int l, int r) {
        if (r <= a || l >= b) {
            return Integer.MAX_VALUE;
        }
        //如果[a,b)包含[l,r)，就返回当前节点值
        if (a <= l && r <= b) {
            return dat[k];
        } else {
            //否则返回两个儿子节点中较小者
            int v1 = this.query(a, b, k * 2 + 1, l, (l + r) / 2);
            int v2 = this.query(a, b, k * 2 + 2, (l + r) / 2, r);
            return Math.min(v1, v2);
        }
    }
}
