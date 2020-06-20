package VJ.poj.poj3278;
//https://vjudge.net/problem/POJ-3278

import java.util.*;

/**
 * Farmer John has been informed of the location of a fugitive cow and wants to catch her immediately.
 * He starts at a point N (0 ≤ N ≤ 100,000) on a number line and the cow is at a point K (0 ≤ K ≤ 100,000)
 * on the same number line. Farmer John has two modes of transportation: walking and teleporting.
 *
 * * Walking: FJ can move from any point X to the points X - 1 or X + 1 in a single minute
 * * Teleporting: FJ can move from any point X to the point 2 × X in a single minute.
 *
 * If the cow, unaware of its pursuit, does not move at all, how long does it take for Farmer John to retrieve it?
 */
public class Main {
    public static int n, k;
    public static int maxn = 100000 + 5;
    public static boolean[] flag = new boolean[maxn];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            System.out.println(bfs(n, k));
        }
    }
    public static class Step {
        public int x;
        public int stepCnt;
        public Step(int x, int stepCnt){
            this.x = x;
            this.stepCnt = stepCnt;
        }
    }
    public static int bfs(int n, int k) {
        Arrays.fill(flag, false);
        Queue<Step> queue = new LinkedList<Step>();
        queue.offer(new Step(n, 0));
        flag[n] = true;

        while (!queue.isEmpty()) {
            Step cur = queue.poll();
            if (cur.x == k) {
                return cur.stepCnt;
            }
            int[] offset = {-1, 1, cur.x};
            for (int i = 0; i < offset.length; i++) {
                int next = cur.x + offset[i];
                if (next >= 0 && next < maxn && !flag[next]) {
                    flag[next] = true;
                    queue.offer(new Step(next, cur.stepCnt +1));
                }
            }

        }
        return -1;
    }
}
