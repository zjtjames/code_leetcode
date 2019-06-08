/**
 * created by Zheng Jiateng on 2019/6/8.
 */

/**
 * 55. Jump Game
 * Example 1:
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 * jump length is 0, which makes it impossible to reach the last index.
 *
 * 思路：贪心法 从右往左推进 找能到终点的最左边的index 如果能推到最左边 就返回true 时间复杂度o(n) 空间o(1)
 * 如果用dp的话时间复杂度是o(n2) 空间复杂度是o(n)
 */
public class CanJump__ {
    public boolean canJump(int[] nums) {
        int leftMost = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--){
            if(i + nums[i] >= leftMost) leftMost = i;
        }
        return leftMost == 0;
    }
}
