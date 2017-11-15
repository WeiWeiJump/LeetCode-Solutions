/**
 * Name: Two Sum IV - Input is a BST
 * Number: 653
 * Tag: HashSet + DFS / inorder + 2sum
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

/**
 * Main Points: dfs
   use a hashset to record the number we have traversed
 * Time Complexity: O(n)
 * Space Complexity: O(n)
**/
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        Set<Integer> set = new HashSet<>();
        return traverse(root, k, set);
    }
    private boolean traverse(TreeNode root, int k, Set<Integer> set) {
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return traverse(root.left, k, set) || traverse(root.right, k, set);
    }
}

/**
 * Main Points: inorder + 2sum
 * Time Complexity: O(n)
 * Space Complexity: O(n)
**/
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        
        //2sum in sorted int array nums
        for (int i = 0, j = nums.size() - 1; i < j; ) {
            if (nums.get(i) == k - nums.get(j)) return true;
            if (nums.get(i) < k - nums.get(j)) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
    private void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) return;     
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);       
    }
}