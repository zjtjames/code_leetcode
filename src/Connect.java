/**
 * created by Zheng Jiateng on 2019/5/23.
 */

/**
 * 116. Populating Next Right Pointers in Each Node
 * 给完美二叉树加一个next指针，指向它同一高度右边的结点
 *
 * 思路：仿遍历的递归
 */
public class Connect {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        Node left = root.left;
        Node right = root.right;
        if(left == null){
            return root;
        }
        left.next = right;
        if(root.next != null){
            right.next = root.next.left;
        }
        connect(left);
        connect(right);
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
