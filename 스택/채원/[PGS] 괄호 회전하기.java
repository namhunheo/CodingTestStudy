import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int x=0;
        
        //(),[].{}는 모두 올바른 괄호 문자열입니다.
        // A가 올바른 문자열 -> (A),[A],{A} 다 올바른 괄호문자열
        // []-> ([])도 올바른 괄호 문자열
        //A,B가 올바른 문자열 -> AB도 올바른 괄호 문자열
        //EX) {}와 ([])이 올바른 문자열이면-> {}([])도 올바른 문자열
        //s를 왼쪽만큼 회전시켰을 때 s가 올바른 괄호 문자열이 되게하는 x칸의 개수를 return
        
        
        for(int i=0; i<s.length(); i++){
            Stack<Character> stack= new Stack<>();
            //올바른지 아닌지 확인해줘야함.
            boolean isValid= true;
            //회전 가능한 횟수는 0<=x<s.length이다 (=> 0~c.length-1 )
            String s2= s.substring(i)+s.substring(0,i);
            //  i~s.length()-2 까지의 문자열+ 0부터 i-1까지의 문자열을 합침
            char[] ch= s2.toCharArray();
             for(char c: ch){
                 if(c =='(' || c == '{' || c== '['){
                     stack.push(c);
                 } else{ //}이라면 , 비어있으면 잘못된 문자열
                     if(stack.isEmpty()) {
                      isValid=false;
                         break;
                     }
                     // 이부분이 너무 어려워서 챗지피티에게 질문
                     
                     char top= stack.pop();
                    if(c==')' &&  top!='('){
                        isValid=false;
                        break;
                    } 
                     if(c==']' &&  top!='['){
                         isValid=false;
                         break;
                     } 
                     if(c=='}' &&  top!='{'){
                         isValid=false;
                         break;
                     } 
                 }
                
             }
             if(isValid&&stack.isEmpty()) answer+=1;
        }
            return answer;
        }
}