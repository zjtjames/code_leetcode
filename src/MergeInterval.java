import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * created by Zheng Jiateng on 2019/6/10.
 */

public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.valueOf(o1[0]).compareTo(Integer.valueOf(o2[0]));
            }
        });
        int[][] merged = new int[intervals.length][intervals[0].length];
        int cur = 0;
        for (int[] interval : intervals) {
            if (cur == 0 || interval[0] > merged[cur - 1][1]) {
                merged[cur++] = interval;
            } else {

            }
        }

    }
}
