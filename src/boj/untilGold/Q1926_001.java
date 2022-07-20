package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1926_001 {

    // 백준(BOJ) SILVER1 그림
    // 문제 URL : https://www.acmicpc.net/problem/1926

    // BFS 이동
    static int[] x = {1, 0, -1,  0};
    static int[] y = {0, 1,  0, -1};

    static class Node {
        int n;
        int m;

        public Node(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }

    static int cnt;     // 그림의 수를 출력하는 변수
    static int size;    // 그림의 크기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());           // 가로 크기(행)
        int m = Integer.parseInt(st.nextToken());           // 세로 크기(열)
        int[][] arr = new int[n][m];                        // 도화지 정보
        int[][] visited = new int[n][m];                    // 방문여부 담는 변수
        cnt  = 0;       // 그림의 수를 출력하는 변수
        size = 0;       // 그림의 크기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        BFS(n, m, arr, visited);

        // 정답 출력
        System.out.println(cnt);
        System.out.println(size);
    }

    private static void BFS(int n, int m, int[][] arr, int[][] visited) {
        Queue<Node> queue = new LinkedList<>(); // BFS 수행하는 queue 변수
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && visited[i][j] == 0) {
                    visited[i][j] = 1;
                    cnt++;                  // 그림의 갯수를 높이는 작업
                    int tmpSize = 0;        // 그림의 크기를 담는 변수
                    queue.add(new Node(i, j));
                    while (!queue.isEmpty()) {
                        Node node = queue.poll();
                        tmpSize++;
                        for (int k = 0; k < 4; k++) {
                            int nx = node.n + x[k];
                            int my = node.m + y[k];
                            if (nx >= 0 && my >= 0 && nx < n && my < m
                            && arr[nx][my] == 1 && visited[nx][my] == 0) {
                                visited[nx][my] = 1;
                                queue.add(new Node(nx, my));
                            }
                        }
                    }
                    size = Math.max(tmpSize, size);
                }
            }
        }
    }

}
