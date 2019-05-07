/**
 * created by Zheng Jiateng on 2019/5/7.
 */

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树中序遍历的循环写法 94. Binary Tree Inorder Traversal
 * 核心是使用栈
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                // 在此处add是前序遍历
//                result.add(cur.val);
                cur = cur.left;
            }
            cur = stack.pop();
            // 在此处add是中序遍历
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }
}
