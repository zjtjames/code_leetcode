package Tree; /**
 * created by Zheng Jiateng on 2019/5/14.
 */

import base.TreeNode;
import java.util.*;

/**
 * 之字形打印二叉树 103. Binary Tree Zigzag Level Order Traversal
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> layers = new ArrayList<>();
        if(root == null){
            return layers;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int reverse = 1;
        while(!queue.isEmpty()){
            List<Integer> layer = new ArrayList<>();
            int cur = 0;
            int size = queue.size();
            if (reverse == 1) {
                Iterator<TreeNode> it = queue.iterator();
                while (it.hasNext()) {
                    layer.add(it.next().val);
                }
            } else {
                Iterator<TreeNode> it = queue.descendingIterator(); // 记住Iterator的用法
                while (it.hasNext()) {
                    layer.add(it.next().val);
                }
            }
            layers.add(layer);
            reverse = -1 * reverse;

            while(cur < size){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                cur++;
            }
        }
        return layers;
    }
}
