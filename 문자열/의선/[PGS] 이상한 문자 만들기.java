class Solution {
    public String solution(String s) {
        String answer="";
        int index = 0;
        for(int i=0;i<s.length();i++){
            char temp = s.charAt(i);
            
            if(temp==' '){
                index = 0;
            }
            if (s.charAt(i) == ' ') {
            index = 0;
            answer+=" ";
        } else {
            if (index % 2 == 0) {
                answer+=Character.toUpperCase(temp);
            } else {
                 answer+=Character.toLowerCase(temp);            
            }
            index++;
        }
            
        }
        
        
        
        return answer;
    }
}