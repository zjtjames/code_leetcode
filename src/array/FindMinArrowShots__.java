/**
 * created by Zheng Jiateng on 2019/8/23.
 */
package array;

import java.util.Arrays;

/**
 * 452. 用最少数量的箭引爆气球
 * 一支弓箭可以沿着x轴从不同点完全垂直地射出。在坐标x处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend，
 * 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。
 * 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 *
 * 思路：按xEnd对数组进行排序，记录lastEnd，当xStart<=lastEnd时，可以一起引爆，否则，count++，且lastEnd变为xEnd
 */
public class FindMinArrowShots__ {
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0) return 0;
        Arrays.sort(points, (a, b) -> a[1] - b[1]); // lamda表达式代替Comparator
        int count = 1;
        int lastEnd = points[0][1];
        for(int i = 1; i < points.length; i++){
            if(points[i][0] <= lastEnd) continue;
            else{
                count++;
                lastEnd = points[i][1];
            }
        }
        return count;
    }
}
