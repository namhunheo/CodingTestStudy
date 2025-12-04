class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        int len = s.length();
        for(int i=0;i<len;i++){
            char temp = s.charAt(i) ;
            if(temp>='a'&&temp<='z'){
                temp = (char)((temp - 'a' + n) % 26 + 'a');
                answer+=temp;
            }else if(temp>='A'&&temp<='Z'){
                 temp = (char)((temp - 'A' + n) % 26 + 'A');
                answer+=temp;
            }else{
                answer+=temp;
            }
            
        }
        
        return answer;
    }
}