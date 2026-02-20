import java.util.*;

class Solution {

    // 각 티켓을 사용했는지 체크하는 배열
    static boolean[] visited;

    // 최종 경로를 저장할 리스트
    static List<String> result = new ArrayList<>();

    // 정답을 찾았는지 확인하는 변수
    // 사전순으로 정렬했기 때문에
    // 처음 완성된 경로가 정답이다.
    static boolean finished = false;

    public String[] solution(String[][] tickets) {

        // 1. 사전순 정렬
        // 출발지가 같으면 도착지 기준으로 정렬
        // 그래야 사전순으로 가장 빠른 경로를 먼저 탐색함
        Arrays.sort(tickets, (a, b) -> {
            if(a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });

        // 2. 방문 배열 생성
        visited = new boolean[tickets.length];

        dfs("ICN", "ICN", tickets, 0);

        // 4. 리스트 → 배열로 변환 후 리턴
        return result.toArray(new String[0]);
    }

    public void dfs(String current, String path,
                    String[][] tickets, int count) {

        // 이미 정답 찾았으면 더 이상 탐색하지 않음
        if(finished) return;

        // 모든 티켓을 다 사용했으면
        if(count == tickets.length) {

            result = Arrays.asList(path.split(" "));

            // 정답 찾았다고 표시
            finished = true;
            return;
        }

        // 모든 티켓을 하나씩 확인
        for(int i = 0; i < tickets.length; i++) {
            // 아직 사용하지 않았고 현재 공항에서 출발하는 티켓이면
            if(!visited[i] && tickets[i][0].equals(current)) {

                // 티켓 사용 처리
                visited[i] = true;
                // 다음 공항으로 이동 (재귀 호출)
                dfs(tickets[i][1],               // 다음 공항
                        path + " " + tickets[i][1],  // 경로 추가
                        tickets,
                        count + 1);                  // 사용 개수 증가
                visited[i] = false;
            }
        }
    }
}