package codeforces.contest1370.D;

import java.util.Scanner;

/***
 * ac
 * 二分最小值，然后分别讨论二分值在奇数下标和偶数下标列中的情况。
 * 如果可以构造某序列使其中的值都小于等于二分值，则说明该二分值可行，设为上界，否则设为下界
 * https://www.cnblogs.com/Kanoon/p/13173407.html
 * @author soriee
 * @date 2020/6/23 21:44
 * @return
 */
public class Main {

    static int a[]= new int[200005];
    static int b[]= new int[200005];
    static int c[]= new int[200005];

    static int INF = (int)1e9 + 7;
    static int ans = 1;
    static int n;
    static int k;

    public static boolean check() {
        int p = 0;
        for (int i = 0; i < n; i++) {
            if (p < k && c[p] >= b[i]) p++;
        }
        return p == k;
    }

    public static boolean solve(int val) {
        for (int i = 0; i < n; i++) {
            b[i] = a[i] > val ? 1 : 0;
        }
        for (int t = 0; t < 2; t++) {
            for (int i = 0; i < k; i++) {
                c[i] = (i & 1) == t ? 0 : 1;
            }
            if (check()) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        k = scan.nextInt();
        a = new int[200005];

        ans = INF;
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        int l = 0, r = INF;
        while (r - l > 1) {
            int mid = (l + r) / 2;
            if (solve(mid)) {
                r = mid;
            } else {
                l = mid;
            }
        }
        System.out.println(r);
    }

}
