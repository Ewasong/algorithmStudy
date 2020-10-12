package VJ.poj.poj3279;

import java.util.Scanner;

/**
 * Created by 81929 on 2019/6/1.
 */
//https://vjudge.net/problem/POJ-3279 ac
//todo 有更好的做法
//要将一个M * N的黑白色相间的格子翻转为白色（翻转可会使指定格子以及其上下左右相邻的格子反色），并求出最优解

/***
 * 第一行确定了的话，下面是否翻转就确定了，因为第一行不再翻转之后，如果有1，要变成0，
 * 只能翻转它对应位置的下一个翻转；枚举第一行翻转的所有情况，找到翻转次数最小的。
  */
public class Main {
    static int[][] G = new int[20][20];
    static int m, n;
    static int[][] hit = new int[20][20];
    static int[][] tempHit = new int[20][20];
    static final int inf = 1<<30;
    static int ans;

    public static void flip(int x, int y){
        tempHit[x][y] ^= 1;
        G[x][y] ^= 1;
        G[x - 1][y] ^= 1;
        G[x + 1][y] ^= 1;
        G[x][y - 1] ^= 1;
        G[x][y + 1] ^= 1;
    }
    public static void copyTempHitToHit(){
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                hit[i][j] = tempHit[i][j];
            }
        }
    }
    public static void solve(int x, int step){
        if(step >= ans){
            return;
        }
        int i = 0;
        if(x == m){
            //
            for(i = 1; i <= n; i++){
                if(G[m][i] != 0){
                    break;
                }
            }
            if(i <= n){
                return;
            }
            ans = step;
            copyTempHitToHit();
            return;
        }

        //保证每个都是白色，不是白色翻转这块下面的那个砖块
        for(int j = 1; j <= n; j++){
            if(G[x][j] != 0){
                flip(x + 1, j);
                step++;
            }
        }
        solve(x + 1, step);
        //恢复翻转的情况
        for(int j = 1; j <= n;j++) {
            if (tempHit[x + 1][j] != 0) {
                flip(x + 1, j);
            }
        }
    }

    //枚举第一行的翻转情况
    public static void dfs(int y, int step){
        if(step >= ans){
            return;
        }
        else if(y == n + 1){
            solve(1, step);
            return;
        }
        else {
            dfs(y + 1, step);
            flip (1, y);
            dfs(y + 1, step + 1);
            flip (1, y);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()){
            m = scan.nextInt();
            n = scan.nextInt();
            ans = inf;

            for(int i = 1; i <= m; i++){
                for(int j = 1; j <= n; j++){
                    G[i][j] = scan.nextInt();
                    hit[i][j] = 0;
                    tempHit[i][j] = 0;
                }
            }
            dfs(1, 0);
            if(ans != inf) {
                for (int i = 1; i <= m; i++) {
                    for (int j = 1; j <= n; j++) {
                        if (j != 1) {
                            System.out.print(" ");
                        }
                        System.out.print(hit[i][j]);
                    }
                    System.out.println();
                }
            }
            else {
                System.out.println("IMPOSSIBLE");
            }

        }
    }
}
