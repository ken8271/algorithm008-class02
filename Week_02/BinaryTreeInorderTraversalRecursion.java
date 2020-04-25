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

        List<Integer> results = new ArrayList();

       doTraveal(results, root);

       return results;
    }

    private void doTraveal(List<Integer> results, TreeNode node){
        if(node == null){
            return ;
        }

        if(node.left != null){
            doTraveal(results, node.left);
        }
        
        results.add(node.val);

        if(node.right != null){
            doTraveal(results, node.right);
        }
    }
}