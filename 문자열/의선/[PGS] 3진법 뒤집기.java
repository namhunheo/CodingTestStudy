class Solution {
    public int solution(int n) {
        int answer = 0;
        String three = "";
        
        while(true){
            
            int f = n%3;
            three+=f;
            n/=3;
            
            if(n==0){
                break;
            }
        }
        
        for(int i=0;i<three.length();i++){
            String a = "";
            a+=three.charAt(three.length()-i-1);
            
            int temp = Integer.parseInt(a);
            answer = answer + (int)(temp * Math.pow(3,i));
        }
        
        
        
        
        
        return answer;
    }
}