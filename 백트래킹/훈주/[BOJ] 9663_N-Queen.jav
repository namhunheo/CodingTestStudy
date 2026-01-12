/*
* N-Queen[각 행에 퀸을 하나씩 놓되, 열과 대각선이 겹치지 않도록 DFS + 가지치기하는 문제]
*
* 한 줄에 하나씩 퀸을 놓으면서, for문으로 놓을 수 있는 칸을 다 시도 해보고 다음줄.
* 아래 줄에서 더 이상 착수 불가 시 다시 위로 돌아가 다른 칸 시도.
* → DFS(재귀)
*
* 같은 행/열/대각선에 있는 경우 → 공격
* → 거리/방해물 있어도 공격 가능
* 행 순서대로 배치
* “이 줄 어디에 퀸을 놓을까?”
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int n; // 체스판 크기 (n x n)
    static long count; // 가능한 경우의 수

    static boolean[] colUsed;
    static boolean[] diagDownUsed; // row - col + (n - 1)
    static boolean[] diagUpUsed;   // row + col

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());

        // 각 열 / 대각선이 이미 사용됐는지 기록하는 배열
        colUsed = new boolean[n];
        diagDownUsed = new boolean[2 * n - 1];
        diagUpUsed = new boolean[2 * n - 1];

        dfs(0); // 0번째 줄부터 퀸을 놓기 시작
        System.out.println(count); // 가능한 모든 경우의 수 출력
    }

    static void dfs(int row) { // row번째 줄에 퀸을 놓는 함수
        if (row == n) {
            count++;
            return;
        }

        // 현재 줄에서 놓을 수 있는 모든 칸을 하나씩 시도
        for (int col = 0; col < n; col++) {
            // 현재 위치의 대각선 번호 계산
            int diagDown = row - col + (n - 1);
            int diagUp = row + col;

            if (colUsed[col] || diagDownUsed[diagDown] || diagUpUsed[diagUp]) {
                continue;   // 이미 사용된 열이나 대각선이면 놓을 수 없음
            }

            colUsed[col] = true;
            diagDownUsed[diagDown] = true;
            diagUpUsed[diagUp] = true;

            dfs(row + 1);

            // 다시 돌아왔으면(실패 or 탐색 끝)
            // 방금 놓은 퀸을 제거하고 다른 칸을 시도
            colUsed[col] = false;
            diagDownUsed[diagDown] = false;
            diagUpUsed[diagUp] = false;
        }
    }
}