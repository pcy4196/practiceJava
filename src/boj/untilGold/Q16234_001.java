package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q16234_001 {

    // 백준(BOJ) GOLD5 인구 이동
    // 문제 URL : https://www.acmicpc.net/problem/16234
    static int N;
    static int L;
    static int R;
    static int[][] con;         // 인구수를 담는 배열변수
    static int[][] visited;     // 나라 방문여부
    static Queue<Con> queue;    // BFS 진행
    static ArrayList<Con> list; // 연합할 나라를 담는 List

    // 각나라의 위치를 담는 class 변수 선언
    static class Con {
        int x;      // 가로좌표
        int y;      // 세로좌표

        public Con(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());                   // N * N 크기의 땅
        L = Integer.parseInt(st.nextToken());                   // 인구차이 최소
        R = Integer.parseInt(st.nextToken());                   // 인구차이 최대
        con = new int[N][N];
        // 인구수 초기 설정
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                con[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 문제 구현 생각
        // 1. 연합국가 탐색(BFS)
        // 1-1. 탐색 시 연합국가별 인구합계 및 인구이동할 국가 체크(ArraysList 사용)
        // 2. 인구 이동
        // 3. 1~2 반복 --> 반복시 인구이도할 국가가 없으면 반복 종료

        do {
            // 방문여부 변수 초기화
            visited = new int[N][N];
            int sum = BFS(0, 0);
            if (list.size() > 0) {
                // 2. 인구 이동
                // movePeopl(sum);
            }
        } while (list.size() > 0);

    }

    private static int BFS(int i, int j) {
        // 1-1. 탐색 시 연합국가별 인구합계 및 인구이동할 국가 체크(ArraysList 사용)
        int sum = 0;
        queue.add(new Con(i, j));
        while (!queue.isEmpty()) {
            Con con = queue.poll();

        }


        return sum;
    }

}
