import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static int binaryFind(int[] nNum,int m) {
	int fir=0; 
		int end=nNum.length-1;
		
		while(fir<=end) {
			int mid=(fir+end)/2;
			if(nNum[mid]==m) return 1;
			else if(nNum[mid]>m) end=mid-1; //만약 mid에 있는 값이 m보다 크면 -> end값이 내려옴
			else fir=mid+1; // 만약 mid에 있는 값이 m보다 작으면 first가 올라와야함
		}
		return 0;
		
	}

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n= sc.nextInt();
		int[] nNum= new int[n];
		for(int i=0; i<n; i++) {
			nNum[i]=sc.nextInt();
		}
		Arrays.sort(nNum);
		int m= sc.nextInt();
		int[] mNum= new int[m];
		for(int i=0; i<m; i++) {
			mNum[i]=sc.nextInt();
			System.out.println(binaryFind(nNum,mNum[i]));;
		}
		
		
		
	}
}