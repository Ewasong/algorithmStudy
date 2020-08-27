package atc.abc171.D;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>(10000);
        int N = scan.nextInt();
        long sum = 0;
        for (int i = 0; i < N; i++) {
            int cur = scan.nextInt();
            if (!map.containsKey(cur)) {
                map.put(cur, 0);
            }
            map.put(cur, map.get(cur) + 1);
            sum += cur;
        }
        int Q = scan.nextInt();
        for (int i = 0; i < Q; i++) {
            int b = scan.nextInt();
            int c = scan.nextInt();
            if (map.containsKey(b)) {
                sum += (c - b) * (long) map.get(b);
                if (!map.containsKey(c)) {
                    map.put(c, 0);
                }
                map.put(c, map.get(c) + map.get(b));
                map.put(b, 0);
            }
            System.out.println(sum);
        }
    }
}
