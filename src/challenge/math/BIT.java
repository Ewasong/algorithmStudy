package challenge.math;

/***
 * 树状数组
 */
public class BIT {
    static int MAXN = 1000;
    int bit[] = new int[MAXN + 1];
    int n;

    int sum(int i) {
        int s = 0;
        while (i > 0) {
            s += bit[i];
            i -= i & -i;
        }

        return s;
    }

    void add(int i, int x) {
        while (i <= n) {
            bit[i] += x;
            i += i & -i;
        }
    }
}
