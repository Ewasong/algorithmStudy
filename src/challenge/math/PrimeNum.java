package challenge.math;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PrimeNum {

    //素数测试 O(sqrt(n))
    boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i ++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    //约数枚举 O(sqrt(n))
    List<Integer> divisor(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                res.add(i);
                if (i != n / i) res.add(n / i);
            }
        }
        return res;
    }

    // 整数分解 O(sqrt(n))
    Map<Integer, Integer> primeFactor(int n) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                if (!map.containsKey(i)) map.put(i, 0);
                map.put(i, map.get(i) + 1);
                n /= i;
            }
        }
        if (n != 1) map.put(n, 1);
        return map;
    }
}
