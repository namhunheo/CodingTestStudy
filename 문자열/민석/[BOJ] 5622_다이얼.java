
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
//		System.out.println("Hello,     Java3"); //system이라는 안에 out이 있음
//		System.out.println("fdsf");
//        //sysout누르고 컨트롤 스페이스바
//	
//		//주석은 바이너리코드로 바꿀때 제외해서 많이해도상관x 용량에 지장x
//		String str="sffsd";
//		System.out.println(str);
		
		
//		Main m = new Main();
//		
//		int result = m.solution(3, 4, new boolean []{true, false, false, true, true});
//		
//		System.out.println(result);
////		
		
		String str = br.readLine();
		int num = 0;
		
		for(int i=0;i<str.length();i++) {
			
			char t = str.charAt(i);
			
			if( 'A'<= t && t<= 'C') {
				num+=3;
			}
			else if('D' <= t && t <= 'F') {
				num+=4;
				
			}
			else if('G' <= t && t <= 'I') {
				num+=5;
				
			}
			else if('J'<= t && t<= 'L') {
				num+=6;
			}
			else if('M' <= t && t<= 'O') {
				num+=7;
			}
			else if('P' <= t && t<= 'S') {
				num+=8;
			}
			else if('T' <= t && t<= 'V') {
				num+=9;
			}
			else if('W' <= t && t<= 'Z') {
				num+=10;
			}
			
			
		}
		System.out.println(num);
		
		
		
	}
	
	
	
	
	public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        answer = a;
      
        
        for(int i=1;i<included.length; i++) {
            
            if(included[i]==true) {
                answer += (i) * d;
                System.out.println(answer);
                
            }
        }
        
        
        
        
        return answer;
    }

}
