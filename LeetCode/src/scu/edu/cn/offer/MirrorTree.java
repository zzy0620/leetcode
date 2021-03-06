package scu.edu.cn.offer;

import java.util.Stack;

/**
 * @program: leetcode
 * @description: 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * @author: zzy
 * @create: 2021-03-26 20:48
 **/
public class MirrorTree {
    public static void main(String[] args) {

    }
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.left != null) stack.add(node.left);
            if(node.right != null) stack.add(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }
}
