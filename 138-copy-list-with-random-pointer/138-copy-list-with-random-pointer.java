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
        Node iter = head, front = head;
        
        // Step 1: Insert copy nodes right after original nodes
        while(iter != null){
            front = iter.next; 
            Node copy = new Node(iter.val);
            iter.next = copy;
            copy.next = front;
            iter = front;
        }
        
        // Step 2: Point the random pointers
        iter = head;
        while(iter != null){
            if(iter.random != null)
                iter.next.random = iter.random.next;
            iter = iter.next.next;
        }
        
        // Step 3: Get the original and deep copy linked list
        iter = head;
        Node copyHead = new Node(0);
        Node copy = copyHead;
        
        while(iter != null){
            front = iter.next.next;
            copy.next = iter.next;
            iter.next = front;
            copy = copy.next;
            iter = iter.next;
        }
        
        return copyHead.next;
        
    }
}