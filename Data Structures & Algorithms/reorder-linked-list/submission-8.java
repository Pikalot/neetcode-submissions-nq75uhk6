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
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode current = slow.next, tail = null;
        slow.next = null;
        while (current != null) {
            ListNode temp = current.next;
            current.next = tail;
            tail = current;
            current = temp;
        }

        current = head;
        while (tail != null) {
            ListNode temp = current.next, temp2 = tail.next;
            current.next = tail;
            tail.next = temp;
            current = temp;
            tail = temp2;
        }
    }
}
