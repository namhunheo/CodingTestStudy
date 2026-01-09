import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N + 2];   // T[i] = i일에 시작하는 상담 기간
        int[] P = new int[N + 2];   // P[i] = i일에 시작하는 상담 수익
        int[] dp = new int[N + 2];  // dp[i] = i일부터 퇴사일까지 얻을 수 있는 최대 수익

        // 1) 입력_1일~N일 상담 정보 저장
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        // 2) 뒤에서부터 계산 (N일 -> 1일)
        for (int i = N; i >= 1; i--) {

            // [선택 1] 오늘 상담 안 함: 내일의 최대 수익 그대로 가져옴
            dp[i] = dp[i + 1];

            // [선택 2] 오늘 상담 함: 상담이 끝나는 날(nextDay)로 점프 가능하면 계산
            int nextDay = i + T[i];
            if (nextDay <= N + 1) { // 퇴사일(N+1) 안에 끝나야 가능
                dp[i] = Math.max(dp[i], P[i] + dp[nextDay]);
            }
        }

        // 3) 1일부터 시작했을 때의 최대 수익 출력
        System.out.println(dp[1]);
    }
}