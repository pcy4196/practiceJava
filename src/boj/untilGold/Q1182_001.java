package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1182_001 {

    // 백준(BOJ) SILVER2 부분수열의 합
    // 문제 URL : https://www.acmicpc.net/problem/1182

    static int[] num;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());       // 정수의 개수를 나타내는 N
        int S = Integer.parseInt(st.nextToken());       // 정수 S
        num = new int[N];                               // num 변수 초기화
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0, N, S);

        if (S == 0) answer--;   
        // 부분수열중에 공집합(아무것도 선택 X)도 가능하기 때문에 -1 필요(답이 0일 경우만)
        System.out.println(answer);
    }

    private static void dfs(int depth, int sum, int N, int S) {
        if (depth == N) {
            if (sum == S) {
                answer++;
            }
        } else {
            // num 숫자를 더하여 재귀함수 호출(깊이+1)
            dfs(depth + 1, sum + num[depth], N, S);
            // num 숫자를 더하지 않고 재귀함수 호출(깊이+1)
            dfs(depth + 1, sum, N, S);
        }
    }
}
