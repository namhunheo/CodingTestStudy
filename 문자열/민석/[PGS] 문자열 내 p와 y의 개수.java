class Solution {
    boolean solution(String s) {
     
        int yCnt = 0;
        int pCnt = 0;
        for(int i = 0 ; i<s.length();i++){
            char c = s.charAt(i);
            if(c == 'Y' || c=='y' ) yCnt++;
            if(c == 'P' || c == 'p') pCnt++;
        }
        if(yCnt == pCnt) return true;
        else{
            return false;
        }
    

       
    }
}