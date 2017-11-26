/**
 * Name: Maximum Binary Tree
 * Number: 654
 * Tag: DFS
 * Main Points:
 * Time Complexity: WORST: T(n) = n + T(n - 1) -> O(n^2)
                    AVERA: T(n) = n + 2T(n/2) -> O(nlogn)
 * Space Complexity: 
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return constructHelper(nums, 0, nums.length - 1);
    }
    private TreeNode constructHelper(int[] nums, int start, int end) {
        if (start > end) return null;
        int maxIndex = findMax(nums, start, end);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = constructHelper(nums, start, maxIndex - 1);
        root.right = constructHelper(nums, maxIndex + 1, end);
        return root;
    }
    private int findMax(int[] nums, int start, int end) {
        int res = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > nums[res]) {
                res = i;
            }
        }
        return res;
    }
}