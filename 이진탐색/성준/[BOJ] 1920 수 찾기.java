package studycodingtest.BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    배열 넣어주고 tartget 으로 위치
    A 배열을 정렬
    Arrays.sort(arr);
    이진 탐색 수행

 */

public class BOJ_FindNumber {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // N 입력 (배열 크기)
        int N = Integer.parseInt(br.readLine());
        // 크기가 N인 정수 배열 생성
        int[] arr = new int[N];

        // A 배열 입력 (한 줄에 N개 숫자)
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 토큰을 하나씩 배열에 저장하고
        }

        // 정렬
        Arrays.sort(arr);

        // M 입력
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        // M개의 수에 대해 이진 탐색
        for (int i = 0; i < M; i++) {
            // 찾을 값
            int target = Integer.parseInt(st.nextToken());

            int left = 0; // 시작
            int right = N - 1; // 끝
            // target 발견 여부
            boolean found = false;

            // 이진 탐색 반복
            while (left <= right) {
                // 중간 인덱스 계산
                int mid = (left + right) / 2;

                // 중간 값이 target보다 작으면 오른쪽 탐색
                if (arr[mid] == target) {
                    found = true;
                    break;
                } else if (arr[mid] < target) {  // 오
                    left = mid + 1;
                } else {  // 왼
                    right = mid - 1;
                }
            }
            
            // 탐색 결과를 StringBuilder 에 저장
            if (found) sb.append(1).append('\n');
            else sb.append(0).append('\n');
        }

        // 출력
        System.out.print(sb);
    }
}
