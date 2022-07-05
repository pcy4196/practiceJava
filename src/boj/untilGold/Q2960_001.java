package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2960_001 {

    // 백준(BOJ) SILVER4 에라토스테네스의 체
    // 문제 URL : https://www.acmicpc.net/problem/2960

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());           // N 까지의 수
        int K = Integer.parseInt(st.nextToken());           // K 번째 지워진 수
        int[] arr = new int[N+1];                           // 해당 숫자를 지운 기록을 나타내는 배열

        System.out.println(isPrime(N, K, arr));
    }

    // 소수를 판단하는 메서드
    private static int isPrime(int N, int K, int[] arr) {
        int cnt = 0;
        for (int i = 2; i <= N; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
                cnt++;
                if (cnt == K) {
                    return i;
                }
                for (int j = i * 2; j <= N; j = j + i) {
                    if (arr[j] == 0) {
                        arr[j] = 1;
                        cnt++;
                        if (cnt == K) {
                            return j;
                        }
                    }
                }
            }
        }
        return N;
    }
}
