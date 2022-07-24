package offer1;

import config.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @ClassName: LowestCommonAncestor
 * @Date: 2022/7/24 16:56
 * @Author: panLong
 * @Description: 剑指 Offer 68 - II. 二叉树的最近公共祖先
 */

public class LowestCommonAncestor2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        //根节点到p节点的路径
        List<TreeNode> path1 = new ArrayList<>();
        //根节点到q节点的路径
        List<TreeNode> path2 = new ArrayList<>();
        getPath(root, p, path1);
        getPath(root, q, path2);
        TreeNode result = null;
        int min = Math.min(path1.size(), path2.size());
        //保留最后一个相等节点即为公共节点
        for (int i = 0; i < min; i++) {
            if (path1.get(i) == path2.get(i)) {
                result = path1.get(i);
            }
        }
        return result;
    }

    private void getPath(TreeNode root, TreeNode node,
                         List<TreeNode> path) {
        if(root == null){
            return;
        }
        path.add(root);
        if(root == node){
            return;
        }
        if(path.get(path.size() - 1) != node){
            getPath(root.left,node,path);
        }
        if(path.get(path.size() - 1) != node){
            getPath(root.right, node, path);
        }
        if(path.get(path.size() - 1) != node){
            path.remove(path.size() - 1);
        }
    }
}
