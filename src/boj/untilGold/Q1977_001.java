package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1977_001 {

    // 백준(BOJ) BRONZE1 완전제곱수
    // 문제 URL : https://www.acmicpc.net/problem/1977

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // M이상 N 이하의 자연수
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        System.out.println("M : " + M);
        System.out.println("N : " + N);

    }

}
