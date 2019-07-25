package graph; /**
 * Created by Zheng Jiateng on 2019/6/12.
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 210. Course Schedule II
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); //邻接表
        for (int i = 0; i < numCourses; i++){ // 初始化邻接表
            graph.add(new ArrayList<>());
        }
        // 统计入度
        int[] degree = new int[numCourses];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();

        // 遍历所有边 插入到邻接表中
        for(int i = 0; i < prerequisites.length; i++){
            int pre = prerequisites[i][1];
            int post = prerequisites[i][0];
            degree[post]++;
            graph.get(pre).add(post);
        }

        for(int i = 0; i < numCourses; i++){
            if(degree[i] == 0){
                queue.offer(i);
            }
        }
        int[] result = new int[numCourses];
        while(!queue.isEmpty()){
            int course = queue.poll();
            result[count++] = course;
            for(int next : graph.get(course)){
                if(--degree[next] == 0){
                    queue.offer(next);
                }
            }
        }
        return count == numCourses ? result : Arrays.copyOfRange(result,0,0);
    }
}
