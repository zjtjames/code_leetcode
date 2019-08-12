import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class Main2 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] years = new int[n + 2];
//        for (int i = 1; i <= n; i++) {
//            years[i] = in.nextInt();
//        }
//        int[] amount = new int[n + 2];
//        for (int i = 1; i <= n; i++) {
//            if (years[i] <= years[i + 1] && years[i] <= years[i - 1]) continue;
//
//        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(2, 4);
        map.put(3, 6);
        map.put(1, 2);
        System.out.println(map.lastKey());
    }
}
