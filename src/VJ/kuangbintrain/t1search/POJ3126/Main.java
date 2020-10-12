package VJ.kuangbintrain.t1search.POJ3126;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//给定两个数, 都是4位，每次只能变换一位，求最短的质数路径。
//MLE
public class Main {
    public static final int MAXN = 10000;
    public static boolean[] primeFlag = new boolean[MAXN];

    public static void main(String[] args) {
        Main main = new Main();
        main.initPrimeTable();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            System.out.println(main.bfs(start, end));
        }
    }

    class Node {
        public int val;
        public int step;
        public Node(int val, int step) {
            this.val = val;
            this.step = step;
        }
    }
    public int bfs(int start, int end) {
        if (start == end) {
            return 0;
        }
        boolean[] flag;
        flag = new boolean[MAXN];
        Arrays.fill(flag, false);
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(new Node(start, 0));
        flag[start] = true;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int i = 1; i <= 4; i++) {
                for (int j = 0; j <= 9; j++) {
                    //第i位变成j 注意第一位不能为0
                    if (i == 1 && j == 0) {
                        continue;
                    }
                    int nextVal = change(cur.val, i, j);
                    if (nextVal == end) {
                        return cur.step + 1;
                    } else if (!flag[nextVal] && this.isPrime(nextVal)) {
                        //没访问过 且是质数 那么放入队列
                        queue.add(new Node(nextVal, cur.step + 1));
                    }
                }
            }
        }
        return 0;
    }
    //val的第bit位变为bitVal
    public int change(int val, int bit, int bitVal) {
        int[] valArr = new int[5];
        for (int i = 4; i >= 1; i--) {
            valArr[i] = val % 10;
            val /= 10;
        }
        valArr[bit] = bitVal;
        val = 0;
        for (int i = 1; i <= 4; i++) {
            if (i != 1) {
                val *= 10;
            }
            val += valArr[i];
        }
        return val;
    }
    public boolean isPrime(int i) {
        return primeFlag[i];
    }
    public void initPrimeTable() {
        int sqrtMaxn = (int) Math.sqrt(MAXN) + 1;
        Arrays.fill(primeFlag, true);
        primeFlag[0] = primeFlag[1] = false;
        for (int i = 2; i <= sqrtMaxn; i++) {
            if (primeFlag[i]) {
                for (int j = 2 * i; j < MAXN; j += i) {
                    primeFlag[j] = false;
                }
            }
        }
    }
}
