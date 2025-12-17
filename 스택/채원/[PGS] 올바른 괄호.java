import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer =true;
        //괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다.
        //'(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때,
        //문자열 s가 올바른 괄호이면 true를 return 하고,
        //올바르지 않은 괄호이면 false를 return 
    Stack<Character> st= new Stack<>();
    char[] ch= s.toCharArray();
        
        int index=0;
        while(index<ch.length){
        
          
                if(ch[index]=='('){ //일단 (이면 push
                  st.push(ch[index]);
           
                }
                else if(ch[index]==')'){ //)이면 안에 (이 있는지 확인 
                    if(st.isEmpty()){//비어있으면 올바르지 않기때문에 false
                        answer=false;
                            break;
                    }

                    if(st.peek()!='('){//empty상태가아니고, )이면 올바르지 않기 때문에 false
                        if(st.isEmpty()){
                        answer=false;
                            break;}
                      
                    }  st.pop(); //(이면 올바른 상태이므로 pop;
                }    
            index+=1;
        }
        if(!st.empty()) answer=false;//만약 남은것이 있다면 올바르지 않기 때문에 false
       
        return answer;
    }
}