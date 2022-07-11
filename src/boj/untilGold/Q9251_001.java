package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9251_001 {

    // 백준(BOJ) GOLD5 LCS
    // 문제 URL : https://www.acmicpc.net/problem/9251

    static char[] str1;
    static char[] str2;
    static Integer[][] lcsArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1 = br.readLine().toCharArray();    // 첫번째 문자열
        str2 = br.readLine().toCharArray();    // 두번째 문자열

        // 메모이제이션을 사용하기 위해서 Integer로 선언
        lcsArr = new Integer[str1.length][str2.length];

        // 최장 공통 부분 수열의 가장 큰 값(행,열 마지막 값)
        System.out.println(lcs(str1.length - 1, str2.length - 1));
    }

    // 해당 행,열에서 부분 수열 값 구하는 메서드
    private static int lcs(int x, int y) {
        // 해당 lcsArr 배열에서 만들수없는 좌표일 경우 '0' 리턴
        if (x < 0 || y < 0) {
            return 0;
        }

        if (lcsArr[x][y] == null) {
            if (str1[x] == str2[y]) {
                lcsArr[x][y] = lcs(x-1, y-1) + 1;
            } else {
                lcsArr[x][y] = Math.max(lcs(x-1, y), lcs(x, y-1));
            }
        }

        return lcsArr[x][y];
    }

}
