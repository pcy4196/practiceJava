package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1072_001 {

    // 백준(BOJ) SILVER3 게임
    // 문제 URL : https://www.acmicpc.net/problem/1072

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());   // 게임 횟수
        int Y = Integer.parseInt(st.nextToken());   // 이긴 게임
        int Z = getPcnt(X, Y);

        // 최소 변화값을 찾기 위한 이분탐색 로직 구현
        int start = 0;
        int end   = X;          // 최대값을 이전 게임횟수로 설정
        int answer = -1;        // 출력값을 나타내는 변수(Z값이 변경하지 않을
                                // 경우 -1을 반환하기 위해 -1를 초기화)
        while (start <= end) {
            int mid = (start + end) / 2;
            if (getPcnt(X + mid, Y + mid) != Z) { // 새로운 승률 산출
                // answer = answer != -1 ? Math.min(answer, mid) : mid;
                // mid 값이 가장 작은 값이기 때문에 해당 로직 수행 X
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(answer);
    }

    // 이긴 확률 퍼센트 구하는 공식
    private static int getPcnt(int X, int Y) {
        return (int) ((double) Y * 100 / (double) X);
    }

}
