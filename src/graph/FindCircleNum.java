/**
 * created by Zheng Jiateng on 2019/7/29.
 */
package graph;

/**
 * 547. 朋友圈
 * 输入:
 * [[1,1,0],
 * [1,1,0],
 * [0,0,1]]
 * 输出: 2
 * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回2。
 *
 * 输入:
 * [[1,1,0],
 * [1,1,1],
 * [0,1,1]]
 * 输出: 1
 * 说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
 *
 * 思路：给的是一个图的邻接矩阵 本质上是求无向图联通分量的个数 用DFS
 * 图的DFS BFS 都要建一个visited数组
 * visited数组是一维的 表示每个顶点是否被访问过
 * 遍历每一个顶点
 */
public class FindCircleNum {
    private int[] visited;
    // 就是找无向图连通分量个数 题目所给的是一个邻接矩阵
    public int findCircleNum(int[][] M) {
        visited = new int[M.length];
        int count = 0;
        for(int i = 0; i < M.length; i++){
            if(visited[i] == 0){
                dfs(M, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] M, int i){
        for(int j = 0; j < M.length; j++){
            // 如果i,j相邻 且j还没有别访问过
            if(M[i][j] == 1 && visited[j] == 0){
                visited[j] = 1;
                dfs(M, j); // 从j出发继续往深的搜
            }
        }
    }
}
