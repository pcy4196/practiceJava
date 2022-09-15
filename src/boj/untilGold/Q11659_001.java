package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11659_001 {

    // 백준(BOJ) SILVER3 구간 합 구하기 4
    // 문제 URL : https://www.acmicpc.net/problem/16235
    static int N;               // N개의 수
    static int M;               // M개 구간의 합
    static int[] sum;           // 구간 수의 합을 저장하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 0. 데이터 입력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sum = new int[N+1];     // 구해야 하는 구간값의 인덱스가 '1'부터 시작이라 N+1로 선언

        // 1. 배열에 차례대로 합을 저장
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
        }

        // 2. 구간별로 합을 출력
        // - 속도를 좀 더 개선하기 위해 StringBuilder 사용 -
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());   // 시작구간
            int j = Integer.parseInt(st.nextToken());   // 마지막구간
            sb.append(sum[j] - sum[i - 1]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
