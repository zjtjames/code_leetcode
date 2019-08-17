import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // n位数
        int m = in.nextInt(); // m进制
        int[] num1 = new int[n];
        int[] num2 = new int[n];
        for (int i = 0; i < n; i++) {
            num1[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            num2[i] = in.nextInt();
        }

    }
}
