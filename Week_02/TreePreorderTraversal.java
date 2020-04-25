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
    public List<Integer> preorder(Node root) {
        List<Integer> results = new ArrayList();

        doPreorder(results, root);

        return results;
    }

    private void doPreorder(List<Integer> results, Node root){
        if(root == null){
            return ;
        }

        results.add(root.val);

        if(root.children != null && root.children.size() > 0){
            for(Node node : root.children){
                doPreorder(results, node);
            }
        }
    }
}