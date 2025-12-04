class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        String str = "";
        int cnt = 0;
        int len = m*t;
        p--;
        while(true){
            String temp = Integer.toString(cnt++,n);
            str+=temp;
            if(str.length()>=len){
                break;
            }
        }
        
        for(int i=0;i<str.length();i++){
            char a = str.charAt(i);
            if(i%m==p){
                answer +=a;
            }
            if(answer.length()==t){
                break;
            }
        }
        
        
        answer = answer.toUpperCase();
        
        return answer;
    }
}