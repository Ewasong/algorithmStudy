package VJ.poj.poj1321;

import java.util.Arrays;
import java.util.Scanner;

//https://vjudge.net/problem/POJ-1321
public class Main {
    static int n;
    static int k;
    static String[] mp = new String[1000];
    static boolean[] flag = new boolean[1000];
    static int ans;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextInt()){
            n = scan.nextInt();
            k = scan.nextInt();
            if(n == -1 && k == -1){
                break;
            }

            for(int i = 0; i < n; i++){
                mp[i] = scan.next();
            }
            Arrays.fill(flag, false);
            ans = 0;
            dfs(0, 0);
            System.out.println(ans);
        }
    }

    public static void dfs(int row, int step){
        if(step == k){
            ans++;
            return;
        }
        if(row >= n){
            return;
        }
        for(int i = 0; i < n; i++){
            if(!flag[i] && mp[row].charAt(i) == '#'){
                flag[i] = true;
                dfs(row + 1, step + 1);
                flag[i] = false;

            }
        }
        dfs(row + 1, step);

    }

}
