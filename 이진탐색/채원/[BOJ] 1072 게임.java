import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//게임 횟수: x
		//이긴 게임 :y(Z%)
		//z는 형택이의 승률이고 소수점은 버린다 . ex) x=52/ y=47/ z=88
		//x와 y가 주어졌을 때 => 게임을 최소 몇번을 더 해야 z가 변하는지 구하는 프로그램
		//ex 예제 1) 10판 중에 8판을 이김 
		//배열을 어떻게 얻...어요?..ㅋㅋ 미치겠네 ...????? ->블로그 하나 훑어봄
		//int를 사용하면 안되는 이유 = mid의 최대값이 1000000000 -> 10^9 여기서 평균까지하면 10^11
		//int는 약 21억까지밖에 안되므로 long사용해야함 (chatgpt)
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		long allGame= Long.valueOf(st.nextToken());
		long winGame= Long.valueOf(st.nextToken());
		long avgGame=(winGame*100)/allGame; //왜 안되나 했더니 작은거 /큰거 =0 이라는 걸 ,..
		long start=1;
		long end=1000000000;
		long answer=Integer.MAX_VALUE;
		if (avgGame >= 99) {//오 이경우는 몰랐어요...
		    System.out.println(-1);
		    return;
		}
		while(start<=end) {
			long mid= (start+end)/2;
			long tmp=((winGame+mid)*100)/(allGame+mid);
			if(tmp>avgGame) {
				//System.out.println(mid+"~"+answer);
				answer=mid; //일단 바뀌니까 ~
				end=mid-1;
			}
			else start=mid+1;
		}
		System.out.println(answer);
	}
}