class Solution {
    public int solution(String s) {
        String answer = "";
        String compare="";
        String arr[] = new String[]{"zero","one","two","three","four","five","six","seven","eight","nine"};
        for(int i = 0 ; i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){ //정수면 그냥 더해 
                answer += s.charAt(i);
            }
            else{
                compare+=s.charAt(i);
                if(compare.length() >=3) {      
                    for(int c=0;c<10;c++){
                        if(compare.equals(arr[c])){
                            
                            answer += String.valueOf(c);
                            compare ="";
                            break;
                        }
                    }
                }
                
                
            }
              
               
        
    
        }
        return Integer.parseInt(answer);
    }
}