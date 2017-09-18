/**
 * Name: Construct Binary Tree from Inorder and Postorder Traversal
 * Number: 106
 * Tag: DFS
 * Main Point: basically the same as 105, just traverse postorder is a liitle bit different.
**/
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) return null;
        return buildTreeHelper(inorder, 0, inorder.length - 1,
                               postorder, 0, postorder.length - 1);
    }
    private TreeNode buildTreeHelper(int[] inorder, int instart, int inend,
                                     int[] postorder, int poststart, int postend) {
        if (instart > inend) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postend]);
        int curRootPos =  findPosition(inorder, instart, inend, postorder[postend]);
        if (curRootPos == -1) return null;
        root.right = buildTreeHelper(inorder, curRootPos + 1, inend,
                                     postorder, postend - (inend - curRootPos), postend - 1);
        root.left = buildTreeHelper(inorder, instart, curRootPos - 1,
                                    postorder, poststart, postend - (inend - curRootPos) - 1);
        return root;
    }
    private int findPosition(int[] inorder, int instart, int inend, int key) {
        for (int i = instart; i <= inend; i++) {
            if (inorder[i] == key) {
                return i;
            }
        }
        return -1;
    }
}