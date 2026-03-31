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
        if (head == null) return null;
        
        Node clone = new Node(0);
        Node current = clone, source = head;
        Map<Node, Node> nodeMap = new HashMap<>();

        while (source != null) {
            current.val = source.val;
            nodeMap.put(source, current);

            if (source.next == null) break;
            current.next = new Node(0);
            source = source.next;
            current = current.next;
        }

        current = clone;
        source = head;
        while (current != null) {
            current.random = nodeMap.get(source.random);
            current = current.next;
            source = source.next;
        }

        return clone;
    }
}
