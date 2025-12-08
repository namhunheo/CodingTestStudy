import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer,Integer> map1 = new HashMap<>();   
        HashMap<Integer,Integer> map2 = new HashMap<>();    
        //토핑을 자름
       
        // 1 2 3 1 4
        for(int i = 0 ;i<topping.length  ;i++){  //1~4
            //자르려 하면 안되나 ? 자르는 순간부터 n의 2승임 -=> 1초넘어감 
             
             map2.put(topping[i],map2.getOrDefault(topping[i],0)+1);
        }
        
        for(int i = 0 ;i<topping.length  ;i++){  //1~4
            //자르려 하면 안되나 ? 자르는 순간부터 n의 2승임 -=> 1초넘어감 
             
             map1.put(topping[i],map1.getOrDefault(topping[i],0)+1);
              map2.put(topping[i],map2.getOrDefault(topping[i],0)-1);
            if(map2.get(topping[i]) == 0)map2.remove(topping[i]);
            
            if(map1.size() == map2.size()){
                answer++;
            }
        }
        
        
        
            
            
            
// //자르려 하면 안되나 ? 자르는 순간부터 n의 2승임 -=> 1초넘어감             
//                HashMap<Integer,Integer> map1 = new HashMap<>();            
//              HashMap<Integer,Integer> map2 = new HashMap<>();            
            
//             for(int j = 0 ;j < i;j++){
//                 map1.put(topping[j], map1.getOrDefault(topping[j],0)+1);
//             } //키값으로 나눔 
            
            
//             for(int j = i; j < topping.length; j++){
//                 map2.put(topping[j], map2.getOrDefault(topping[j],0)+1);
//             } //키값으로 나눔 
            
            
    
            
//             if(map1.size() == map2.size()){
//                 answer++;
//             }
            
            
            
        
        
        
        //자른 원소를 hash의 key값으로 
        //key값이 같으면 answer ++ 
        
        return answer;
    }
}