package cn.hereyou.tree;

/**
 *
 *
 * [543]. 二叉树的直径
 *
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 *
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 *
 * 两节点之间路径的 长度 由它们之间边数表示。
 */
public class DiameterOfBinaryTree {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return result;
    }
    //最大深度
    int result = 0;

    // 这里的返回值是root的深度
    int dfs(TreeNode root){
        if(root == null){
            return 0; // 深度为0
        }

        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);

        // 看看是否有最大深度,leftDepth+rightDepth等于说是左右深度最大值之和，即最大距离
        result = Math.max(result, leftDepth+rightDepth);
        // 返回的是深度
        return Math.max(leftDepth, rightDepth) + 1;
    }


}
