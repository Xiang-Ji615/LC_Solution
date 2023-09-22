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

    String nullC = "N", splitter = ",";
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }
    
    void dfs(TreeNode node, StringBuilder sb) {
        if(node == null) {
            sb.append(nullC + splitter);
            return;
        }
        sb.append(node.val + splitter);
        dfs(node.left, sb);
        dfs(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(data.split(splitter)));
        return buildTree(q);
    }
    
    TreeNode buildTree(Queue<String> q) {
        if(q.isEmpty()) 
            return null;
        String s = q.poll();
        if(s.equals(nullC))
            return null;
        TreeNode res = new TreeNode(Integer.valueOf(s));
        res.left = buildTree(q);
        res.right = buildTree(q);
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));