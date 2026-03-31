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
        if (lists.length == 0) return null;
        
        ListNode dummyHead = new ListNode();
        ListNode current = dummyHead;
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode list: lists) {
            heap.add(list);
        }
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            current.next = node;
            node = node.next;
            current = current.next;
            if (node != null) heap.add(node);
        }
        return dummyHead.next;
    }
}
