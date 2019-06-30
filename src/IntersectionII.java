/**
 * created by Zheng Jiateng on 2019/6/30.
 */

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 350. Intersection of Two Arrays II
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 *
 */
public class IntersectionII {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums1){
            if(!map.containsKey(num)) map.put(num, 1);
            else {
                map.put(num, map.get(num) + 1);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                result.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        int[] inter = new int[result.size()];
        for(int i = 0; i< result.size(); i++){
            inter[i] = result.get(i);
        }
        return inter;
    }
}
