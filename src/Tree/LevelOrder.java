package Tree; /**
 * created by Zheng Jiateng on 2019/5/14.
 */

import base.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 102. Binary Tree Level Order Traversal  print every layer
 *
 * 靠cur这个游标和一个while循环实现打印每层
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> layers = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return layers;
        }
        queue.offer(root);
        while(!queue.isEmpty()){ // isEmpty 注意驼峰写法
            ArrayList<Integer> layer = new ArrayList<>();
            int cur = 0;
            int size = queue.size();
            while(cur < size){ // 靠cur这个游标和这个循环实现打印每层
                TreeNode node = queue.poll();
                layer.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                cur++; // 这个不要忘了
            }
            layers.add(layer);
        }
        return layers;
    }
}
