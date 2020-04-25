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

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        List<List<Integer>> results = new ArrayList();
        while(!queue.isEmpty()){
            List<Integer> values = new ArrayList();

            int size = queue.size();
            for(int i=0; i<size; i++){
                Node node = queue.poll();
                values.add(node.val);

                if(node.children != null && node.children.size() > 0){
                    queue.addAll(node.children);
                }
            }

            results.add(values);            
        }

        return results;
    }

}