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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null){
            return null;
        }

        return doBuild(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode doBuild(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd){
        //终止条件
        if(pStart > pEnd || iStart > iEnd){
            return null;
        }

        //处理
        TreeNode root = new TreeNode(preorder[pStart]);

        int index = 0;
        while(inorder[iStart + index] != preorder[pStart]){
            index++;
        }

        //递归
        root.left = doBuild(preorder, pStart+1, pStart+index, inorder, iStart, iStart+index);
        root.right = doBuild(preorder, pStart+index+1, pEnd, inorder, iStart+index+1, iEnd);

        return root;
    }
}