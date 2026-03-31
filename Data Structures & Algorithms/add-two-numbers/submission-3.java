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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode curr = result, i1 = l1, i2 = l2;
        int carry = 0;

        while (i1 != null && i2 != null) {
            int sum = i1.val + i2.val + carry;
            curr.val = sum % 10;
            carry = sum / 10;
            if (carry > 0 || i1.next != null || i2.next != null) {
                curr.next = new ListNode(carry);
                curr = curr.next;
            }
            i1 = i1.next;
            i2 = i2.next;
        }

        while (i1 != null) {
            int sum = i1.val + carry;
            curr.val = sum % 10;
            carry = sum / 10;
            if (carry > 0 || i1.next != null) {
                curr.next = new ListNode(carry);
                curr = curr.next;
            }
            i1 = i1.next;           
        }
        
        while (i2 != null) {
            int sum = i2.val + carry;
            curr.val = sum % 10;
            carry = sum / 10;
            if (carry > 0 || i2.next != null) {
                curr.next = new ListNode(carry);
                curr = curr.next;
            }
            i2 = i2.next;           
        }

        return result;
    }
}
