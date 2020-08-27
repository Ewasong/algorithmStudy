package atc.abc171.E;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int a[] = new int[200005];
        int xorSum = 0;
        for (int i = 0; i < N; i++) {
            a[i] = scan.nextInt();
            xorSum ^= a[i];
        }
        for (int i = 0; i < N; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(xorSum ^ a[i]);
        }
        System.out.println();
    }
}
