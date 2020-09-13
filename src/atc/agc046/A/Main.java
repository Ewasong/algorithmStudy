package atc.agc046.A;

import java.util.Scanner;
//ac
//https://atcoder.jp/contests/agc046/tasks/agc046_a
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int gcd = gcd(n, 360);
        System.out.println(360 / gcd);
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}

