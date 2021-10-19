/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> output = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        
        if (root == null) {
            return output;
        }
        
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            output.addFirst(node.val);
            for (Node child : node.children) {
                if (child != null) {
                    stack.push(child);
                }
            }
        }
        
        return output;
    }
}