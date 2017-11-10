/**
 * Name: Serialize and Deserialize Binary Tree
 * Number: 297
 * Tag: pre-order Traversal / Construct Tree
 * Main Points: 
 * Time Complexity:
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
    private void buildString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null").append(",");
        } else {
            sb.append(String.valueOf(root.val)).append(",");
            buildString(root.left, sb);
            buildString(root.right, sb);
        }    
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] tree = data.split(",");
        Queue<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(tree));
        return constructTree(nodes);
    }
    private TreeNode constructTree(Queue<String> nodes) {
        String cur = nodes.poll();
        if (cur.equals("null")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(cur));
        root.left = constructTree(nodes);
        root.right = constructTree(nodes);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));