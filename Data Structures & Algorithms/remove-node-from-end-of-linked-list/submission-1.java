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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        int length = 0;
        ListNode temp = head;
        while(temp != null){
            length++;
            temp = temp.next;
        }

        int pos = length-n;
        if(pos == 0){
            head = head.next;
            return head;
        }

        temp = head;
        int i = 0;
        while(i != pos-1){
            temp = temp.next;
            i++;
        }

        temp.next = temp.next.next;

        return head;
    }
}
