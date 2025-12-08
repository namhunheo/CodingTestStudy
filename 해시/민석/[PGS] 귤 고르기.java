import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer,Integer>map = new HashMap<>();
        for (int i = 0 ; i<tangerine.length;i++){
            map.put(tangerine[i],map.getOrDefault(tangerine[i],0)+1);
        }
        ArrayList<Integer>arr = new ArrayList<>();
        for(Integer a : map.keySet()){
            arr.add(map.get(a));
            
        }
        Collections.sort(arr); //겹치는 게 많은 걸 먼저 상자에 넣자 그래야 상자에 있는 종류수가 최소가 되니까 
        
        
        for(int i= arr.size()-1 ; i>=0;i--){
            
            k-=arr.get(i);
            answer++;
            if(k<=0){ //음수가 되어도 어짜피 상자에 있는 가짓수로1 체크하는거니  상관x
                return answer;
            }
            
        }
        
        
        
        
        return answer;
    }
}