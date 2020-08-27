package codeforces.contest1370.B;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt();
            int a[] = new int[2 * n + 1];
            List<Integer> odd = new ArrayList<>(2 * n);
            List<Integer> even = new ArrayList<>(2 * n);

            for (int i = 1; i <= 2 * n; i ++) {
                a[i] = scan.nextInt();
                if ((a[i] & 1) == 1) {
                    odd.add(i);
                } else {
                    even.add(i);
                }
            }
            int ans = 0;
            for (int i = 0; i < odd.size(); i += 2) {
                if (i + 1 < odd.size()) {
                    if (ans == n - 1) {
                        break;
                    }
                    System.out.println(odd.get(i) + " " + odd.get(i + 1));
                    ans ++;
                }
            }

            for (int i = 0; i < even.size(); i += 2) {
                if (i + 1 < even.size()) {
                    if (ans == n - 1) {
                        break;
                    }
                    System.out.println(even.get(i) + " " + even.get(i + 1));
                    ans ++;
                }
            }
        }
    }
}
