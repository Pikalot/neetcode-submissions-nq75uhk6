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
        Node current = head, newNode = clone;
        Map<Node, Node> nodeMap = new HashMap<>();
        
        while (current != null) {
            newNode.val = current.val;
            nodeMap.put(current, newNode);
            if (current.next == null) break;
            
            newNode.next = new Node(0);
            current = current.next;
            newNode = newNode.next;
        }

        current = head;
        newNode = clone;
        while (current != null) {
            newNode.random = nodeMap.get(current.random);
            newNode = newNode.next;
            current = current.next;
        }
        
        return clone;
    }
}
