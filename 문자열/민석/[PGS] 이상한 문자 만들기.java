import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        ArrayList<String>list = new ArrayList<>();
        String str = "";
        //시작이나 끝에 공백이 있을 수 있음 
        int index = 0;
      
        for(int i = 0 ; i<s.length();i++){
            char c = s.charAt(i);
            
           if(c == ' '){
               index = 0;
                answer += ' ';
                  
               
           }
            else{
               
                if(index % 2 ==0){
                    if(c >= 97 && c<= 122) {
                        c -= 32;
                        answer+=(char)c;
                    }
                    else answer += (char)c;
                    
                }
                else{
                    if(c >= 65 && c<= 90) {
                        c += 32;
                        answer+=(char)c;
                    }
                     else answer += (char)c;
                   
                    
                }
                index++;
                
                
            }
            
        }
       

   
        
       
        return answer ;
       
    }
}