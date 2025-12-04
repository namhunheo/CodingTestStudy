class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for(int i = 0 ;i<s.length();i++){
            
            char c = s.charAt(i);
            if(c == ' '){
                answer+=" ";
            }
            else{
                if(c + n > 122 && c >= 97){ //대문자인데 넘어가면 
                    answer += (char)(c + n - 26);
                }
                else if(c + n > 90 && c <= 90 ){  //소문자인데 넘어가면
                    answer += (char)(c + n - 26);
                }
                else{
                    answer += (char)(c+n);
                }
            }
            
        }
        
        return answer;
    }
}