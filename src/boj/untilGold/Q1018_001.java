package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1018_001 {

    // 백준(BOJ) SILVER4 체스판 다시 칠하기
    // 문제 URL : https://www.acmicpc.net/problem/1018

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());                   // 체스 가로 길이
        int N = Integer.parseInt(st.nextToken());                   // 체스 세로 길이
        String[] str = new String[M];
        String[] chk = {"WBWBWBWB","BWBWBWBW"};                     // 체스판 체크 배열
        for (int i = 0; i < M; i++) {
            str[i] = br.readLine();                                 // 칠하기전 체스판
        }

        int ans = 64;                                               // 체스판 최대로 칠하는 횟수
        for (int i = 0; i < M - 7; i++) {
            for (int j = 0; j < N - 7; j++) {
                ans = Math.min(ans, chkChess(i, j, str, chk));
            }
        }

        System.out.println(ans);
    }

    // 체스판 색칠하는 횟수를 판단하는 메서드
    private static int chkChess(int i, int j, String[] str, String[] chk) {
        int modCnt = 0;
        int i3 = 0;
        for (int i1 = i; i1 < i + 8; i1++) {
            String s = str[i1];
            String c = chk[i1 % 2];
            // 체크하는 값은 0부터 시작이기때문에 i3 값 재설정
            for (int i2 = j; i2 < j + 8; i2++) {
                if (s.charAt(i2) != c.charAt(i3)) modCnt++;
                i3++;
            }
            i3 = 0;
        }

        // white로 시작하는 경우와 black으로 시작하는 경우둘다 존재하기 때문에
        // 값 리턴하기 전에 작은값 구해서 전달
        return Math.min(modCnt, 64 - modCnt);
    }
}
