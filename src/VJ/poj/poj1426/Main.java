package VJ.poj.poj1426;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

/**
 * https://vjudge.net/problem/POJ-1426
 *
 */
public class Main {
    public static int n;
    public static String ans = null;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            n = scanner.nextInt();
            if (n == 0) {
                break;
            }
            if (n == 1) {
                System.out.println(1);
                continue;
            }
            ans = null;
            solve("10", 10 , n, 1);
            System.out.println(ans);
        }
    }

    public static void solve(String tempAns, int m, int n, int deep) {
        if (ans != null) {
            return;
        }
        if (m % n == 0) {
            ans = tempAns;
        }
        //19有点奇怪 有些说是因为10^19会超过c++ long long 范围
        if (deep > 19) {
            return;
        }
        int m1 = m * 10 % n;

        solve(tempAns + "0", m1, n, deep +1);
        if (ans != null) {
            return;
        }

        int m2 = (m * 10 + 1) % n;

        solve(tempAns + "1", m2, n, deep +1);
        return;
    }
    public static boolean check(BigDecimal m, BigDecimal n) {
        return "0".equals(m.divideAndRemainder(n)[1].toPlainString());
    }
}
