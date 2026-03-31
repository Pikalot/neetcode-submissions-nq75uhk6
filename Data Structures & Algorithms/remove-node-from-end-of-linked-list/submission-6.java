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
        ListNode current = head, tail = head, prev = null;
        while (n > 0) {
            tail = tail.next;
            n--;
        }

        if (tail == null) return head.next;

        while (tail != null) {
            prev = current;
            current = current.next;
            tail = tail.next;
        }

        prev.next = current.next;
        return head;
    }
}
