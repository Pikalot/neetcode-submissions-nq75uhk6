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
        ListNode fast = head.next;
        ListNode slow = head;
        ListNode curr = null;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // split linked list into 2 sub lists
        ListNode newList = slow.next;
        slow.next = null;

        while (newList != null) {
            ListNode temp = newList.next;
            newList.next = curr;
            curr = newList;
            newList = temp;
        }

        while (curr != null) {
            ListNode tempH = head.next;
            ListNode tempC = curr.next;
            head.next = curr;
            curr.next = tempH;
            head = tempH;
            curr = tempC;
        }
    }
}
