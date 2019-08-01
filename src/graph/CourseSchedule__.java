package graph; /**
 * Created by Zheng Jiateng on 2019/6/11.
 */

import java.util.*;

/**
 * 207. Course Schedule
 * 思路：有向图判断是否有环：拓扑排序法
 * 拓扑排序算法：选择一个入度为0的顶点并输出之；从网中删除此顶点及所有出边。
 * 循环结束后，若输出的顶点数小于网中的顶点数，则输出“有回路”信息，否则输出的顶点序列就是一种拓扑序列。
 * 为了避免重复检测入度为0的顶点，可另设一个队列暂存所有入度为0的顶点
 */
public class CourseSchedule__ {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 先根据边列表建图 邻接表 邻接矩阵均可
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); //邻接表
        int[] degree = new int[numCourses]; // 统计入度
        Queue<Integer> queue = new LinkedList<>(); // 保存所有入度为0(无前驱)的顶点 用于删除该顶点和所有出边
        int count = 0;
        for (int i = 0; i < numCourses; i++) { // 初始化邻接表
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) { // 邻接表
            int pre = prerequisites[i][1];
            int post = prerequisites[i][0];
            degree[post]++;
            graph.get(pre).add(post);
        }

        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }

        // 拓扑排序算法：选择一个入度为0的顶点并输出之；从网中删除此顶点及所有出边。
        // 删除此顶点就是把它出队 删除此顶点的出边就是在入度数组中给相应顶点-1
        // 循环结束后，若输出的顶点数小于网中的顶点数，则输出“有回路”信息，否则输出的顶点序列就是一种拓扑序列。
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int next : graph.get(course)) {
                if (--degree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return count == numCourses;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[][] b = {{1, 2, 3}, {4, 5, 6}};
        for (int[] array : b) {
            for (int num : array) {
                System.out.print(num);
            }
            System.out.println();

        }
    }
}
