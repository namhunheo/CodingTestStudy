import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 1) 숫자를 문자열 배열로 변환
        // "숫자 크기" 아닌 "이어붙인 문자열의 크기" 기준으로 비교
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        // 2) 핵심: 정렬 기준(Comparator): 더 큰 결과 만드는 문자열이 앞.
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // 3) 예외 처리: 가장 앞이 "0"이면 전부 0인 케이스
        //    (정렬 결과가 "0"으로 시작한다는 것은 다른 모든 값도 "0"이라는 뜻)
        if (arr[0].equals("0")) return "0";

        // 4) 정렬된 순서대로 이어붙이기
        //    String은 매번 새 객체 생성이라 O(n^2) 위험 -> StringBuilder 사용
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }

        return sb.toString();
    }
}