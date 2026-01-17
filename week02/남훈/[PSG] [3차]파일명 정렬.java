import java.util.*;

class Solution {
    public String[] solution(String[] files) {

        // 파일 정보 저장할 리스트
        // (HEAD, NUMBER, 원래 순서, 원본 파일명)
        List<FileInfo> list = new ArrayList<>();

        // 모든 파일명을 하나씩 검사
        for (int i = 0; i < files.length; i++) {
            String file = files[i];

            // HEAD 부분을 저장할 문자열
            String head = "";

            // NUMBER 부분을 저장할 문자열
            String number = "";

            // 문자열을 한 글자씩 검사하기 위한 인덱스
            int idx = 0;

            // HEAD 추출
            // 조건:
            // - 문자열 끝에 도달하지 않았고
            // - 현재 문자가 숫자가 아닐 때까지 반복
            //
            // 즉, 숫자가 나오기 전까지의 모든 문자는 HEAD
            while (idx < file.length() && !Character.isDigit(file.charAt(idx))) {
                head += file.charAt(idx); // 문자 하나씩 HEAD에 추가
                idx++;                    // 다음 문자로 이동
            }

            // NUMBER 추출
            // 조건:
            // - 문자열 끝에 도달하지 않았고
            // - 현재 문자가 숫자일 때만 반복
            //
            // 즉, 숫자가 연속되는 부분이 NUMBER
            while (idx < file.length() && Character.isDigit(file.charAt(idx))) {
                number += file.charAt(idx); // 숫자 하나씩 NUMBER에 추가
                idx++;                      // 다음 문자로 이동
            }

            // 정렬을 위한 정보 저장
            // head.toLowerCase()
            // → 대소문자 구분 없이 비교하기 위해 소문자로 변환
            //
            // Integer.parseInt(number)
            // → 문자열 숫자를 실제 숫자로 변환 (정확한 비교를 위해)
            //
            // i
            // → 입력된 원래 순서 (HEAD, NUMBER가 같을 때 필요)
            //
            // file
            // → 최종 결과로 다시 사용하기 위한 원본 파일명
            list.add(new FileInfo(
                    head.toLowerCase(),
                    Integer.parseInt(number),
                    i,
                    file
            ));
        }

        // 정렬 수행
        Collections.sort(list, new Comparator<FileInfo>() {
            @Override
            public int compare(FileInfo o1, FileInfo o2) {

                // 1. HEAD 비교
                // 문자열 비교 (사전 순)
                if (!o1.head.equals(o2.head)) {
                    return o1.head.compareTo(o2.head);
                }

                // 2. NUMBER 비교
                // 숫자 비교 (작은 숫자가 먼저)
                return o1.number - o2.number;

                // ※ HEAD와 NUMBER가 모두 같으면
                //    Collections.sort는 안정 정렬이므로
                //    원래 입력 순서가 자동으로 유지됨
            }
        });

        // 정렬된 결과를 배열로 변환
        String[] answer = new String[files.length];

        // 정렬된 FileInfo에서
        // 원래 파일명(original)만 꺼내서 결과 배열에 저장
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).original;
        }

        // 최종 결과 반환
        return answer;
    }
}