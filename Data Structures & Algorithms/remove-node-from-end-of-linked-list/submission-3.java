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
        ListNode fast = head, slow = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // Remove the first node case
        if (fast == null) return head.next;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        
        return head;
        
        // int length = 0;
        // ListNode curr = head;

        // while (curr != null) {
        //     curr = curr.next;
        //     length++;
        // }

        // if (length == 1) return null;

        // int removedIndex = length - n;
        // if (removedIndex == 0) {
        //     head = head.next;
        //     return head;
        // }

        // curr = head;
        // ListNode prev = null;
        
        // for (int i = 0; i < removedIndex; i++) {
        //     prev = head;
        //     head = head.next;
        // }

        // prev.next = head.next;
        // head = null;
        // return curr;
    }
}
