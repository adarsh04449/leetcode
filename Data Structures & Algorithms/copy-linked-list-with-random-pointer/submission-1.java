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
        HashMap<Node, Node> copy = new HashMap<>();
        Node temp = head;
        while(temp != null){
            copy.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        temp = head;
        while(temp != null){
            copy.get(temp).next = copy.get(temp.next);
            copy.get(temp).random = copy.get(temp.random);
            temp = temp.next;
        }

        return copy.get(head);
    }
}
