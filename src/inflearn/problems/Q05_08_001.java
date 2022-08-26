package inflearn.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q05_08_001 {

    // 인프런(inflearn) - 응급실
    // 문제 URL : https://cote.inflearn.com/contest/10/problem/05-08

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());           // N명의 환자
        int M = Integer.parseInt(st.nextToken());           // M번째 환자
        Queue<Elem> queue = new LinkedList<>();
        // 환자 정보 queue에 세팅
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            queue.add(new Elem(Integer.parseInt(st.nextToken()), i));
        }
        int answer = 0;
        while (true) {
            Elem elem = queue.poll();
            if (elem.num > queue.peek().num) {
                answer++;
                if (elem.idx == M) {
                    break;
                }
            } else {
                queue.add(elem);
            }
        }

        System.out.println(answer);
    }

    // 환자의 정보를 가지는 클래스
    static class Elem {
        private int num;
        private int idx;

        public Elem(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }

}
