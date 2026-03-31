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
        int length = 0;
        ListNode curr = head;

        while (curr != null) {
            curr = curr.next;
            length++;
        }

        if (length == 1) return null;

        int removedIndex = length - n;
        if (removedIndex == 0) head = head.next;

        curr = head;
        ListNode prev = null;
        
        for (int i = 0; i < removedIndex; i++) {
            prev = head;
            head = head.next;
        }

        System.out.println(curr.val);
        if (prev != null) prev.next = head.next;
        head = null;
        return curr;
    }
}
