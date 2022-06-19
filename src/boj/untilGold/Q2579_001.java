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
        int[] arr = new int[N];                         // 계단의 점수를 보관하는 배열
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

//        for (int i : arr) {
//            System.out.println(i);
//        }

    }
}
