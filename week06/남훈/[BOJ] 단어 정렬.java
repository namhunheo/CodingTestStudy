package week06.남훈;

import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 단어 개수 입력받기
        int N = Integer.parseInt(sc.nextLine());

        // 단어들을 정렬하기 위해 List에 저장
        // 이 때, 중복되는 단어는 제외
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String word = sc.nextLine();
            if (!set.contains(word)) {
                set.add(word);
                list.add(word);
            }
        }

        // 단어를 저장한 리스트 정렬
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {

                // 길이 같으면 사전순
                if (s1.length() == s2.length()) {
                    for (int i = 0; i < s1.length(); i++) {
                        if (s1.charAt(i) != s2.charAt(i)) {
                            return s1.charAt(i) - s2.charAt(i);
                        }
                    }
                }

                // 길이 기준 오름차순
                return s1.length() - s2.length();
            }
        });

        // 정답 출력
        for (String str : list) {
            System.out.println(str);
        }
    }
}