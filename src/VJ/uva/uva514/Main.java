package VJ.uva.uva514;

import java.util.Scanner;
import java.util.Stack;

/**
 * AC 790ms
 */
public class Main {
    public static void main(String[] args) {
        int n;
        int target[] = new int[1100];
        Scanner scanner = new Scanner(System.in);
        while ((n = scanner.nextInt()) != 0) {
            int i = 0;
            while (true) {
                i++;
                target[i] = scanner.nextInt();
                if (target[i] == 0) {
                    System.out.println();
                    break;
                }
                if (i == n) {
                    Stack<Integer> stack = new Stack<>();
                    int cur = 1;
                    int curIndex = 1;
                    boolean ok = true;
                    while (curIndex <= n) {
                        if (cur == target[curIndex]) {
                            cur++;
                            curIndex++;
                        } else if (!stack.isEmpty() && stack.peek() == target[curIndex]) {
                            curIndex++;
                            stack.pop();
                        } else if (cur <= n) {
                            stack.push(cur);
                            cur++;
                        } else {
                            ok = false;
                            break;
                        }
                    }
                    i = 0;
                    if (ok) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No");
                    }
                }
            }
        }
    }
}
