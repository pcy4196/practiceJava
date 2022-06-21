package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q14562_002 {

    // 백준(BOJ) SILVER2 태권왕 - DFS
    // 문제 URL : https://www.acmicpc.net/problem/14562

    static class Score {
        int s;          // 태균 점수
        int t;          // 상대방 점수

        public Score(int s, int t) {
            this.s = s;
            this.t = t;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());       // 겨루기 수(테스트 케이스)
        ArrayList<Score> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            list.add(new Score(s, t));                  // 겨루기 최초 점수 세팅
        }

        for (Score score : list) {
            System.out.println(DFS(score.s, score.t, 0));
        }

    }

    // 발차기 횟수를 구하는 DFS 메서드
    private static int DFS(int s, int t, int cnt) {
        if (s > t) {
            // s값(태균점수)이 t(상대방)값보다 증가폭이 크기
            // 때문에 최고 큰값을 반환하여 재귀함수 종료 처리
            return Integer.MAX_VALUE;
        } else {
            if (s == t) {
                return cnt;
            } else {
                int min1 = DFS(s * 2, t + 3, cnt + 1);
                int min2 = DFS(s + 1, t, cnt + 1);
                return Math.min(min1, min2);
            }
        }
    }

}
