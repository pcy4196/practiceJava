package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15649_002 {

    // 백준(BOJ) SILVER3 N과 M(1)
    // 문제 URL : https://www.acmicpc.net/problem/15649

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // N 까지의 자연수(EX : 3 -> 1, 2, 3)
        int M = Integer.parseInt(st.nextToken());   // M 자리수

        int[] arr = new int[M];
        visited = new boolean[N+1]; // 1 부터 시작이므로 초기화 할때 N+1 설정
        permutation(0, arr, N, M);
    }

    // 백트래킹 METHOD(메서드)
    private static void permutation(int L, int[] arr, int N, int M) {
        if (L == M) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        } else {
            for (int i = 1; i <= N; i++) {
                // 중복 제외하기 위해 visited 변수에 사용하지 않은 값인지 CHECK
                if (!visited[i]) {
                    visited[i] = true;
                    arr[L] = i;
                    permutation(L+1, arr, N, M);
                    visited[i] = false;
                }
            }
        }
    }
}
