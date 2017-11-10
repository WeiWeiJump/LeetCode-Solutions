/**
 * Name: Binary Tree Paths
 * Number: 257
 * Tag: DFS/Preorder Traversal
 * Main Points:
 * Time Complexity: O(n)
 * Space Complexity: a:O(logn) w:O(n)
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
    /*
    public List<String> binaryTreePaths(TreeNode root) {
        //StringBuilder path = new StringBuilder();
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        pathHelper(root, "", res);
        return res;
    }
    private void pathHelper(TreeNode root, String path, List<String> res) {
        
        if (root.left == null && root.right == null) {
            res.add(path + String.valueOf(root.val));
            return;
        }
        if (root.left != null) {
            pathHelper(root.left, path + String.valueOf(root.val) + "->", res);
        }
        if (root.right != null) {
            pathHelper(root.right, path + String.valueOf(root.val) + "->", res);
        }
    }*/
    
    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder path = new StringBuilder();
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        pathHelper(root, path, res);
        return res;
    }
    private void pathHelper(TreeNode root, StringBuilder path, List<String> res) {
        
        if (root.left == null && root.right == null) {
            res.add(path.toString() + String.valueOf(root.val));
            return;
        }
        String rootS = String.valueOf(root.val);
        if (root.left != null) {
            pathHelper(root.left, path.append(rootS).append("->"), res);
            path.setLength(path.length() - rootS.length() - 2);
        }
        if (root.right != null) {
            pathHelper(root.right, path.append(rootS).append("->"), res);
            path.setLength(path.length() - rootS.length() - 2);
        }
    }
    
}