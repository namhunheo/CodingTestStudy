import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // (1) N과 M 입력받기
        int N = sc.nextInt(); // 표 크기
        int M = sc.nextInt(); // 합을 구해야 하는 횟수

        // (2) 원본 배열 생성 (1번 칸부터 사용하기 위해 N+1)
        int[][] arr = new int[N + 1][N + 1];

        // (3) 배열 입력받기
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // (4) 2차원 누적합 배열 생성
        int[][] prefix = new int[N + 1][N + 1];

        // (5) 누적합 채우기
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {

                // prefix[i][j] = 위 + 왼 + 현재 - 겹치는 부분
                prefix[i][j] = prefix[i - 1][j]
                             + prefix[i][j - 1]
                             - prefix[i - 1][j - 1]
                             + arr[i][j];
            }
        }

        // (6) M번의 질문 처리
        for (int k = 0; k < M; k++) {

            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            // (7) 구간 합 계산 (공식 그대로)
            int total = prefix[x2][y2]
                      - prefix[x1 - 1][y2]
                      - prefix[x2][y1 - 1]
                      + prefix[x1 - 1][y1 - 1];

            // (8) 결과 출력
            System.out.println(total);
        }

        sc.close();
    }
}