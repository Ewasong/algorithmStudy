package codeforces.contest1368.B;

import java.util.*;

//ac
// http://codeforces.com/contest/1368/problem/B
public class Main {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        long k = scanner.nextLong();

        String s = "codeforces";
        StringBuilder res = new StringBuilder();
        long a[] = new long[10];
        Arrays.fill(a, 1);
        long n = 1;
        int cur = 0;
        while (k > n) {
            n = n / a[cur] * (a[cur] + 1);
            a[cur]++;
            cur++;
            if (cur == 10) {
                cur = 0;
            }
        }
        for (int i = 0; i < 10; i++) {
            while(a[i]-- > 0) {
                res.append(s.charAt(i));
            }
        }

        System.out.println(res);
    }
}
