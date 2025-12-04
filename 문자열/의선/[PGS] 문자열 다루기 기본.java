class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        if(s.length()!=4&&s.length()!=6){
            answer = false;
        }
        
        
        for(int i=0;i<s.length();i++){
            char temp = s.charAt(i);
            if(temp>='0'&&temp<='9'){
                
            }else{
                answer = false;
            }
        }
        
        
        
        
        return answer;
    }
}