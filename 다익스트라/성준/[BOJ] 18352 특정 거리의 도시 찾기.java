package studycodingtest.Dijkstra;
/*
    도시 개수 : N
    도로의 개수 M
    목표 거리 K
    출발 도시 번호 X

    모든 거리는 1고정, 단방향
 */
import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_City {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = (reader.readLine()).split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        int K = Integer.parseInt(inputs[2]);
        int X = Integer.parseInt(inputs[3]);

        // 인접 리스트 사용하고
        List<Integer>[] arr = new ArrayList[N + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        // 도로 정보를 저장해 해주고
        for (int i = 0; i < M; i++) {
            String[] str = reader.readLine().split(" ");
            int A = Integer.parseInt(str[0]); // 출
            int B = Integer.parseInt(str[1]); // 도
            arr[A].add(B);
        }

        // 거리 배열 해서 dis[i] = -1 이면 방문하지 않은 dis[i] >= 0 x에서 i까지의 최단 거리
        int[] dis = new int[N + 1];
        Arrays.fill(dis, -1);
        List<Integer> answer = new ArrayList<>();

        // BFS 초기화 해주고
        Queue<Integer> q = new LinkedList<>();
        q.offer(X);
        dis[X] = 0;

        // BFS 탐색 로직
        while (q.size() != 0) {
            int cur = q.poll();

            // 최단 거리 결과 저장해주고
            if (dis[cur] == K)
                answer.add(cur);

            // 인접 도시 탐색해주고
            for (int i = 0; i < arr[cur].size(); i++) {
                if (arr[cur].get(i) != X && dis[arr[cur].get(i)] == -1) {
                    q.offer(arr[cur].get(i));
                    dis[arr[cur].get(i)] = dis[cur] + 1;
                }
            }
        }

        if (answer.size() == 0) {
            System.out.print("-1");
        } else {
            answer.sort((o1, o2) -> {
                return o1 - o2;
            });

            for (int i = 0; i < answer.size(); i++) {
                System.out.println(answer.get(i));
            }
        }
    }
}
