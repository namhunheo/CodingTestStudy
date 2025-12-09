import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        // (1) 입력 도구 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // (2) 첫 줄에서 N(숫자 개수), M(질문 개수) 읽기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 배열 크기
        int M = Integer.parseInt(st.nextToken()); // 구간 합을 구해야 하는 횟수

        // (3) 누적합(prefix sum)을 저장할 배열 생성
        //     prefix[1] = 첫 번째까지의 합
        //     prefix[0] = 0 (편의를 위한 값)
        int[] prefix = new int[N + 1]; //전부 자동으로 0으로 초기화.

        // (4) 둘째 줄에서 N개의 값을 읽으면서 누적합 채우기
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int x = Integer.parseInt(st.nextToken()); // 입력값
            prefix[i] = prefix[i - 1] + x;            // 이전까지의 합 + 현재 값
        }

        // (5) 이제 M개의 구간을 입력 받고, 각 구간 합을 계산해 출력하기
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end   = Integer.parseInt(st.nextToken());

            // 핵심 공식: i~j 합 = prefix[j] - prefix[i-1]
            int sum = prefix[end] - prefix[start - 1];

            // (6) 답 출력
            System.out.println(sum);
        }
    }
}