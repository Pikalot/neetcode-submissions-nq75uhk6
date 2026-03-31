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
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> priorityNodes = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        for (ListNode node: lists) {
            while (node != null) {
                priorityNodes.add(node);
                node = node.next;
            }
        }

        while (!priorityNodes.isEmpty()) {
            ListNode node = priorityNodes.poll();
            curr.next = node;
            curr = curr.next;
        }
        return dummy.next;
    }
}
