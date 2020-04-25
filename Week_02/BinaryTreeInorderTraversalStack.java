/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList();
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        List<Integer> results = new ArrayList();
        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();

            results.add(curr.val);

            curr = curr.right;
        }
        
        return results;
    }

}