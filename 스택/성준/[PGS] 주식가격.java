package StudyCodingTest.List.stack;

import java.util.Stack;

public class PGS_StockPrice {

    class Solution {
        public int[] solution(int[] prices) {
            int n = prices.length;
            int[] answer = new int[n];
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < n; i++) {
                // 가격이 떨어졌다면 스택에 있는 인덱스 정산
                while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                    int idx = stack.pop();
                    answer[idx] = i - idx;
                }
                // 아직 떨어지지 않은 시점 push
                stack.push(i);
            }

            // 끝까지 떨어지지 않은 경우 처리
            while (!stack.isEmpty()) {
                int idx = stack.pop();
                answer[idx] = n - 1 - idx;
            }

            return answer;
        }
    }

}
