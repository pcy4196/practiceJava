package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q2606_001 {

    // 백준(BOJ) SILVER3 바이러스
    // 문제 URL : https://www.acmicpc.net/problem/2606

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());       // 컴퓨터의 수
        int M = Integer.parseInt(st.nextToken());       // 컴퓨터 쌍의 수
        int[] visited = new int[N+1];                   // visited 배열 선언(접근기록)
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {                   // 인접리스트 선언
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {                   // 연결 초기화
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

    }

}
