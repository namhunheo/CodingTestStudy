import java.util.*;
class Solution {
    //문제를 풀었으나, 이해를 똑바로 하지 못한거 같다. 
    // chatgpt한테 물어봄. 
    // 주식 가격 배열 prices를 받아
    // 각 시점마다 가격이 떨어지지 않은 기간을 반환
    public int[] solution(int[] prices) {

        int n = prices.length;
        // 주식 가격 배열의 길이 (전체 시간)

        int[] answer = new int[prices.length];
        // 각 시점별 가격 유지 시간을 저장할 배열

        Stack<Integer> st = new Stack<>();
        // 아직 가격이 떨어지지 않은 시점의 "인덱스"를 저장하는 스택

        
        for (int i = 0; i < prices.length; i++) {

            // 현재 시점 i의 가격이
            // 스택 top에 해당하는 시점의 가격보다 낮아졌다면
            while (!st.isEmpty() && prices[i] < prices[st.peek()]) {

                // 가격이 떨어진 시점의 인덱스를 스택에서 꺼냄
                int idx = st.pop();

                // idx 시점의 가격은
                // i 시점까지 유지되었으므로 기간은 (i - idx)
                answer[idx] = i - idx;
            }

            // 현재 시점 i는 아직 가격이 떨어지지 않았으므로
            // 스택에 인덱스를 저장
            st.push(i);
        }

        // 반복문이 끝난 후에도 스택에 남아 있는 인덱스들은
        // 끝까지 가격이 떨어지지 않은 경우
        while (!st.isEmpty()) {

            // 아직 처리되지 않은 시점의 인덱스
            int idx = st.pop();

            // 끝까지 가격이 유지된 기간은
            // (전체 길이 - 1 - idx)
            answer[idx] = n - 1 - idx;
        }

        // 각 시점별 가격 유지 기간 배열 반환
        return answer;
    }
}
