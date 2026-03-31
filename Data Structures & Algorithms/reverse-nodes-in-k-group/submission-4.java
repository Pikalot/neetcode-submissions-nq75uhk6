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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode prevGroup = dummyHead;

        while (true) {
            ListNode kth = getKthNode(prevGroup, k);
            if (kth == null) return dummyHead.next;

            ListNode nextGroup = kth.next;
            ListNode tail = nextGroup;
            ListNode current = prevGroup.next;

            while (current != nextGroup) {
                ListNode temp = current.next;
                current.next = tail;
                tail = current;
                current = temp;
            }

            ListNode temp = prevGroup.next;
            prevGroup.next = kth;
            prevGroup = temp;
        }
    }

    private ListNode getKthNode(ListNode head, int k) {
        ListNode current = head;
        while (current != null && k > 0) {
            current = current.next;
            k--;
        }
        return current;
    }
}
