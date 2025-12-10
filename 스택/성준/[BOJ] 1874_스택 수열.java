package StudyCodingTest.List.stack;
/*
		LIFO 신경써서 push 무조건 오름차순으로 하셈
		1~N까지 수니까
		뽑고 싶은곳까지 넣고 pop
		while (N>0)
			원하는 값이 나올때가지 push
			있어 그러면 pop
			그럼 시작 초기화 하고 다시 실행
			원하는게 없어 그럼 NO 반환
*/
import java.util.Scanner;
import java.util.Stack;

public class BOJ_StackSequence {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();	// 출력할 결과물 저장

        Stack<Integer> stack = new Stack<>();

        int N = in.nextInt();

        int start = 0;

        // N 번 반복
        while(N > 0) {
            N--;
            int value = in.nextInt();

            if(value > start) {
                // start + 1부터 입력받은 value 까지 push를 한다.
                for(int i = start + 1; i <= value; i++) {
                    stack.push(i);
                    sb.append('+').append('\n');	// + 를 저장한다.
                }
                start = value; 	// 다음 push 할 때의 오름차순을 유지하기 위한 변수 초기화
            }

            // top에 있는 원소가 입력받은 값과 같지 않은 경우
            else if(stack.peek() != value) {
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append('-').append('\n');

        }

        System.out.println(sb);
    }
}

