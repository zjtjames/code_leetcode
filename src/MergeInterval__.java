import java.util.*;

/**
 * created by Zheng Jiateng on 2019/6/10.
 */

/**
 * 56. Merge Intervals
 * 先用每个interval的起始点对二维数组进行排序
 * 然后遍历 当新来的interval的起点大于merged中最后一个interval的终点时，二者不重叠，merged加入新interval
 * 否则 二者重叠 merged中最后一个interval的终点更新为二者终点之间较大者
 * cur游标是精髓
 */
public class MergeInterval__ {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 1) return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.valueOf(o1[0]).compareTo(Integer.valueOf(o2[0])); // 要转化成包装类型才能用compareTo函数
            }
        });
        int[][] merged = new int[intervals.length][intervals[0].length];
        int cur = 0; // 这个游标是精髓
        for (int[] interval : intervals) {
            if (cur == 0 || interval[0] > merged[cur - 1][1]) { // 注意上一个merged的游标是cur - 1
                merged[cur++] = interval;
            } else if (merged[cur - 1][1] < interval[1]){ // 注意上一个merged的游标是cur - 1
                merged[cur - 1][1] = interval[1]; // 注意上一个merged的游标是cur - 1
            }
        }
        return Arrays.copyOfRange(merged, 0, cur); // 注意 是 Arrays.copyOfRange()
    }
}
