import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] digits = sc.next().toCharArray();

        Arrays.sort(digits); // 오름차순

        // 오름차순 결과를 뒤에서부터 붙이면 내림차순
        StringBuilder sb = new StringBuilder();
        for (int i = digits.length - 1; i >= 0; i--) {
            sb.append(digits[i]);
        }
        System.out.println(sb.toString());
    }
}