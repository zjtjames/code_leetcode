/**
 * created by Zheng Jiateng on 2019/7/10.
 */

/**
 * 134. Gas Station
 * 不能绕一圈返回-1 能绕一圈返回起始索引 题目保证仅有一个解或无解
 * Input:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 * Output: 3
 *
 * Explanation:
 * Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
 * Travel to station 4. Your tank = 4 - 1 + 5 = 8
 * Travel to station 0. Your tank = 8 - 2 + 1 = 7
 * Travel to station 1. Your tank = 7 - 3 + 2 = 6
 * Travel to station 2. Your tank = 6 - 4 + 3 = 5
 * Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
 * Therefore, return 3 as the starting index.
 *
 * 思路：1.gas共和若小于cost总和则无解，否则有唯一解
 * 2.A C B 假设从A能走到C走不到B 则从C也走不到B 所以直接跳过C作为起点 直接从B开始重新走
 * 3.gas总和大于等于cost总和 题目保证有解 所以走一遍就行了 相当于排除法
 */
public class GasStation__ {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        int costSum = 0;
        int tank = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {
                tank = 0;
                start = i + 1;
            }
        }
        if (gasSum < costSum) return -1;
        return start;
    }
}
