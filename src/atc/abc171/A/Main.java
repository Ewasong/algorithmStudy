package atc.abc171.A;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        if ('A' <= a.charAt(0) && a.charAt(0) <= 'Z') {
            System.out.println("A");
        } else {
            System.out.println("a");
        }
    }
}
