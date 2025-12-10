import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		//k개가 주어짐
		//0~1000000사이의 값을 가짐
		//정수가 0인경우에 가장 최근에 쓴 수 지우기
		//아닐경우 해당 수 쓴다
		Scanner sc= new Scanner(System.in);
		int K= sc.nextInt();
		Stack<Integer> st= new Stack<>();
		for(int i=0; i<K;i++) {
			int tmp=sc.nextInt();
			if(tmp==0) {
				st.pop();
			}
		else st.push(tmp);
		}
	int sum=0;
	
		while(!st.empty()) {
			//peek:최근에 추가된 데이터 조회
		sum+=st.peek();
		st.pop();
		}
		System.out.println(sum);
	}

}
