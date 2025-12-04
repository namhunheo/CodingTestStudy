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
		
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0 ;i<T;i++) {
			
			String [] arr =br.readLine().split(" ");
			
			for(int j=0;j<arr[1].length();j++) {
				
				for(int k=0;k<Integer.parseInt(arr[0]);k++) {
					System.out.print(arr[1].charAt(j));
				}
			}
			
			
			System.out.println();
			
			
			
			
		}
		
		
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
