package StudyCodingTest.List.stack;
/*
    여는게 있으면 무조건 닫는게 있는지 검사를 진행을 해야한다.
    여는 괄호 push 하고
    닫는 괄호는 스택 top이랑 맞는지 체크
    맞으면 pop
    안맞으면 멈추고

 */

import java.util.ArrayList;
import java.util.List;
public class PGS_BracketRotation {
    class Solution {
        public int solution(String s) {
            int answer = 0;
            int count = 0;
            int n = s.length();

            while (count < n) {
                List<Character> stack = new ArrayList<>();
                boolean valid = true;

                for (int i = 0; i < n; i++) {
                    char c = s.charAt(i);

                    // 여는 괄호면 push
                    if (c == '[' || c == '{' || c == '(') {
                        stack.add(c);
                        continue;
                    }

                    // 닫는 괄호면 검사
                    if (stack.isEmpty()) {
                        valid = false;
                        break;
                    }

                    char top = stack.get(stack.size() - 1);

                    // 짝이 맞는지 switch로 간결하게 확인
                    boolean match =
                            (c == ']' && top == '[') ||
                                    (c == '}' && top == '{') ||
                                    (c == ')' && top == '(');

                    if (match) {
                        stack.remove(stack.size() - 1);
                    } else {
                        valid = false;
                        break;
                    }
                }

                // 회전
                s = s.substring(1) + s.charAt(0);
                count++;

                // 정상 괄호 문자열인지 판단
                if (valid && stack.isEmpty()) {
                    answer++;
                }
            }

            return answer;
        }

    }

}
