/**
 * created by Zheng Jiateng on 2019/5/28.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle 杨辉三角
 *
 * 思路：dp ：construct each row based on the previous row.
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows < 1){
            return result;
        }
        result.add(new ArrayList<Integer>());
        result.get(0).add(1);
        for(int i = 1; i < numRows; i++){
            List<Integer> currentRow = new ArrayList<>();
            List<Integer> previousRow = result.get(i - 1);
            currentRow.add(1);
            for(int j = 1; j <= i - 1; j ++){
                currentRow.add(previousRow.get(j - 1) + previousRow.get(j));
            }
            currentRow.add(1);
            result.add(new ArrayList<>(currentRow));
        }
        return result;
    }
}
