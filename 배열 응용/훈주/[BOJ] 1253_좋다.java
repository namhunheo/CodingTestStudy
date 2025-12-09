import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();    // (1) N 입력

        int[] arr = new int[N];  // (2) 배열 생성

        // (3) 배열 입력
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);    // (4) 배열 정렬

        int goodCount = 0;   // 좋은 수 개수

        // (5) 각 i번째 수가 좋은수인지 검사
        for (int i = 0; i < N; i++) {

            int target = arr[i];  // 좋은 수인지 검사할 값
            int start = 0;        // 왼쪽 포인터
            int end = N - 1;      // 오른쪽 포인터
            boolean isGood = false;

            // (6) twoPointer 탐색
            while (start < end) {

                // 타깃 인덱스를 포인터가 가리키면 건너뛰기
                if (start == i) {
                    start++;
                    continue;
                }
                if (end == i) {
                    end--;
                    continue;
                }

                int sum = arr[start] + arr[end];

                if (sum == target) {
                    // start와 end 둘 다 i가 아니므로 좋은 수
                    isGood = true;
                    break;
                } 
                else if (sum < target) {
                    start++; // 합이 작으니 더 큰 수를 사용
                } 
                else { // sum > target
                    end--; // 합이 크니 더 작은 수를 사용
                }
            }

            if (isGood) {
                goodCount++;
            }
        }

        // (7) 결과 출력
        System.out.println(goodCount);
    }
}