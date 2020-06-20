package challenge.math;

import java.util.Arrays;

public class PrimeSieve {
    // 埃氏筛法  O(sqrt(n))
    int prime[] = new int[1000];
    boolean isPrime[] = new boolean[1000];

    // 返回n以内素数个数
    int sieve(int n) {
        int p = 0;
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                prime[p++] = i;
                for (int j = 2 * i; j <= n; j+= i) isPrime[j] = false;
            }
        }
        return p;
    }
}
