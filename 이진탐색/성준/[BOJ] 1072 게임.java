package studycodingtest.BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

    승률 : Z = 100Y/X
    추가 게임 : K = (Z+1)X - 100Y / 99 - Z
    but Z >= -1
*/
public class BOJ_Game {

    public static void main(String[] args) throws Exception {

        // 빠른 입력을 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // X, Y 입력 (게임 횟수, 이긴 게임 수)
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Long.parseLong(st.nextToken()); // 총 게임 횟수
        long Y = Long.parseLong(st.nextToken()); // 이긴 게임 수

        long Z = (100 * Y) / X;

        // 승률이 절대 변하지 않음
        if(Z >= 99){
            System.out.println("-1");
            return;
        }


        long official_1 = (Z + 1) * X - 100 * Y; // 분자
        long official_2 = 99 - Z; // 문모

        // 올림 나눗셈
        long k = (official_1 + official_2 -1) / official_2;

        System.out.println(k);
    }
}
