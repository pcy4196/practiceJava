package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1072_002 {

    // 백준(BOJ) SILVER3 게임 -- 2(수식을 사용해서 처리)
    // 문제 URL : https://www.acmicpc.net/problem/1072

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());   // 게임 횟수
        int Y = Integer.parseInt(st.nextToken());   // 이긴 게임
        int Z = getPcnt(X, Y);

        int answer = -1;

        // 1) Z + 1 = Y + answer / X + answer * 100
        // 2) ( Z + 1 ) * ( X + answer ) = 100Y + 100answer
        // 3) ( ZX + Zanswer + X + answer ) = 100Y + 100answer
        // 4) Zanswer - 99answer = 100Y - ZX  - X
        // 5) answer = (100Y - (Z+1)X) / (Z - 99)

        // 기존 승률이 99 미만일 경우에만 해당 로직 수행 가능
        if (Z < 99) {
            double upNum = 100 * Y - (Z + 1) * X;
            double dwnNUm = Z - 99;
            double div = upNum / dwnNUm;

            if (upNum % dwnNUm == 0) {
                answer = (int) div;
            } else {
                answer = (int) (div + 1);
            }
        }

        System.out.println(answer);
    }

    // 이긴 확률 퍼센트 구하는 공식
    private static int getPcnt(int X, int Y) {
        return (int) ((double) Y * 100 / (double) X);
    }

}
