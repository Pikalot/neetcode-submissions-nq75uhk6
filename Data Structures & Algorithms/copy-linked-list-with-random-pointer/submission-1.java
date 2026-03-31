/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        
        Node clone = new Node(0);
        Node iter = head;
        Node curr = clone;
        Map<Node, Node> map = new HashMap<>();
        
        while (head != null) {
            curr.val = head.val;
            map.put(head, curr);
            if (head.next != null) curr.next = new Node(0);
            curr = curr.next;
            head = head.next;
        }

        curr = clone;
        while (iter != null) {
            curr.random = map.get(iter.random);
            iter = iter.next;
            curr = curr.next;
        }
        return clone;
    }
}
