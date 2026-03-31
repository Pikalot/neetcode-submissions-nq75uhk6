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

        ListNode newList = slow.next;
        slow.next = null;
        
        ListNode revList = null;
        while (newList != null) {
            ListNode temp = newList.next;
            newList.next = revList;
            revList = newList;
            newList = temp;
        }

        ListNode curr = head;
        while (curr != null && revList != null) {
            ListNode temp1 = curr.next, temp2 = revList.next;
            curr.next = revList;
            revList.next = temp1;
            curr = temp1;
            revList = temp2;
        }
    }
}
