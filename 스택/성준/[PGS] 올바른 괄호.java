package StudyCodingTest.List.stack;
/*
    (  count ++
    )  count --
    count가 음수가 되면 닫는 괄호가 더 많아지고
    count 가 0이면 true 아니면 flase
 */
public class PGS_CorrectParentheses {
    class Solution {
        boolean solution(String s) {
            int count = 0;

            for (char c : s.toCharArray()) {
                if (c == '(') {
                    count++;
                } else {
                    count--;
                }

                // 중간에 닫는 괄호가 더 많아지면 올바르지 않음
                if (count < 0) return false;
            }

            // 모두 처리했을 때 열림 괄호가 남아 있지 않아야 함
            return count == 0;
        }
    }
}
