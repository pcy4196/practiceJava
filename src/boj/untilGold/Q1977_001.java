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

        // 완전제곱수가 합을 담는 변수
        int sum = 0;
        // 자연수 최대값 10000 이므로 초기값 10001 으로 초기화
        int minNum = 10001;

        for (int i = M; i <= N; i++) {
            // 해당 숫자 완전제곱수인지 판단
            if (Math.sqrt(i) % 1 == 0) {
                sum += i;
                if (minNum > i) {
                    minNum = i;
                }
            }
        }

        // 정답 출력
        System.out.println(sum == 0 ? -1 : sum);
        if (minNum != 10001) {
            System.out.println(minNum);
        }
    }

}
