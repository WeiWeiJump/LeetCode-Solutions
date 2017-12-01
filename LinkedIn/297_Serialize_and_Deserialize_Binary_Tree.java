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
            sb.append("X").append(",");
            return;
        }
        sb.append(root.val).append(",");
        buildString(root.left, sb);
        buildString(root.right, sb);
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return buildTree(queue);
    }
    private TreeNode buildTree(Queue<String> queue) {
        String cur = queue.poll();
        if (cur.equals("X")) return null;
        TreeNode node = new TreeNode(Integer.valueOf(cur));
        node.left = buildTree(queue);
        node.right = buildTree(queue);
        return node;
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));