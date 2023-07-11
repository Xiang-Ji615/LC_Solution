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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        Map<TreeNode, Set<TreeNode>> map = new HashMap<>();
        buildGraph(root, null, map);
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        q.offer(target);
        visited.add(target);
        while(!q.isEmpty()) {
            int size = q.size();
             if (k == 0) {
                for (int i = 0; i < size ; i++){
                    res.add(q.poll().val);
                }
                return res;
            };
            for(int i=0;i<size;i++) {
                TreeNode cur = q.poll();
                for(TreeNode nei : map.getOrDefault(cur, new HashSet<>())){ 
                    if(visited.add(nei)) {
                        q.offer(nei);
                    }
                }
            }
            k--;
        }
        return res;
    }
    
    void buildGraph(TreeNode node, TreeNode parent, Map<TreeNode, Set<TreeNode>> map) {
        if(node == null)
            return;
        if(!map.containsKey(node.val)) {
            map.putIfAbsent(node, new HashSet<>());
            if(parent != null) {
                map.get(parent).add(node);
                map.get(node).add(parent);
            }
        }
        buildGraph(node.left, node, map);
        buildGraph(node.right, node, map);
    }
}