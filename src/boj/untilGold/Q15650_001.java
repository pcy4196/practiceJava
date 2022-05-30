package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15650_001 {

    // 백준(BOJ) SILVER3 N과 M(2)
    // 문제 URL : https://www.acmicpc.net/problem/15650

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // N 까지의 자연수(EX : 3 -> 1, 2, 3)
        int M = Integer.parseInt(st.nextToken());   // M 자리수

        int[] arr = new int[M];
        permutation(0, 1, arr, N, M);
    }

    // 백트래킹 METHOD(메서드)
    private static void permutation(int L, int start, int[] arr, int N, int M) {
        if (L == M) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        // 수열을 구하기 위한 for문
        for (int i = start; i <= N; i++) {
            arr[L] = i;
            permutation(L+1, i+1, arr, N, M);
        }
    }
}
