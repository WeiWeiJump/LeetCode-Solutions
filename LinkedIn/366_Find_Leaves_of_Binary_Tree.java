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
 * Main Points: the main point is to recursively get each node's height
   List<List<Integer>> leafList
   if leafList's size is equal to current level, then add a new list to it
   leafList(i) should add all nodes with level i
 * Time Complexity: O(n)
 * Space Complexity: Average: O(logn) Worst: O(n)
**/
class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> leafList = new ArrayList<>();
        if (root == null) return leafList;
        getHeight(root, leafList);
        return leafList;
    }
    private int getHeight(TreeNode root, List<List<Integer>> leafList) {
        if (root == null) return -1;
        int leftHeight = getHeight(root.left, leafList);
        int rightHeight = getHeight(root.right, leafList);
        int height = Math.max(leftHeight, rightHeight) + 1;
        if (leafList.size() == height) {
            leafList.add(new ArrayList<>());
        }
        leafList.get(height).add(root.val);
        return height;
    }
}