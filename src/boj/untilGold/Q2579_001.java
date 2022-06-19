package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2579_001 {

    // 백준(BOJ) SILVER3 계단 오르기
    // 문제 URL : https://www.acmicpc.net/problem/2579

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());       // 계단의 개수
        int[] arr = new int[N+1];                       // 계단의 점수를 보관하는 배열
        int[] dy  = new int[N+1];                       // 해당 계단까지의 최대 점수(Memoization)
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dy[1] = arr[1];             // 첫번째 계단
        // N 이 1이 입력될 수도 있기 때문에 예외처리를 해줄 필요가 있다.
        if (N >= 2) {
            dy[2] = arr[1] + arr[2];    // 두번째 계단
        }
        for (int i = 3; i <= N; i++) {
            // 두칸전(i - 2)의 'Memoization'값
            // 한칸전(i - 1)의 값 + 세칸전(i - 3)의 'Memoization' 값 중 큰 값
            dy[i] = arr[i] + Math.max(dy[i-2], dy[i-3] + arr[i-1]);
        }

        System.out.println(dy[N]);
    }
}
