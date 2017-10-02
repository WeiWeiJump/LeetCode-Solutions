/*
 * Name: Binary Tree Paths
 * Number: 257
 * Tag: DFS
 * Main Points: DFS to the leaf nodes, pay attention to backtracking point
 * Time Complexity: O(n)
 * Space Complexity: O(logn)
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**************************My method***************************/
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        List<ArrayList<Integer>> res = new ArrayList<>();
        pathHelper(root, path, res);
        //turn result to string
        List<String> slist = new ArrayList<>();
        for (List<Integer> ret : res) {
            StringBuilder sb = new StringBuilder();
            String prefix = "";
            for(int node : ret) {
                sb.append(prefix);
                prefix = "->";
                sb.append(Integer.toString(node));         
            }
            slist.add(sb.toString());
        }
        return slist;
    }
    private void pathHelper(TreeNode root, List path, List res) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            res.add(new ArrayList<Integer>(path));
            path.remove(path.size() - 1);
            return;
        }
        pathHelper(root.left, path, res);
        pathHelper(root.right, path, res);
        path.remove(path.size() - 1);
    }
}
/*****************************Top1 Solution***************************/
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root != null) {
            searchBST(root, "", res);
        }
        return res;
    }
    private void searchBST(TreeNode root, String path, List res) {
        if (root.left == null && root.right == null) {
            res.add(path + root.val);
            return;
        }
        if (root.left != null) {
            searchBST(root.left, path + root.val + "->", res);
        }
        if (root.right != null) {
            searchBST(root.right, path + root.val + "->", res);
        }
    }
}