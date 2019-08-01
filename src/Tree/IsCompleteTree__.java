package Tree; /**
 * created by Zheng Jiateng on 2019/7/25.
 */

import base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 958. 检验一个树是否是完全二叉树
 *
 * 思路：与层序遍历不同 这里把null也加入队列 当第一个null出队时 后面只能全是null 否则就false
 */
public class IsCompleteTree__ {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.offer(root);
        while (bfs.peek() != null) {
            TreeNode node = bfs.poll();
            bfs.offer(node.left);
            bfs.offer(node.right);
        }
        while (!bfs.isEmpty() && bfs.peek() == null)
            bfs.poll();
        return bfs.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(2 ^ 3);
    }
}
