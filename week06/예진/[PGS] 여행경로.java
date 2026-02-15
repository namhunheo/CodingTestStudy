import java.util.*;

/* 풀이 2 */
class Solution {

    private List<String> routes = new ArrayList<>();

    public String[] solution(String[][] tickets) {

        // 1. 그래프 초기화
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (String[] ticket : tickets) {
            graph.computeIfAbsent(ticket[0], g -> new PriorityQueue<>())
                    .offer(ticket[1]);
        }
        System.out.println(graph);

        // 2. 탐색
        DFS(graph, "ICN");

        // 3. 역순으로 변환
        Collections.reverse(routes);

        return routes.toArray(String[]::new);

    }

    private void DFS(Map<String, PriorityQueue<String>> graph, String node) {

        PriorityQueue<String> pq = graph.get(node);

        if (pq != null && !pq.isEmpty()) {
            DFS(graph, pq.poll());
        }

        routes.add(node);
    }

}

/* 풀이 1 */
// class Solution {
//     private String[] answer;
//     private boolean flag = false;

//     public String[] solution(String[][] tickets) {

//         DFS(tickets, "ICN", new boolean[tickets.length], new String[tickets.length + 1], 0);

//         return answer;
//     }

//     // 현재 airport를 기준으로 그 다음 사용할 티켓과 도착 공항을 선택
//     private void DFS(String[][] tickets, String airport, boolean[] used, String[] routes, int depth) {
//         routes[depth] = airport;
//         System.out.println("len=" + tickets.length + " depth=" + depth);
//         System.out.println(Arrays.toString(routes));

//         if (tickets.length == depth) {
//             answer = routes;
//             flag = true;
//             return;
//         }

//         // 사용 가능한 티켓을 탐색
//         PriorityQueue<String> pq = new PriorityQueue<>();
//         for (int i = 0; i < tickets.length; i++) {
//             String dept = tickets[i][0];
//             String dest = tickets[i][1];

//             if (dept.equals(airport) && !used[i]) {
//                 pq.offer(dest);
//             }
//         }

//         // 사용할 티켓을 선택 및 탐색
//         while (!pq.isEmpty()) {
//             String nextAirport = pq.poll();
//             int index = findTicket(airport, nextAirport, tickets, used);
//             used[index] = true;
//             DFS(tickets, nextAirport, used, routes, depth + 1);

//             if (flag)
//                 break;
//             used[index] = false;
//         }
//     }

//     private int findTicket(String dept, String dest, String[][] tickets, boolean[] used) {
//         int res = 0;

//         for (int i = 0; i < tickets.length; i++) {
//             if (dept.equals(tickets[i][0]) && dest.equals(tickets[i][1]) && !used[i]) {
//                 res = i;
//                 break;
//             }
//         }

//         return res;
//     }
// }