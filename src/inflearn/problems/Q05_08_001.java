package inflearn.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        ArrayList<Elem> list = new ArrayList<>();
        // 환자 정보 queue에 세팅
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(new Elem(Integer.parseInt(st.nextToken()), i));
        }
        int answer = 0;
        while (true) {
            Elem elem = list.get(0);
            int max = 0;
            // 나머지 환자의 위험도 측정
            for (int i = 1; i < list.size(); i++) {
                max = Math.max(max, list.get(i).num);
            }
            if (elem.num >= max) {
                // 위험도가 높을 경우에만 진료
                answer++;
                if (elem.idx == M) {
                    break;
                }
            } else {
                list.add(elem);
            }
            list.remove(0);
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
