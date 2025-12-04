class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        //n은진법
        //t는 미리 구할 숫자의 갯수
        //m은 게임참기인원 한명당 자릿수 하나
        //p는 튜브의 순서
        //Integer.parseInt()
        //Integer.parseInt("123", 7);
        //게임에 참가하는 인원 m 
        // 
        int index = 1;  //튜브의 순서를 찾게해주는 인덱스
        //t 숫자갯수만큼 구하면 리턴
        //근데 0 ~ 
        //cnt ->   종료조건 튜브가 알아야할 수 
        int start = 0;
        int cnt = 0;
        while(cnt < t){
            
            String str = Integer.toString(start,n); //문자열로 나타냄
            str=str.toUpperCase();
            
            for(int i = 0 ;i<str.length();i++){
                
                if(index == p){
                    answer += str.charAt(i);
                    cnt++;
                    if(cnt ==t) return answer;
                    index++;
                    if(index > m){
                        index%=m;
                    }
                    
                }
                else{
                    index++;
                    if(index > m){
                        index%=m;
                    }
                    
                }
            }
            
            start++;
            
            
            
        }
                
        return answer;
    }
}