package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2493_002 {

    // 백준(BOJ) GOLD5 탑 - 2
    // 문제 URL : https://www.acmicpc.net/problem/2493

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] heights = new int[N + 1];
        int[] answer = new int[N + 1];
        heights[0] = Integer.MAX_VALUE;

        // 탑의 높이 값 대입
        for (int i = 1; i <= N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            if (heights[i] <= heights[i - 1]) {
                answer[i] = i - 1;
            } else {
                // 기준이 되는 등대가 앞의 등대보다 크다면
                int j = i - 1;
                // 앞의 값이 큰 등대가 나올때까지 while문 진행
                while (heights[i] > heights[j]) {
                    j = answer[j];
                }
                // 구해진 위치의 레이저 신호값을 answer에 대입
                answer[i] = j;
            }

            sb.append(answer[i]).append(' ');
        }

        System.out.println(sb);
        br.close();
    }
}
