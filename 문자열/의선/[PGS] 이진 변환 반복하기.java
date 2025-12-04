class Solution {
    public int[] solution(String s) {
        int[] answer = {1,0};
            
        
        while(true){
            for(int i=0;i<s.length();i++){
                char temp = s.charAt(i);
                if(temp=='0'){
                    answer[1]++;
                }
            }
            s = s.replace("0","");
            if(s.equals("1")){
                break;
            }
            int len = s.length();
            s = Integer.toBinaryString(len);
            answer[0]++;

            
            
            
        }
       
        
        return answer;
    }
}