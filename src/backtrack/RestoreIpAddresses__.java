/**
 * created by Zheng Jiateng on 2019/7/28.
 */
package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 93.复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 示例:
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 * 思路：如果剩余字符串太长 就不可能有正确答案 直接停止 这个条件是精髓
 */
public class RestoreIpAddresses__ {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if(s == null || s.length() < 4) return result;
        restoreCore(s, result, "", 0, 0);
        return result;
    }

    // for循环是核心
    private void restoreCore(String s, List<String> result, String oneAnswer, int index, int count){
        // 如果剩余字符串太长 就不可能有正确答案 直接停止 这个条件是精髓
        if(s.length() - index > 3 * (4 - count)) return;
        if(count == 4 && index == s.length()) {
            result.add(oneAnswer);
            return;
        }

        for(int i = 1; i <= 3; i++){
            if(index + i > s.length()) return; //防止越界
            String part = s.substring(index, index + i);
            // part.length() > 1 && part.startsWith("0")中前半个条件不能省略 因为单0可以 但是01不行
            if(part.length() > 1 && part.startsWith("0") || i == 3 && Integer.valueOf(part) > 255) continue;
            restoreCore(s, result, count == 0 ? part : oneAnswer + "." + part, index + i, count + 1);
        }
    }
}
