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
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode tail = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = tail; // Now head pointer points to null or previous node
            tail = head; // Update tail node
            head = temp; // Head move to next node
        }

        return tail;
    }
}
