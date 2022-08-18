package inflearn.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q03_03_001 {

    // 인프런(inflearn) - 최대 매출
    // 문제 URL : https://cote.inflearn.com/contest/10/problem/03-03

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());           // N일 동안의 매출기록
        int K = Integer.parseInt(st.nextToken());           // 연속된 K일
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        // N일의 매출기록
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;        // 합 최대값
        int sum = 0;        // 합을 저장하는 변수
        // 1. k까지의 합
        for (int i = 0; i < K; i++) {
            sum += arr[i];
        }
        max = Math.max(max, sum);
        // 2. N일까지 진행
        for (int i = K; i < N; i++) {
            sum = sum + arr[i] - arr[i-K];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
