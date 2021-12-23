/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Double> res = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<List<Integer>> q = new LinkedList<>();
        List<TreeNode> L = new ArrayList<>();
        L.add(root);
        res.add(new Double(root.val));
        while (!L.isEmpty()) {
            L = getNextLevel(L);
            Double sum = 0.0;
            int count = 0;
            for (TreeNode n : L) {
                sum+=new Double(n.val);
                count++;
            }
            if (count != 0) res.add(sum / new Double(count));
        }
        return res;
    }
    
    private List<TreeNode> getNextLevel(List<TreeNode> currentLevel) {
        ArrayList<TreeNode> nextLevel = new ArrayList<>();
        for (TreeNode n : currentLevel) {
            if (n != null) {
                if (n.left != null) nextLevel.add(n.left);
                if (n.right != null) nextLevel.add(n.right);
            }
        }
        return nextLevel;
    }
}