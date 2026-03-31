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
        ListNode slow = head, fast = head.next, curr = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newList = slow.next;
        slow.next = null;
        
        ListNode rev = null;
        while (newList != null) {
            ListNode temp = newList.next;
            newList.next = rev;
            rev = newList;
            newList = temp;
        }

        while (curr != null && rev != null) {
            ListNode temp1 = curr.next, temp2 = rev.next;
            curr.next = rev;
            rev.next = temp1;
            curr = temp1;
            rev = temp2;
        }
    }
}
