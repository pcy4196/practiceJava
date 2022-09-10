package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
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
    static boolean combYn = false;  // 연합여부
    static Queue<Con> queue;    // BFS 진행
    static ArrayList<Con> list; // 연합할 나라를 담는 List
    static int[] dx = { 0, 1, 0, -1 }; // BFS 이동 메서드
    static int[] dy = { 1, 0, -1, 0 }; // 동 남 서 북

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
        // 3. 1~2 반복 --> 반복시 인구이동할 국가가 없으면 반복 종료

        // 정답 출력 변수
        int result = 0;

        do {
            // 방문여부 변수 초기화
            visited = new int[N][N];
            combYn = false;
            // 연합발생여부 확인(하루)
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] == 0) {
                        // 1. 연합국가 탐색(BFS)
                        int sum = BFS(i, j);
                        // 2. 인구 이동
                        if (list.size() > 1) {
                            movePeopl(sum);
                            combYn = true;
                        }
                    }
                }
            }
            if (combYn) {
                result++;
            }
        } while (combYn);

        System.out.println(result);
    }

    // 인구이동 발생
    private static void movePeopl(int sum) {
        int newNum = sum / list.size();
        for (int i = 0; i < list.size(); i++) {
            con[list.get(i).x][list.get(i).y] = newNum;
        }
    }

    private static int BFS(int i, int j) {
        // 1-1. 탐색 시 연합국가별 인구합계 및 인구이동할 국가 체크(ArraysList 사용)
        list = new ArrayList<>();
        list.add(new Con(i, j));
        queue = new LinkedList<>();
        queue.add(new Con(i, j));
        visited[i][j] = 1;
        int sum = con[i][j];

        while (!queue.isEmpty()) {
            Con c = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = c.x + dx[k];
                int ny = c.y + dy[k];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    int diff = Math.abs(con[c.x][c.y] - con[nx][ny]);
                    if (diff >= L && diff <= R && visited[nx][ny] == 0) {
                        visited[nx][ny] = 1;        // 해당 나라 방문여부 변경
                        queue.add(new Con(nx, ny));
                        list.add(new Con(nx, ny));
                        sum += con[nx][ny];
                    }
                }
            }
        }


        return sum;
    }

}
