package list; /**
 * created by Zheng Jiateng on 2019/5/13.
 */

/**
 * 长度为n+1的数组，里面有1~n的正整数，找重复的数字 287. Find the Duplicate Number
 *
 * 观察发现，链表有圈时，圈的起点的特点是：有两个结点的next指向同一个结点，那个结点就是圈的起点。
 * 在287题中，我们把数组的元素的value视为链表中的next，即下一个结点的index。
 * 则我们发现，重复的数字，有两个index的value都是它，即两个结点的next都是它，所以重复的数字就等价于链表的环的起点。
 * 转换为弗洛伊德判圈法
 */
public class FindDuplicate__ {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int quick = 0;
        while(true){ // 这里一定不能写成while(slow != quick) 因为初值都是0 一开始循环就进不去
            slow = nums[slow];
            quick = nums[quick];
            quick = nums[quick];
            if(quick == slow){
                break;
            }
        }
        quick = 0;
        while(quick != slow){
            quick = nums[quick];
            slow = nums[slow];
        }
        return quick;
    }
}
