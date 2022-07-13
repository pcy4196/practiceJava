package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14501_001 {

    // 백준(BOJ) SILVER3 퇴사
    // 문제 URL : https://www.acmicpc.net/problem/14501

    static int N;
    static class Work {
        int t;
        int p;

        public Work(int t, int p) {
            this.t = t;
            this.p = p;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());       // 남은 기간

    }
}
