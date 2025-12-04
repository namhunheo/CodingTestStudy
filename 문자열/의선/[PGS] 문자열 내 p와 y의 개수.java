class Solution {
    boolean solution(String s) {
        boolean answer = true;
        s = s.toLowerCase();
        
        
        int p=0,y=0;
        for(int i=0;i<s.length();i++){
            char temp = s.charAt(i);
            if(temp=='y'){
                y++;
                
            }
            if(temp=='p'){
                p++;
                
            }
        }
        if(p==y){
            return true;
        }
        
        

        return false;
    }
}