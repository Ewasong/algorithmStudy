package atc.abc171.F;

import java.util.Arrays;
import java.util.Scanner;

//没做出来
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int K = scan.nextInt();
        long dp[]= new long[1000005];
        dp[0] = 1;
        String s = scan.next();

        int mod = 1000000007;
        for (int i = 1; i <= K; i ++) {
            dp[i] = ((25 * (dp[i - 1] % mod)) + dp[i] % mod) % mod;
        }
        System.out.println(dp[K]);
    }
}
