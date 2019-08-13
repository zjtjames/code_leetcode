/**
 * created by Zheng Jiateng on 2019/8/13.
 */
package string;

/**
 * 1047. 删除字符串中的所有相邻重复项
 * 重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。
 * 之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *
 * 要点：StringBuilder的方法 charAt 和 deleteCharAt
 */
public class RemoveDuplicates {
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for(int i = 0; i < S.length(); i++){
            if(sbLength == 0 || S.charAt(i) != sb.charAt(sbLength - 1)){
                sb.append(S.charAt(i));
                sbLength++;
            } else{
                sb.deleteCharAt(sbLength - 1);
                sbLength--;
            }
        }
        return sb.toString();
    }
}
