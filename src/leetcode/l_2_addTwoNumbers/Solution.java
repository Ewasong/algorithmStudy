package l_2_addTwoNumbers;

public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode result = new Solution().addTwoNumbers(l1, l2);

        while (result != null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    /***
     * 链表大整数加法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode cur = null;
        int addCarry = 0;
        while (l1 != null || l2 != null || addCarry > 0) {
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;
            int curSum = l1Val + l2Val + addCarry;
            addCarry = curSum >= 10 ? 1 : 0;
            curSum = curSum >= 10 ? curSum - 10 : curSum;
            if (cur == null) {
                result = new ListNode(curSum);
                cur = result;
            } else {
                cur.next = new ListNode(curSum);
                cur = cur.next;
            }

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return result;
    }
}
