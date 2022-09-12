package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q16235_001 {

    // 백준(BOJ) GOLD3 나무 재테크
    // 문제 URL : https://www.acmicpc.net/problem/16235
    static int N;                   // N 크기의 땅
    static int M;                   // M 개의 나무
    static int K;                   // 정답을 구할 년도
    static int[][] yangBuns;        // 로봇이 제공하는 양분
    static int[] dx = {-1, 0, 1, 0, 1, 1, -1, -1};  // 8방향 이동
    static int[] dy = {0, -1, 0, 1, 1, -1, 1, -1};
    static PriorityQueue<Elem> trees;   // 살아있는 나무
    static Queue<Elem> deadTrees;       // 죽은 나무

    static class Elem {
        int r;
        int c;
        int y;      // 나이

        public Elem(int r, int c, int y) {
            this.r = r;
            this.c = c;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Elem{" +
                    "r=" + r +
                    ", c=" + c +
                    ", y=" + y +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 0. 데이터 입력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        // 양분 정보 입력
        yangBuns = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                yangBuns[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 살아있는 나무 담는 우선순위 큐 선언
        trees = new PriorityQueue<>((i1, i2) -> i1.r - i2.r);
        // 죽은 나무 정보를 담는 큐 선언
        deadTrees = new LinkedList<>();
        // 나무 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            trees.add(new Elem(r, c, y));
        }

        // 입력값 출력
        for (int[] yangBun : yangBuns) {
            System.out.println(Arrays.toString(yangBun));
        }
        for (Elem tree : trees) {
            System.out.println(tree);
        }
        // 정답 출력
        // System.out.println(solve());
    }

    // 나무 재테크
    private static int solve() {
        // 1. 봄

        // 2. 여름

        // 3. 가을

        // 4. 겨울

        return trees.size();
    }
}
