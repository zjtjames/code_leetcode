/**
 * Created by Zheng Jiateng on 2019/5/15.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/**
 * 380. Insert Delete GetRandom O(1)
 *
 * 用List存数字，用map存位置
 * 注意：list.set(0,2)是替换指定位置上的元素，list长度不变
 * 而list.add(0,2)是在指定位置上插入元素，list长度加1
 */
public class RandomizedSet {
    private ArrayList<Integer> vals;
    private HashMap<Integer, Integer> locs;
    private Random rand = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        vals = new ArrayList<>();
        locs = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = locs.containsKey(val);
        if(contain == false){
            vals.add(val);
            locs.put(val, vals.size() - 1);
            return true;
        }
        return false;

    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean contain = locs.containsKey(val);
        if(contain == false){
            return false;
        }
        int loc = locs.get(val);
        // 不是list中最后一个元素,则交换val与最后一个元素的位置，更新map
        if(loc != vals.size() - 1){
            int lastVal = vals.get(vals.size() - 1);
            vals.set(loc, lastVal);
            vals.set(vals.size() - 1, val);
            locs.put(lastVal, loc);
        }
        vals.remove(vals.size() - 1);
        locs.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return vals.get(rand.nextInt(vals.size()));
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(22);
        list.add(33);
//        list.add(0, 44);
        list.set(0 ,44);
        System.out.println(list.size());
    }
}
