class Solution {
	    public String solution(String new_id) {
	        String answer = "";
	        //길이 3<=  <= 15
	        //알파벳소문자, 숫자, 빼기,밑줄,마침표 문자
	        //마침표는 처음과 끝에 사용x, 연속 사용불가
	        
	        //1단계 대문자를 소문자로
	        for(int i = 0 ;i<new_id.length();i++){
	            if(new_id.charAt(i) >= 65 && new_id.charAt(i)<=90){ //대문자라면
	                answer += (char)(new_id.charAt(i)+32);  //소문자로 변환해
	            }else answer+=new_id.charAt(i); //추가 
	            
	        }  
	        
	        String newanswer="";
	        //2단계 해당 문자를 제외한 모든 문자 제거 
	        for(int i =0 ;i < answer.length() ; i++){
	            char c = answer.charAt(i);
	            if(c == '_'){     //밑줄
	                newanswer+='_';
	                continue;
	            }
	            if(c=='-'){ //빼기
	                newanswer+='-';
	                continue;
	            }
	            if(c=='.'){//마침표
	                newanswer+='.';
	                       continue; 
	            }
	            if(Character.isDigit(c)){//숫자
	                    newanswer+=c;
	                    continue;
	            }
	            if(c>= 97 && c<= 122) { //소
	                newanswer +=c;
	                continue;
	            }
	            
	            
	            
	        }
	        answer = "";   
	        //3단계 시작 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
	        boolean check = false;
	        for(int i = 0 ; i < newanswer.length() ; i++){
	            char c = newanswer.charAt(i);
	            if(c == '.' && !check){
	                answer+=c;
	                check = true;
	            }
	            else if(c!='.'){
	                answer += c;
	                check = false;
	                
	            }
	        }
	        newanswer="";
	        
	        //4단계
	        for(int i = 0 ; i<answer.length();i++){
	            char c = answer.charAt(i);
	            if(i ==0 && c == '.')continue;
	            if(i==answer.length()-1 && c == '.')continue;
	            newanswer += c;
	        }
	        
	        //5단계
	        if(newanswer.equals("")) newanswer+="a";
	        answer = "";
	       
	        //6단계
	        if(newanswer.length()>=16){
	            int charCnt = 0;
	            for(int i = 0 ;i<newanswer.length();i++){
	                char c =newanswer.charAt(i);
	                charCnt++;
	                if(charCnt >= 16  ){
	                    continue;
	                }
	                answer+=c;
	                
	            }
	            newanswer = "";
	            for(int i = 0;i<answer.length();i++){
	                if(i == answer.length()-1 && answer.charAt(i)=='.')continue;
	                newanswer+=answer.charAt(i);
	            }
	            
	        }
	        
	       
	        //7단계
	        if(newanswer.length() <= 2){
	            
	            answer = newanswer;
	            for(int i = newanswer.length();i<3;i++){
	                answer +=newanswer.charAt(newanswer.length()-1);
	                
	            }
	        }
	        else{
	            answer = newanswer;
	        }
	        
	        
	        return answer;
	    }
	}