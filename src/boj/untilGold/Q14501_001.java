package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14501_001 {

    // 백준(BOJ) SILVER3 퇴사
    // 문제 URL : https://www.acmicpc.net/problem/14501

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());       // 남은 기간
        int[][] workArr = new int[N+1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            workArr[i][0] = Integer.parseInt(st.nextToken());       // 상담 소요시간
            workArr[i][1] = Integer.parseInt(st.nextToken());       // 상담 수입
        }

        //현재 날짜에서 소요 시간과 비용을 더해 dp에 저장
        int[] dp = new int[N+2];
        for (int i = 1; i <= N; i++) {
            if (i + workArr[i][0] <= N + 1) {
                dp[i + workArr[i][0]] = Math.max(dp[i] + workArr[i][1], dp[i + workArr[i][0]]) ;
            }
            //현재 경우의 수가 0일 수 있기 때문에 이전의 최대값을 넣어줌.
            //해당 날짜에 일할 수 없다면, 이전까지 일한 최대 수당을 설정
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }

        System.out.println(dp[N+1]);
    }
}
