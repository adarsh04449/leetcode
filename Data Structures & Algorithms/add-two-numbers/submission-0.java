/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode temp = res;
        int carry = 0;

        ListNode temp1 = l1;
        ListNode temp2 = l2;

        while(temp1 != null || temp2 != null || carry != 0){
            int num1 = temp1 != null ? temp1.val : 0;
            int num2 = temp2 != null ? temp2.val : 0;

            int sum = num1 + num2 + carry;
            carry = sum / 10;
            int rem = sum % 10;

            temp.next = new ListNode(rem);
            temp = temp.next;

            temp1 = temp1 != null ? temp1.next : null;
            temp2 = temp2 != null ? temp2.next : null;
        }

        return res.next;
    }
}
