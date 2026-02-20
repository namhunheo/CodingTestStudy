import java.util.*;

class Solution {
    public int[] solution(String s) {
        // {{ 와 }} 제거
        s = s.replace("{{","").replace("}}","");
        // },{ 기준 분리
        String[] arr = s.split("\\},\\{");

        // 튜플을 배열로 분리해서 리스트 저장
        ArrayList<String[]> list = new ArrayList<>();
        for(String x : arr) {
            String[] temp = x.split(",");
            list.add(temp);
        }

        int[] answer = new int[list.size()];

        HashMap<String,Integer> hash = new HashMap<>();

        for(int i=0; i<list.size(); i++){
            for(int j=0; j<list.size(); j++){
                if(list.get(j).length == i+1){
                    for(int k=0; k<list.get(j).length; k++){
                        if(hash.get(list.get(j)[k]) == null){
                            hash.put(list.get(j)[k],1);
                            answer[i] = Integer.parseInt(list.get(j)[k]);
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return answer;
    }
}