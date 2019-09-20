///**
// * created by Zheng Jiateng on 2019/8/27.
// */
//package string;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * 438. 找到字符串中所有字母异位词
// */
//public class FindAnagrams {
//    public List<Integer> findAnagrams(String s, String p) {
//        int[] patternP = new int[26];
//        for(int i = 0; i < p.length(); i++) patternP[p.charAt(i) - 'a'] +=1;
//        StringBuffer sb = new StringBuffer(s.substring(0, p.length()));
//        int[] patternS = new int[26];
//        for (int i = 0; i < sb.length(); i++) patternS[sb.charAt(i) - 'a'] +=1;
//        for (int i = p.length(); i < s.length(); i++) {
//            patternS[sb.charAt(0) - 'a'] -=1;
//            sb.deleteCharAt(0);
//            sb.append(s.charAt(i));
//            patternS[s.charAt(i) - 'a'] +=1;
//        }
//    }
//}

// 13:56
// 13:57
