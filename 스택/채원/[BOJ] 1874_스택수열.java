import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
public class Main {
public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N=sc.nextInt();
		int[] result=new int[N];
		Stack<Integer> s= new Stack<>();
		StringBuilder sb= new StringBuilder("");
		int loc=1; // 수열 ++
		
		boolean t=true;
		for(int i=0; i<N; i++) {
			int tmp=sc.nextInt();
	
		while(loc<=tmp) {
					
				s.push(loc);
				sb.append("+");
				loc++;
			//	System.out.println(result.peek()+"/"+loc+"/"+s.peek());
			}
			
			if(s.peek()==tmp) { //같은경우
				sb.append("-");
				//System.out.println("들어감");	
				//System.out.println(result.peek()+"/"+loc+"/"+s.peek());
				s.pop(); 
				continue;
			}
			else {
				t=false;
				System.out.println("NO");
				return;
			}
		}
		
		if(t==true) {
			for(int i=0; i<sb.length(); i++) {
				System.out.println(sb.charAt(i));
			}
		}
	}
}