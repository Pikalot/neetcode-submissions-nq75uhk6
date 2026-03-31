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
        ListNode l = new ListNode();
        ListNode curr1 = l1, curr2 = l2, curr = l;
        int carry = 0;

        while (curr1 != null && curr2 != null) {
            int sum = curr1.val + curr2.val + carry;
            carry = sum / 10;
            curr.val = sum % 10;

            curr1 = curr1.next;
            curr2 = curr2.next;
            
            if (curr1 == null || curr2 == null) break;
            curr.next = new ListNode();
            curr = curr.next;
        }

        while (curr1 != null) {
            int sum = carry + curr1.val;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            curr1 = curr1.next;
        }

        while (curr2 != null) {
            System.out.println(curr2.val + " curr2 is not null ");
            int sum = carry + curr2.val;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            curr2 = curr2.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return l;
    }
}
