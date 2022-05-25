package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1260_001 {

    // 백준(BOJ) SILVER2 DFS와 BFS
    // 문제 URL : https://www.acmicpc.net/problem/1260

    static int[][] graph;
    static int[] visited;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 정점의 개수
        int M = Integer.parseInt(st.nextToken());   // 간선의 개수
        int V = Integer.parseInt(st.nextToken());   // 시작할 정점의 값

        graph = new int[N+1][N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        // DFS 알고리즘 수행
        visited = new int[N+1];
        visited[V] = 1;
        dfs(V, 0, N);

        System.out.println(); //줄바꿈

        // BFS 알고리즘 수행
        queue = new LinkedList<>();
        queue.add(V);
        Arrays.fill(visited, 0);
        visited[V] = 1;
        System.out.print(V + " ");
        bfs(N);
    }

    // dfs 알고리즘 수행
    private static void dfs(int V, int i, int N) {
        if (i == N) {
            return;
        } else {
            System.out.print(V + " ");
            for (int j = 1; j <= N; j++) {
                if (graph[V][j] == 1 && visited[j] != 1) {
                    // 방문 설정 및 dfs 메서드 호출
                    visited[j] = 1;
                    dfs(j, i++, N);
                }
            }
        }
    }

    // bfs 알고리즘 수행(Queue 사용)
    private static void bfs(int N) {
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i = 1; i <= N; i++) {
                if (graph[node][i] == 1 && visited[i] != 1) {
                    queue.add(i);
                    visited[i] = 1;
                    System.out.print(i + " ");
                }
            }
        }
    }

}
