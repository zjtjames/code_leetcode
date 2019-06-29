/**
 * created by Zheng Jiateng on 2019/6/26.
 */

import base.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 297. Serialize and Deserialize Binary Tree 序列化和反序列化二叉树
 *    1
 *   / \
 *  2   3
 *     / \
 *    4  5
 *  1,2,null,null,3,4,null,null,5,null,null
 * 思想：题目要求的方法参数不能变的话，就在原方法中调用新的自建方法，自建方法参数就可以自定义了
 *
 */
public class SerializeBT__ {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        preOrder(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.split(",");
        Deque<String> deque = new LinkedList<>();
        // 先进先出 是一个队列 用队列来实现不用全局变量
        for (String string : strings) {
            deque.offer(string);
        }
        return reConstruct(deque);
    }

    private void preOrder(TreeNode root, StringBuffer sb){
        if(root == null) sb.append("null,");
        else {
            sb.append(root.val).append(",");
            preOrder(root.left, sb);
            preOrder(root.right, sb);
        }
    }

    // 这个用递归是精髓
    private TreeNode reConstruct(Deque<String> deque) {
        if (!deque.isEmpty() && !deque.peek().equals("null")) { // String比较要用equals
            TreeNode node = new TreeNode(Integer.valueOf(deque.poll()));
            node.left = reConstruct(deque);
            node.right = reConstruct(deque);
            return node;
        } else {
            deque.poll(); // 把"null"跳过
            return null;
        }
    }
}
