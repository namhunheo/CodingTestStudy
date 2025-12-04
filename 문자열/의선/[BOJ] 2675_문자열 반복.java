import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			int k = sc.nextInt();
			String temp = sc.next();
			for(int j=0;j<temp.length();j++) {
				char t = temp.charAt(j);
				for(int u=0;u<k;u++) {
					System.out.print(t);
				}
			}
			System.out.println();
		}
		
		
	}
}