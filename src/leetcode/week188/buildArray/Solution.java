package week188.buildArray;

import java.util.ArrayList;
import java.util.List;
//ac
public class Solution {
    public static void main(String[] args) {
        int[] target = {1, 3};
        List<String> op = new Solution().buildArray(target, 3);
        op.forEach(System.out::println);
    }
    public static String push = "Push";
    public static String pop = "Pop";


    public List<String> buildArray(int[] target, int n) {
        List<String> op = new ArrayList<>(n);
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (target[index] != i) {
                op.add(push);
                op.add(pop);
            } else {
                op.add(push);
                index++;
            }
            if (index == target.length) {
                break;
            }
        }
        if (index == target.length) {
            return op;
        } else {
            return null;
        }
    }
}
