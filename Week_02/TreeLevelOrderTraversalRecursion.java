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
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null){
            return new ArrayList();
        }

        List<List<Integer>> results = new ArrayList();

        doLevelTraversal(results, root, 0);

        return results;
    }

    private void doLevelTraversal(List<List<Integer>> results, Node node, int level){
        if(results.size() <= level){
            results.add(new ArrayList());
        }

        results.get(level).add(node.val);

        if(node.children != null && node.children.size() > 0){
            for(Node sub : node.children){
               doLevelTraversal(results, sub, level+1);
            }  
        }
    }

}