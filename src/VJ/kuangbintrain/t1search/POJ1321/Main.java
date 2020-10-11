package VJ.kuangbintrain.t1search.POJ1321;

import java.util.Arrays;
import java.util.Scanner;

//n皇后问题 ac
public class Main {
    //标记列是否被占用
    static boolean[] colFlags = new boolean[9];
    //棋盘 # 代表空白区域
    static char[][] g = new char[9][9];
    //n*n的棋盘 k个棋子。
    static int n, k;
    static int ans = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            if (n == -1 && k == -1) {
                break;
            }
            for (int i = 1; i <= n; i++) {
                char[] perLineChars = scanner.next().toCharArray();
                System.arraycopy(perLineChars, 0, g[i], 1, perLineChars.length);
            }
            init();
            dfs(1, 0);
            System.out.println(ans);
        }
    }

    public static void init() {
        Arrays.fill(colFlags, false);
        ans = 0;
    }

    /**
     * @param curRow    : 当前行
     * @param hasSetNum : 已经设置的棋子数量
     * @return
     */
    public static void dfs(int curRow, int hasSetNum) {
        if (hasSetNum == k) {
            ans++;
        }
        if (curRow > n || hasSetNum == k) {
            return;
        }

        //剪枝：如果剩余行不能放到剩余的棋子
        if (n - curRow + 1 < k - hasSetNum) {
            return;
        }

        //遍历列找可以放的位置
        for (int i = 1; i <= n; i++) {
            if (g[curRow][i] == '#' && !colFlags[i]) {
                colFlags[i] = true;
                dfs(curRow + 1, hasSetNum + 1);
                colFlags[i] = false;
            }
        }
        //不放直接进入下一行
        dfs(curRow + 1, hasSetNum);
    }
}
