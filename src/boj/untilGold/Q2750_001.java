package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2750_001 {

    // 백준(BOJ) BRONZE1 수 정렬하기
    // 문제 URL : https://www.acmicpc.net/problem/2750

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // N개의 숫자
        int[] arr = new int[N];                     // 정렬할 수를 담는 배열 선언
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(arr);
        // 예제출력
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
