import java.util.*;

 * 재귀 원리 (주석으로 발표 설명 가능):
     * 1. n == 1 : 바로 이동
     * 2. n > 1 : 
     *    a) 위 n-1개를 보조 막대로 이동
     *    b) 가장 큰 원판 start → end 이동
     *    c) n-1개를 보조에서 목적지로 이동
     */
class Solution {

    // 이동 정보를 저장할 리스트
    // 이유:
    // 1. N개의 원판 이동 횟수 = 2^N - 1 → N이 커지면 배열 크기 미리 계산 어려움
    // 2. ArrayList는 동적으로 늘어나므로 안전하게 이동 기록 저장 가능
    List<int[]> list = new ArrayList<>();

    // solution 메소드: N을 입력받아 모든 이동 순서를 int[][]로 반환
    public int[][] solution(int n) {
        // 1번 막대에서 3번 막대로 N개의 원판 이동 시작
        // start = 1, mid = 2, end = 3
        hanoi(n, 1, 2, 3);

        // 리스트에 저장된 이동 기록을 int[][] 배열로 변환
        // 프로그래머스 제출 형식에 맞춤
        int[][] answer = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);  // 각 이동 기록 복사
        }
        return answer;  // 최종 결과 반환
    }

    /**
     * 재귀로 하노이 탑 이동 구현
     * 
     * n     : 이동할 원판 개수
     * start : 시작 막대 번호
     * mid   : 보조 막대 번호
     * end   : 목적지 막대 번호
     *
     * 원리:
     * 1. n == 1이면 바로 이동
     * 2. n > 1이면 재귀적으로 n-1개를 임시로 이동 → 큰 원판 이동 → 나머지 n-1개를 목적지로 이동
     */
    private void hanoi(int n, int start, int mid, int end) {
        // 1. 종료 조건: 원판 1개만 남았을 때
        if (n == 1) {
            // 원판 1개는 바로 start → end로 이동
            list.add(new int[]{start, end}); // 이동 기록 저장
            return;
        }

        // 2. 재귀 이동: 위 n-1개 원판을 보조(mid) 막대로 이동
        // 큰 원판을 움직이기 위해 위에 있는 n-1개 원판을 잠시 치움
        hanoi(n - 1, start, end, mid);

        // 3. 가장 큰 원판 이동: start → end
        // 이 단계에서 n번째(가장 큰) 원판이 목적지로 이동
        list.add(new int[]{start, end}); // 이동 기록 저장

        // 4. 재귀 이동: n-1개의 원판을 mid → end로 이동
        // 이제 잠시 치워두었던 n-1개의 원판들을 목적지 막대로 옮김
        hanoi(n - 1, mid, start, end);
    }
}
