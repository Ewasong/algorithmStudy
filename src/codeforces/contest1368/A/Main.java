package codeforces.contest1368.A;

import java.util.Scanner;
//ac
//http://codeforces.com/contest/1368/problem/A
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t-- > 0) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int n = scan.nextInt();
            int opCnt = 0;
            while (n >= a && n >= b) {
                if (a > b) {
                    b += a;
                } else {
                    a += b;
                }
                opCnt++;
            }
            System.out.println(opCnt);
        }
    }
}