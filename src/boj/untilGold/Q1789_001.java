package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1789_001 {

    // 백준(BOJ) SILVER5 수들의 합
    // 문제 URL : https://www.acmicpc.net/problem/1789

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long S = Long.parseLong(st.nextToken());

        // 1~N 까지의 합이 S 보다 클 경우까지 더해주는 로직 구현
        long sum = 0;
        long N = 0;
        while (sum < S) {
            N++;
            sum += N;
        }

        // 1~N 까지의 합이 S랑 다른 경우 더했던 수 중에서
        // 한 수를 마이너스하기 때문에 N-1개룰 출력
        System.out.println(sum == S ? N : N - 1);
    }

}
