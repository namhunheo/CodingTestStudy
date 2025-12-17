
import java.util.Scanner;
//위에 package 달고  에러문뜬다고 당황했어요... chatgpt는 천재인가?
public class Main {
	public static long pv(int i) {
	    
		if(i==0) return 0;
        if(i==1) return  1;// F(1)
		return pv(i-1)+pv(i-2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int n= sc.nextInt();
		
		System.out.println(pv(n));
	}


}
