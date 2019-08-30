package array;

/**
 * Created by Zheng Jiateng on 2019/8/30.
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 406. 根据身高重建队列
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。
 * 编写一个算法来重建这个队列。
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 * 解题思路：先排序再插入
 * 1.排序规则：按照先H高度降序，K个数升序排序
 * 2.遍历排序后的数组，根据K插入到K的位置上
 * 核心思想：高个子先站好位，矮个子插入到K位置上，前面肯定有K个高个子，更矮个子再插到前面也满足K的要求
 * 记住List可以插入元素到指定index
 * 记住lamda表达式写法
 */
public class ReconstructQueue__ {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]); // 身高降序 若身高相同人数升序
        List<int[]> result = new LinkedList<>();
        for(int[] person : people){
            result.add(person[1], person);
        }
        return result.toArray(new int[people.length][2]);
    }
}
