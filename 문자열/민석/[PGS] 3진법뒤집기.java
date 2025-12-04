class Solution {
    public int solution(int n) {
        int answer = 0;
        String str = "";
        while(n > 0 ){
            int t = n % 3;
            str+=String.valueOf(t);
            n/=3;
            
        
        }
        for(int i = str.length()-1; i>=0;i--){
            
             int a = Integer.parseInt(String.valueOf(str.charAt(i)));
            
            for(int j = 0 ; j<str.length()-1-i; j++){
                
                    a*=3;
            }
            answer += a;
                   
        }
        
        return answer;
    }
}