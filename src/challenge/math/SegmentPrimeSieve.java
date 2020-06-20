package challenge.math;

import java.util.Arrays;

public class SegmentPrimeSieve {
    boolean isPrim[] = new boolean[1000];
    boolean isPrimeSmall[] = new boolean[1000];

    // 求[a,b)以内素数个数
    // isPrime[i - a] = true => i是素数
    void segementSieve(long a, long b) {
        for (int i = 0;  (long)i * i < b; i++) isPrimeSmall[i] = true;
        for (int i = 0; i < b - a; i++) isPrim[i] = true;
        for (int i = 2; (long)i * i < b; i++) {
            if (isPrimeSmall[i]) {
                for (int j = 2 * i; (long) j * j < b; j += i) isPrimeSmall[j] = false; //筛 [2, srqt(b))
                //筛[a,b)
                for (long j = Math.max(2L, (a + i -1) / i) * i; j < b; j += b) isPrim[(int)(j-a)] = false;
            }
        }
    }
}
