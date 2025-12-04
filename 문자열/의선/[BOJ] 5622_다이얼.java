import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String temp = sc.nextLine();
		int time = 0;
		for(int i=0;i<temp.length();i++) {
			char c = temp.charAt(i);
			
			if(c>='A'&&c<='C') {
				time+=3;
			}
			if(c>='D'&&c<='F') {
				time+=4;
			}
			if(c>='G'&&c<='I') {
				time+=5;
			}
			if(c>='J'&&c<='L') {
				time+=6;
			}
			if(c>='M'&&c<='O') {
				time+=7;
			}
			if(c>='P'&&c<='S') {
				time+=8;
			}
			if(c>='T'&&c<='V') {
				time+=9;
			}
			if(c>='W'&&c<='Z') {
				time+=10;
			}
			
			
			
			
		}
		System.out.println(time);
		
	}
}