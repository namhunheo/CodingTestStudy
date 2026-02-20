// 단품 메뉴 2개 이상 조합, 2명 이상
// 메뉴 담긴 배열 orders, 메뉴 개수 담긴 배열 course

// 각 주문에서 길이 course[i]인 모든 조합 생성
// 예: 주문 "ABCFG"에서 2개 조합 → AB, AC, AF, AG, BC, ...

// 조합별 빈도 계산
// 최소 2번 이상 나온 조합만 선택


// 알파벳 순서로 정렬해서 결과 반환

import java.util.*;

class Solution {
    static Map<String, Integer> map;

    public String[] solution(String[] orders, int[] course) {
        List<String> answerList = new ArrayList<>();

        for (int c : course) {
            map = new HashMap<>();

            // 모든 주문에서 조합 생성
            for (String order : orders) {
                char[] arr = order.toCharArray();
                Arrays.sort(arr);
                combination(arr, "", 0, c);
            }

            int max = 0;

            // 최대값 찾기
            for (int count : map.values()) {
                if (count >= 2) {
                    max = Math.max(max, count);
                }
            }

            // 최대값과 같은 조합 추가
            for (String key : map.keySet()) {
                if (map.get(key) == max && max >= 2) {
                    answerList.add(key);
                }
            }
        }

        Collections.sort(answerList);

        return answerList.toArray(new String[0]);
    }

    // 조합을 글자 수별로 짜야할거 같은데, 찾아보니 백트래킹 조합 템플릿이 있어 기반으로 함
    static void combination(char[] arr, String str, int start, int r) {
        if (r == 0) {
            map.put(str, map.getOrDefault(str, 0) + 1);
            return;
        }

        for (int i = start; i < arr.length; i++) {
            combination(arr, str + arr[i], i + 1, r - 1);
        }
    }
}
