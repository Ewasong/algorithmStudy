package codeforces.contest1370.C;

import java.util.Scanner;

public class Main {

    //素数测试 O(sqrt(n))
    static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i ++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        String[] ans = {"Ashishgup", "FastestFinger"};
        while (T-- > 0) {
            int n = scan.nextInt();
            if (n == 1) {
                //如果为1 后手赢
                System.out.println(ans[1]);
            } else if (n == 2) {
                //如果为2 先手赢
                System.out.println(ans[0]);
            } else {
                //如果为奇数，先手赢
                if (n % 2 == 1) {
                    System.out.println(ans[0]);
                } else {
                    //如果为偶数，求出最大的奇因数
                    int oddDiv = n;
                    while (oddDiv % 2 == 0) {
                        oddDiv /= 2;
                    }
                    int evenDiv = n / oddDiv;
                    if (oddDiv == 1) {
                        //如果最大奇因数为1，那么后手赢
                        System.out.println(ans[1]);
                    } else if (n == oddDiv || evenDiv > 2) {
                        //如果最大奇因数等于n，或者最大偶因数大于2 那么先手赢
                        System.out.println(ans[0]);
                    } else {
                        //如果最大偶因数等于2
                        //如果最大奇数因数不是质数，那么先手可以选择除以最大奇数因数的最大因数(除了本身), 那么先手赢，否则后手赢
                        if (!isPrime(oddDiv)) {
                            System.out.println(ans[0]);
                        } else {
                            System.out.println(ans[1]);
                        }
                    }
                }
            }
        }
    }
}
