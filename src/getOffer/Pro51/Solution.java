package getOffer.Pro51;

import java.util.Arrays;

//ac
public class Solution {

    public static void main(String[] args) {
        int a[] = {7, 5, 6, 4};
        int n = new Solution().reversePairs(a);
        System.out.println(n);
    }

    int bit[], n;
    public int reversePairs(int[] nums) {
        //离散化
        int temp[] = Arrays.copyOf(nums, nums.length);

        Arrays.sort(temp);
        int maxn = 0;
        for (int i = 0; i < nums.length; i++) {
            int pos = lowerBound(temp, 0, nums.length, nums[i]) + 1;
            nums[i] = pos;
        }

        n = nums.length;
        bit = new int[n + 1];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int k = i - query(nums[i]);
            ans += k;
            add(nums[i], 1);
        }
        return ans;
    }

    public static int lowerBound(int[] nums, int l, int r, int target) {
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] >= target) r = m;
            else l = m + 1;
        }
        return l;

    }

    void add(int i, int x) {
        while (i <= n) {
            bit[i] += x;
            i += (i & -i);
        }
    }

    int query(int i) {
        int s = 0;
        while (i > 0) {
            s += bit[i];
            i -= (i & -i);
        }

        return s;
    }
}
