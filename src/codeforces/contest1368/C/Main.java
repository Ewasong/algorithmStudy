package codeforces.contest1368.C;


import java.util.List;
import java.util.Scanner;

/**  **
 *   ***
 *    **
 *
 *   **
 *   ***
 *    ***
 *     **
 *
 *   **
 *   ***
 *    ***
 *     ***
 *      **
 *
 *
 */
//ac
// http://codeforces.com/contest/1368/problem/C
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = 3 * n + 4;
        int line = n + 2;
        System.out.println(k);
        for (int i = 0; i < line; i++) {
            int cnt = i == 0 || i == line -1 ? 2 : 3;
            int xOffset = i <= 1 ? 0 : i - 1;
            while (cnt -- > 0) {
                System.out.println(xOffset + " " + i);
                xOffset++;
            }
        }

    }
}
