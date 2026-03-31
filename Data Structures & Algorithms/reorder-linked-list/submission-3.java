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
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode curr = null;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondList = slow.next;
        slow.next = null;
       
        while (secondList != null) {
            ListNode temp = secondList.next;
            secondList.next = curr;
            curr = secondList;
            secondList = temp;
        }

        // slow.next = null;

        // while (curr != null) {
        //     System.out.println(curr.val);
        //     curr = curr.next;
        // }

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
