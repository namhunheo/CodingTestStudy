
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack<Integer> st = new Stack<Integer>();
		
		int sum = 0;
		
		for(int i=0;i<n;i++) {
			int temp = sc.nextInt();
			if(temp==0) {
				st.pop();
			}else {
				st.push(temp);
			}
			
		}
		int s = st.size();
		for(int i=0;i<s;i++) {
			sum +=st.pop();
		}
		System.out.println(sum);
		
		
		
	}
}