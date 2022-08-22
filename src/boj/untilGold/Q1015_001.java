package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1015_001 {

    // 백준(BOJ) SILVER4 수열 정렬
    // 문제 URL : https://www.acmicpc.net/problem/1015

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());       // 배열의 크기
        int[] P = new int[N];                           // 비내림차순을 만드는 배열 선언
        // 배열 A 원소의 정보를 담는 Class 선언
        Elem[] elem = new Elem[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            elem[i] = new Elem(Integer.parseInt(st.nextToken()), i);
        }

        // 정렬 처리(비내림차순)
        Arrays.sort(elem, (o1, o2) ->
            o1.num != o2.num ? o1.num - o2.num : o1.idx - o2.idx
        );

//        Arrays.stream(elem).forEach(e -> System.out.println(e.num));
        // 수열 P값 대입(정렬한 elem 배열의 인덱스) & 출력값 설정
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            P[elem[i].idx] = i;
        }

        Arrays.stream(P).forEach(p -> sb.append(p).append(" "));

        System.out.println(sb.toString());
    }

    // 배열 A 인자 값 정보를 담는 Class
    static class Elem {
        int num;
        int idx;

        public Elem(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }
}
