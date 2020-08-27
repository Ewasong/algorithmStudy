package atc.agc046.B;

import java.util.Arrays;
import java.util.Scanner;

//wa!!
//https://atcoder.jp/contests/agc046/tasks/agc046_b

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int dp[][] = new int[3005][3005];
        int A = scan.nextInt();
        int B = scan.nextInt();
        int C = scan.nextInt();
        int D = scan.nextInt();
        dp[A][B] = 1;

        for (int i = A; i <= C; i++) {
            for (int j = B; j <= D; j++) {
                if (i == A && j == B) {
                    continue;
                }
                dp[i][j] = 0;
                if (i - 1 >= A && j - 1 >= B) {
                    dp[i-1][j] = dp[i-1][j-1] * (i-1);
                    dp[i][j-1] = dp[i-1][j-1] * (j-1);
                    dp[i][j] = dp[i-1][j] * j + dp[i][j-1] * i - (i-1) * (j-1);
                }
                else if (i - 1 >= A) {
                    dp[i][j] = dp[i-1][j] * j;
                }
                else if (j - 1 >= B) {
                    dp[i][j] = dp[i][j-1] * i;
                }

            }
        }
        for (int i = A; i <= C; i++) {
            for (int j = B; j <= D; j++) {
                System.out.print(dp[i][j] + "\t");
//                System.out.println( i + " " + j + ":" + dp[i][j] );
            }
            System.out.println();
        }
        System.out.println(dp[C][D]);
    }
}
