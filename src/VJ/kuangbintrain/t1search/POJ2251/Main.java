package VJ.kuangbintrain.t1search.POJ2251;

import java.util.*;

//https://vjudge.net/problem/POJ-2251
//宽搜  3D迷宫找出口 ac
public class Main {
    static boolean[][][] flag = new boolean[40][40][40];
    static String[][] G = new String[30][30];
    static int l, r, c;
    static int startL, startR, startC;

    static class Node {
        public int x;
        public int y;
        public int z;
        public int dis = 0;

        public Node() {

        }

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.dis = 0;
        }

        public Node(int x, int y, int z, int dis) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.dis = dis;
        }

    }

    static List<Node> dir = new ArrayList<Node>();

    static {
        dir.add(new Node(-1, 0, 0));
        dir.add(new Node(0, -1, 0));
        dir.add(new Node(0, 0, -1));
        dir.add(new Node(1, 0, 0));
        dir.add(new Node(0, 1, 0));
        dir.add(new Node(0, 0, 1));
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            l = scan.nextInt();
            r = scan.nextInt();
            c = scan.nextInt();
            if (l == 0 && r == 0 && c == 0) {
                break;
            }
            //输入并找到起始点
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    G[i][j] = scan.next();
                    for (int k = 0; k < c; k++) {
                        if (G[i][j].charAt(k) == 'S') {
                            startL = i;
                            startR = j;
                            startC = k;
                        }
                    }
                }
            }
            int ans = new Main().bfs(startL, startR, startC);
            if (ans != -1) {
                String msg = String.format("Escaped in %d minute(s).", ans);
                System.out.println(msg);
            } else {
                System.out.println("Trapped!");
            }
        }
    }

    public int bfs(int x, int y, int z) {
        Node startNode = new Node(x, y, z);
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(startNode);
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 40; j++) {
                for (int k = 0; k < 40; k++) {
                    flag[i][j][k] = false;
                }
            }
        }
        flag[x][y][z] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < dir.size(); i++) {
                int nx = node.x + dir.get(i).x;
                int ny = node.y + dir.get(i).y;
                int nz = node.z + dir.get(i).z;
                int nDis = node.dis + 1;
                if (nx >= l || nx < 0 || ny >= r || ny < 0
                        || nz >= c || nz < 0) {
                    continue;
                }
                if (G[nx][ny].charAt(nz) == 'E') {
                    return nDis;
                }
                if (G[nx][ny].charAt(nz) == '#') {
                    continue;
                }
                if (!flag[nx][ny][nz] && G[nx][ny].charAt(nz) == '.') {
                    queue.offer(new Node(nx, ny, nz, nDis));
                    flag[nx][ny][nz] = true;
                }
            }
        }

        return -1;
    }
}
