package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q14562_001 {

    // 백준(BOJ) SILVER2 태권왕
    // 문제 URL : https://www.acmicpc.net/problem/14562

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());       // 겨루기 수(테스트 케이스)
        Queue<Score> queue = null;                      // BFS 작업을 위한 stack
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());   // 태균 점수
            int t = Integer.parseInt(st.nextToken());   // 상대방 점수
            queue = new LinkedList<>();
            queue.add(new Score(s, t, 0));
            int answer = Integer.MAX_VALUE;                 // 출력 정답
            while (!queue.isEmpty()) {
                Score score = queue.poll();
                if (score.s == score.t) {                   // 태균과 상대방의 점수가 같을때
                    answer = Math.min(answer, score.n);
                    break;
                } else if (score.s < score.t){
                    // 태균의 점수가 작을 때 --> 태균의 점수가 클때는 진행 X(태균의 점수가 증가가 큰 폭이기 때문)
                    queue.add(new Score(score.s*2, score.t+3, score.n+1));
                    queue.add(new Score(score.s+1, score.t, score.n+1));
                }
            }
            System.out.println(answer);
        }

    }

    static class Score {
        int s;          // 태균 점수
        int t;          // 상대방 점수
        int n;          // 겨루기 횟수

        public Score(int s, int t, int n) {
            this.s = s;
            this.t = t;
            this.n = n;
        }
    }
}
