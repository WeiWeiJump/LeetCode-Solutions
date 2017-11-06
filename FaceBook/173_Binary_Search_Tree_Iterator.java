/**
 * Name: Binary Search Tree Iterator
 * Number: 173
 * Tag: Stack
 * Main Points: average O(1) and space O(h) can give some hints
   use a stack to do backtrace
 * Time Complexity: average O(1)
 * Space Complexity: O(h) h = tree's height
**/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        fillStack(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = stack.pop();
        fillStack(cur.right);
        return cur.val;
    }
    private void fillStack(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }     
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */