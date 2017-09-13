/**
 * Name: Kth Smallest Element in a BST
 * Number: 230
 * Tag: Binary Search/BST
 * Main Point:
   Method1(Binary Search): count the nodes of left subtree, if it == k - 1, then current node is kth smallest.
   if it < k-1, then the kth smallest is in the right subtree,
   so try to find (k - nodes - 1)th smallsest node in the right subtree;
   if it > k-1, then the kth smallest is in the left subtree,
   so try to find kth smallsest node in the right subtree;
   
   Method2(Inorder Traversal): BST's inorder traversal is in ascending order.
   
 * Time Complexity: method1-Average-O(N), worst case O(N^2)(eg when the tree has only left subtree and the target is 1); 
                    method2-
 * Space Complexity: method1-O(N); method2-
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
    /*********************** Inorder Traversal*************************/
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        while ((!stack.isEmpty() || root != null)) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if (k == 0) return root.val;
            root = root.right;
        }
        return Integer.MIN_VALUE;
    } 
    /*********************** Binary Search ****************************
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        int leftNodes = countNodes(root.left);
             //current node is kth smallest
        if (leftNodes == k - 1) {
            return root.val;
            //the kth smallest is in the right subtree
        } else if (leftNodes < k - 1) {
            return kthSmallest(root.right, k - leftNodes - 1);
            //kthSmallest must be in the left_subtree
        } else {
            return kthSmallest(root.left, k);
        }
    }
    private int countNodes(TreeNode root) {
        return root == null ? 0 : 1 + countNodes(root.left) + countNodes(root.right);
    }
    **/
}