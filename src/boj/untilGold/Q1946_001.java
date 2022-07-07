package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q1946_001 {

    // 백준(BOJ) SILVER1 신입사원
    // 문제 URL : https://www.acmicpc.net/problem/1946

    static class Score implements Comparable<Score> {
        int s;      // 서류
        int m;      // 면접

        public Score(int s, int m) {
            this.s = s;
            this.m = m;
        }

        // 오름차순 정렬
        @Override
        public int compareTo(Score score) {
            return this.m - score.m;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());               // 테스트 케이스의 개수
        ArrayList<ArrayList<Score>> list = new ArrayList<>();   // 테스트 케이스별 데이터를 담는 변수
        for (int i = 0; i < T; i++) {
            list.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                list.get(i).add(new Score(s, m));
            }
        }

        for (ArrayList<Score> scores : list) {
            System.out.println(solution(scores));
        }
    }

    // 각 테스트별 선발할 수 있는 신입사원의 최대 인원수
    private static int solution(ArrayList<Score> scores) {
        int answer = 1;

        if (scores.size() == 1) {
            return answer;
        }

        // 면접 성적 오름차순 정렬
        Collections.sort(scores);

        int rank = scores.get(0).s; // 합격, 불합격을 나누는 서류 등수(이전사람)

        for (int i = 1; i < scores.size(); i++) {
            if (rank > scores.get(i).s) {
                answer++;
                // rank 등수 재설정 - 뒤의 사람은 해당 등수보다 좋아야만 합격 가능
                rank = scores.get(i).s;
            }
        }

        return answer;
    }


}
