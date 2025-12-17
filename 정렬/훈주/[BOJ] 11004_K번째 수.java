import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // N 입력
        int K = Integer.parseInt(st.nextToken()); // K 입력

        int[] arr = new int[N]; // 수 N개 읽기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 전체 오름차순 정렬
        System.out.println(arr[K - 1]); // K번째(1-indexed) => arr[K-1]
    }
}