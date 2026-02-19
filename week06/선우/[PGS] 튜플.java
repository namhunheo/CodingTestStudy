import java.util.*;

class Solution {
    public int[] solution(String s) {

        //  숫자만 남기기
        s = s.replace("{", "")
             .replace("}", "");

        String[] arr = s.split(",");

        //  등장 횟수 카운트
        Map<Integer, Integer> map = new HashMap<>();

        for (String str : arr) {
            int num = Integer.parseInt(str);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //  Map → List로 변환 후 정렬
        List<Map.Entry<Integer, Integer>> list = 
                new ArrayList<>(map.entrySet());

        list.sort((a, b) -> b.getValue() - a.getValue());
        // 내림차순 (많이 나온 순서)

        //  정답 배열 만들기
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).getKey();
        }

        return answer;
    }
}

//처음으로
// 탐색이 쉬워야함
import java.util.*;

class Solution {
    public int[] solution(String s) {

        // 1 바깥 괄호 제거
        s = s.substring(2, s.length() - 2);

        // 2 집합 단위로 분리
        String[] arr = s.split("\\},\\{");

        // 3 길이 기준 정렬
        Arrays.sort(arr, (a, b) -> a.length() - b.length());

        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        // 4 순서대로 새로운 숫자만 추가
        for (String str : arr) {
            String[] nums = str.split(",");
            for (String num : nums) {
                int n = Integer.parseInt(num);
                if (!set.contains(n)) {
                    set.add(n);
                    result.add(n);
                }
            }
        }

        // 5 배열 변환
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
