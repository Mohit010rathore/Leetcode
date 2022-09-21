/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return node;
        }
        
        Map<Node,Node> map = new HashMap<>();
        
        Queue<Node> q = new LinkedList<>();
        Node newNode = new Node();
        newNode.val = node.val;
        
        map.put(node,newNode);
        q.offer(node);
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                Node originalNode = q.poll();
                for(Node child : originalNode.neighbors){
                    if(!map.containsKey(child)){
                        Node newChild = new Node();
                        newChild.val = child.val;
                        
                        q.offer(child);
                        map.put(child,newChild);
                    }
                    //extract the newlistnode from originalNode value from map 1'-> 1, 2'->2 and so on..
                    Node newListNode = map.get(originalNode);
                    newListNode.neighbors.add(map.get(child));
                }
            }
        }
        return map.get(node);
    }
}