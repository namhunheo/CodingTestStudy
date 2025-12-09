import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();    // (1) 재료의 개수 N 입력
        int M = sc.nextInt();    // (2) 목표 숫자 M 입력

        int[] arr = new int[N];    // (3) 재료 번호를 저장할 배열 생성

        for (int i = 0; i < N; i++) {    // (4) 배열에 값 저장
            arr[i] = sc.nextInt();
        }

        // (5) 배열 정렬 : 작은 수 → 큰 수 (twoPointer 사용 위해 필요)
        Arrays.sort(arr);

        // (6) twoPointer 변수 선언
        int left = 0;        // 배열의 맨 앞 (작은 값)
        int right = N - 1;   // 배열의 맨 뒤 (큰 값)
        int count = 0;       // M을 만들 수 있는 쌍의 개수

        // (7) 두 포인터가 겹치기 전까지 반복
        while (left < right) {

            // 왼쪽 값 + 오른쪽 값을 더하기
            int sum = arr[left] + arr[right];

            // (7-1) 합이 M과 같다면 갑옷 1개 생성 가능
            if (sum == M) {
                count++;
                // 두 재료를 사용했으므로 인덱스를 안쪽으로 이동
                left++;
                right--;
            }
            // (7-2) 합이 M보다 작으면 → 더 큰 값을 사용해야 함
            else if (sum < M) {
                left++;  // 왼쪽 포인터 이동
            }
            // (7-3) 합이 M보다 크면 → 더 작은 값을 사용해야 함
            else {
                right--; // 오른쪽 포인터 이동
            }
        }

        // (8) 결과 출력
        System.out.println(count);

        sc.close();
    }
}