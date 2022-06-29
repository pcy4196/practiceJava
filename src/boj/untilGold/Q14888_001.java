package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14888_001 {

    // 백준(BOJ) SILVER1 연산자 끼워넣기
    // 문제 URL : https://www.acmicpc.net/problem/14888

    static int MAX = Integer.MIN_VALUE;     // 연산 최고값
    static int MIN = Integer.MAX_VALUE;     // 연산 최저값
    static int[] arr;
    static int[] op;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());       // 수의 개수
        arr = new int[N];                               // 숫자 모음
        op  = new int[4];                               // 사칙연산모음
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());  // 숫자를 배열에 초기화
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        DFS(1, arr[0], N); // 최초값으로 시작

        System.out.println(MAX);
        System.out.println(MIN);
    }

    private static void DFS(int L, int sum, int N) {
        if (L == N) {
            MAX = Math.max(MAX, sum);
            MIN = Math.min(MIN, sum);
        } else {
            for (int i = 0; i < 4; i++) {
                if (op[i] > 0) {
                    op[i]--;    // 사용한 연산자를 중복해서 사용하지 않게 하기 위해서 설정
                    if (i == 0) {
                        // 덧셈
                        DFS(L+1, sum + arr[L], N);
                    } else if (i == 1) {
                        // 뺄셈
                        DFS(L+1, sum - arr[L], N);
                    } else if (i == 2) {
                        // 곱셈
                        DFS(L+1, sum * arr[L], N);
                    } else if (i == 3) {
                        // 나눗셈
                        DFS(L+1, sum / arr[L], N);
                    }

                    op[i]++;    // 재귀함수가 끝나면 사용한 사칙연산 원산 복구
                }
            }
        }
    }
}
