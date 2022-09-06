package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2293_001 {

    // 백준(BOJ) GOLD5 동전 1
    // 문제 URL : https://www.acmicpc.net/problem/2293

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());                   // n가지 종류의 동전
        int k = Integer.parseInt(st.nextToken());                   // 목표 k원
        int[] coin = new int[n+1];
        int[] dp = new int[k+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            coin[i] = Integer.parseInt(st.nextToken());             // 동전 초기화
        }

        // 최초값을 설정하기 위한 dp 값 설정
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = coin[i]; j <= k; j++) {
                dp[j] += dp[j - coin[i]];
            }
        }

        System.out.println(dp[k]);
    }

}
