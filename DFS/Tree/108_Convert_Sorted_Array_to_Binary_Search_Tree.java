/**
 * Name：Convert Sorted Array to Binary Search Tree
 * Number: 108
 * Tag: DFS
 * Main Points:
 Assume that every level works well in DFS function, and return s the current root of this level successfully.
 everytime we fetch the middle number to be the current root, then we just use left half to build left subtree
 use right half to build right subtree.
 * Time Complexity: O(n)
 * Space Complexity: O(n^2) // 每个点都要开一层stack，每个stack里至少要存nums数组->n*n
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) return null;
        return DFSHelper(nums, 0, nums.length - 1);
    }
    private TreeNode DFSHelper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode curRoot = new TreeNode(nums[mid]);
        curRoot.left = DFSHelper(nums, start, mid - 1);
        curRoot.right = DFSHelper(nums, mid + 1, end);
        return curRoot;
    }
}