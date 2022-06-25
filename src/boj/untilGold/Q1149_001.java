package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1149_001 {

    // 백준(BOJ) SILVER1 RGB거리
    // 문제 URL : https://www.acmicpc.net/problem/1149

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());       // 페인트 칠할 집의 수
        int[][] arr = new int[N][3];                    // 페인트 칠하는 비용(0-빨, 1-그, 2-파)
        int[][] dy = new int[N][3];                     // 최소비용을 가지는 있는 변수(0-빨, 1-그, 2-파)

        // 페인트 칠하는 비용 설정
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        // 최초의 집 최소비용 설정
        dy[0][0] = arr[0][0];
        dy[0][1] = arr[0][1];
        dy[0][2] = arr[0][2];

        // 최소 비용 설정
        for (int i = 1; i < N; i++) {
            dy[i][0] = Math.min(dy[i-1][1], dy[i-1][2]) + arr[i][0];
            dy[i][1] = Math.min(dy[i-1][0], dy[i-1][2]) + arr[i][1];
            dy[i][2] = Math.min(dy[i-1][0], dy[i-1][1]) + arr[i][2];
        }

        // 정답 출력
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            answer = Math.min(dy[N-1][i], answer);
        }
        System.out.println(answer);
    }
}
