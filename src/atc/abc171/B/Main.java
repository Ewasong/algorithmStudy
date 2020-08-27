package atc.abc171.B;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int K = scan.nextInt();
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            a.add(scan.nextInt());
        }
        Collections.sort(a);
        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += a.get(i);
        }
        System.out.println(sum);
    }
}
