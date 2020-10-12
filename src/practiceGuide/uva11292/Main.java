package practiceGuide.uva11292;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 你的 王国 里 有 一条 n 个头 的 恶 龙， 你 希望 雇 一些 骑士 把 它 杀死（ 即 砍掉 所有 头）。
 * 村里 有 m 个 骑士 可以 雇佣， 一个 能力 值 为 x 的 骑士 可以 砍掉 恶 龙 一个 直径 不超过 x 的 头，
 * 且 需要 支付 x 个 金币。 如何 雇佣 骑士 才能 砍掉 恶 龙 的 所有 头， 且 需要 支付 的 金币 最少？
 * 注意， 一个 骑士 只能 砍 一 个头（ 且不 能被 雇佣 两次）。
 * ac
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            int dragonNum = scanner.nextInt();
            int knightsNum = scanner.nextInt();
            if (dragonNum == 0 && knightsNum == 0) {
                break;
            }
            int dragons[] = new int[dragonNum];
            int knights[] = new int[knightsNum];
            for (int i = 0; i < dragonNum; i++) {
                dragons[i] = scanner.nextInt();
            }
            for (int i = 0; i < knightsNum; i++) {
                knights[i] = scanner.nextInt();
            }
            //贪心 排序，从小到大用每个骑士去斩恶龙
            Arrays.sort(dragons);
            Arrays.sort(knights);

            int ans = 0;
            int dragonIndex = 0;
            int knightIndex = 0;
            while (dragonIndex < dragonNum && knightIndex < knightsNum) {
                if (knights[knightIndex] >= dragons[dragonIndex]) {
                    ans += knights[knightIndex];
                    knightIndex++;
                    dragonIndex++;
                } else {
                    knightIndex++;
                }
            }

            if (dragonIndex >= dragonNum) {
                System.out.println(ans);
            } else {
                System.out.println("Loowater is doomed!");
            }
        }

    }
}
