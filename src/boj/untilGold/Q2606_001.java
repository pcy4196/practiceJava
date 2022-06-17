package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2606_001 {

    // 백준(BOJ) SILVER3 바이러스
    // 문제 URL : https://www.acmicpc.net/problem/2606

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());       // 컴퓨터의 수
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());       // 컴퓨터 쌍의 수
        int[] visited = new int[N+1];                   // visited 배열 선언(접근기록)
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {                   // 인접리스트 선언(초기화)
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {                   // 연결 초기화
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        queue.add(1);               // 최초 시작 컴퓨터 1
        visited[1] = 1;             // visited 배열변수에 값 대입
        while (!queue.isEmpty()) {  // queue에 값이 없을 때 까지 while 문 진행
            int com = queue.poll(); // queue에서 값 추출
            for (Integer endCom : graph.get(com)) {
                if (visited[endCom] != 1) {
                    visited[endCom] = 1;
                    queue.add(endCom);
                }
            }
        }

        int answer = 0;                 // 감염 컴퓨터 수(1에서부터 시작)
        for (int i = 2; i <= N; i++) {  
            if (visited[i] == 1) {      // visited 배열에 값이 '1'이면 1에서 연결된 노드(컴퓨터)를 나타냄 
                answer++;
            }
        }

        // 정답출력
        System.out.println(answer);
    }

}
