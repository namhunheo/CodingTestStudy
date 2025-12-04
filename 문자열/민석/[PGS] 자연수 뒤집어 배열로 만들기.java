class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        
        String strr = String.valueOf(n);
        answer = new int[strr.length()];
        
        for(int i=strr.length()-1;i>=0;i--) {  //마지막꺼 부터 
            
            answer[strr.length()-1-i]=strr.charAt(i)-'0';
            
        }
        
        return answer;
        
    }
}