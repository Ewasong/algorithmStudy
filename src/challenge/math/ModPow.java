package challenge.math;

public class ModPow {

    long modPow(long x, long n, long mod) {
        long res = 1;
        while (n > 0) {
            if ((n & 1) == 1) res = res * x % mod;
            x = x * x % mod;
            n >>= 1;
        }
        return res;
    }

    long modPow2(long x, long n, long mod) {
        if (n == 0) return 1;
        long res = modPow2(x * x % mod, n / 2, mod);
        if ((n & 1) == 1) res = res * x % mod;

        return res;
    }
}
