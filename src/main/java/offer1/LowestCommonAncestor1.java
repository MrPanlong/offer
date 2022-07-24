package offer1;


import config.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: lowestCommonAncestor1
 * @Date: 2022/7/24 17:10
 * @Author: panLong
 * @Description: 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 */

public class LowestCommonAncestor1 {
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return null;
        }
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor1(root.left, p, q);
        }
        if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor1(root.right, p, q);
        }
        return root;
    }
    public TreeNode lowestCommonAncestor2(TreeNode root,TreeNode p,TreeNode q){
        List<TreeNode> path1 = getPath(root,p);
        List<TreeNode> path2 = getPath(root,q);
        TreeNode ancestor = null;
        for (int i = 0; i < path1.size() && i < path2.size(); i++) {
            if(path1.get(i) == path2.get(i)){
                ancestor = path1.get(i);
            }else {
                break;
            }
        }
        return ancestor;
    }

    private List<TreeNode> getPath(TreeNode root, TreeNode target) {
        List<TreeNode> path = new ArrayList<>();
        TreeNode node = root;
        while (node != target){
            path.add(node);
            if(target.val < node.val){
                node = node.left;
            }else {
                node = node.right;
            }
        }
        path.add(node);
        return path;
    }
}
