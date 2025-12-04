class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        int zeroCnt = 0;
        int Cnt = 0;
        while(!s.equals("1")){
            Cnt++;
            String news = "";
            for(int i = 0 ;i<s.length();i++){
                if(s.charAt(i)=='0'){
                    zeroCnt++;
                    continue;
                }
                news+=s.charAt(i);
            }
            //0제거
            int c = news.length();
            String cars="";
            //길이를 이진법으로 나타내기
            while(c>0){
                cars+=String.valueOf(c%2);
                c/=2;
            }
            s="";
            for(int i = cars.length()-1 ; i>=0;i--){
                s+=cars.charAt(i);
            }
            
            
            
        }
        answer = new int []{Cnt,zeroCnt};
        return answer;
    }
}