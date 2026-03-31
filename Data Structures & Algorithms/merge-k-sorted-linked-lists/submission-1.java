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
        Queue<ListNode> nodeHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        for (ListNode list: lists) {
            if (list != null) nodeHeap.offer(list);
        }

        while (!nodeHeap.isEmpty()) {
            ListNode node = nodeHeap.poll();
            current.next = node;
            current = current.next;

            node = node.next;
            if (node != null) {
                nodeHeap.offer(node);
            }
        }
        return dummy.next;
    }
}
