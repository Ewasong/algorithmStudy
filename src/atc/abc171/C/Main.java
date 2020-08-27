package atc.abc171.C;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();
        StringBuilder res = new StringBuilder();
        String s = "";
        for (int i = 0; i <= 25; i++) {
            s += (char)('a' + i);
        }

        while (n > 0) {
            int index = (int)((n-1) % 26);
            res.append(s.charAt(index));
            n = (n-1) / 26;
        }
        res = res.reverse();

        System.out.println(res.toString());
    }
}
