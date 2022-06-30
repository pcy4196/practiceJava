package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7576_001 {

    // 백준(BOJ) GOLD5 토마토
    // 문제 URL : https://www.acmicpc.net/problem/7576

    static int[] x = {1, 0, -1, 0};    // 가로 움직임
    static int[] y = {0, 1, 0, -1};    // 세로 움직임

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());           // M 가로 칸의 수(행)
        int N = Integer.parseInt(st.nextToken());           // N 세로 칸의 수(열)
        int[][] arr = new int[N][M];                        // 토마토 상자
        int[][] cos = new int[N][M];                        // 토마토 익는데 소요되는 날짜
        Queue<Pos> queue = new LinkedList<>();              // BFS 처리하는 queue 선언
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());   // 토마토 값 대입
                if (arr[i][j] == 1) { // 익은 토마토로 시작할 수 있게 queue에 추가
                    queue.add(new Pos(i, j));
                }
            }
        }

        // BFS 처리
        while (!queue.isEmpty()) {
            // 토마토 위치
            Pos tmto = queue.poll();
            for (int i = 0; i < 4; i++) {
                int mx = tmto.m + x[i];
                int ny = tmto.n + y[i];
                if (mx >= 0 && ny >= 0 && mx < N && ny < M && arr[mx][ny] == 0) {
                    arr[mx][ny] = 1;
                    cos[mx][ny] = cos[tmto.m][tmto.n] + 1;
                    queue.add(new Pos(mx, ny));
                }
            }
        }
        // 정답출력
        System.out.println(printAnswer(arr, cos, M, N));
    }

    private static int printAnswer(int[][] arr, int[][] cos, int M, int N) {
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    // 익지 않는 토마토가 발생하면 -1 반환
                    return -1;
                } else {
                    answer = Math.max(answer, cos[i][j]);
                }
            }
        }
        return answer;
    }

    static class Pos {
        int m;      // 가로 좌표
        int n;      // 세로 좌표

        public Pos(int m, int n) {
            this.m = m;
            this.n = n;
        }
    }
}
