/**
 * Name: Construct Binary Tree from Preorder and Inorder Traversal
 * Number: 105
 * Tag: DFS
 * Main Point: construct the tree by root.left = x, root.right = y. 
   first we assume that all level of buildTreeHelper works well, 
   every level will return the root to the upper level. 
   so we can consider build left subtree, build right subtree, then link them together. 
   So how can we find all elements in left subtree? 
   we use the characteristic that preorder traversal is root, left,right; while inorder traversal is left, root, right.
   eg1: pre:[1,2,4,5,3,6,7] in:[4,2,5,1,6,3,7]
   the first element in pre is 1, it should be the root of the tree, so we try to find it in inorder.
   we find it in inorder array, then we can know that the left half in inorder array is left subtree, vice verse.
   then update range, recursively call buildMyTree to find the root of left subtree.
   
   eg2: pre:[1,2,4] in:[4,2,1]
   the tree has many null positions. in this case, we cannot search the range of right subtree, so return null as base case.
 * Time Complexity: O(n) n is the number od nodes
 * Space Complexity: O(n)
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) return null;
        return buildTreeHelper(preorder, 0, preorder.length - 1,
                               inorder, 0, inorder.length - 1);
    }
    private TreeNode buildTreeHelper(int[] preorder, int prestart, int preend,
                                     int[] inorder, int instart, int inend) {
        if (instart > inend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[prestart]);
        int curRootPos = findPosition(inorder, instart, inend, preorder[prestart]);
        root.left = buildTreeHelper(preorder, prestart + 1, prestart + curRootPos - instart,
                                    inorder, instart, curRootPos - 1);
        root.right = buildTreeHelper(preorder, prestart + curRootPos - instart + 1, preend,
                                     inorder, curRootPos + 1, inend);
        return root;
    }
    private int findPosition(int[] inorder, int start, int end, int key) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == key) {
                return i;
            }
        }
        return -1;
    }
}