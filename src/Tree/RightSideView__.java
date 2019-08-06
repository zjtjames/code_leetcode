/**
 * created by Zheng Jiateng on 2019/8/2.
 */
package Tree;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 199. 二叉树的右视图
 * 不借助辅助空间的做法
 * 头条折戟
 *
 */
public class RightSideView__ {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result, 0);
        return result;
    }

    public void traversal(TreeNode curr, List<Integer> result, int currDepth){
        if(curr != null){
            if(currDepth == result.size()) result.add(curr.val);
            traversal(curr.right, result, currDepth + 1);
            traversal(curr.left, result, currDepth + 1);
        }
    }
}
