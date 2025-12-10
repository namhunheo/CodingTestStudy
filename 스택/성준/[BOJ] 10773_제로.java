package StudyCodingTest.List.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
    k로 정수 입력하고
    if
    0이면 저장된거 pop 해
    else
    아니면 원소 추가해
 */
public class BOJ_Zero {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < k; i++){
            int temp = Integer.parseInt(br.readLine());

            if(temp == 0){
                stack.pop();
            }else{
                stack.push(temp);
            }
        }
        int sum = 0;
        for (int i = 0; i < stack.size(); i++) {
            sum += stack.get(i);
        }
        System.out.println(sum);
    }
}
