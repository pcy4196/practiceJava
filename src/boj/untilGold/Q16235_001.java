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
    static int[][] floor;           // 양분이 포함된 땅
    static int[] dx = {-1, 0, 1, 0, 1, 1, -1, -1};  // 8방향 이동
    static int[] dy = {0, -1, 0, 1, 1, -1, 1, -1};
    static Queue<Elem> trees;   // 살아있는 나무
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
        floor = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                yangBuns[i][j] = Integer.parseInt(st.nextToken());
                floor[i][j] = 5;
            }
        }
        // 살아있는 나무 담는 우선순위 큐 선언
        trees = new LinkedList<>();
        // 죽은 나무 정보를 담는 큐 선언
        deadTrees = new LinkedList<>();
        // 나무 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            // 배열이 0부터 시작하여 주어진값에서 -1 처리
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken());
            trees.add(new Elem(r, c, y));
        }

        // 정답 출력
        System.out.println(solve());
    }

    // 나무 재테크
    private static int solve() {
        // k년 동안 반복 수행
        for (int i = 0; i < K; i++) {
            // 1. 봄 : 양분 소요 혹은 죽은 나무 밣생
            int size = trees.size();
            for (int j = 0; j < size; j++) {
                Elem tree = trees.poll();
                if (floor[tree.r][tree.c] >= tree.y) {
                    floor[tree.r][tree.c] -= tree.y;
                    int y = tree.y + 1;
                    trees.add(new Elem(tree.r, tree.c, y));
                } else {
                    deadTrees.add(new Elem(tree.r, tree.c, tree.y));
                }
            }

            // 2. 여름 : 죽은 나무의 2분의 1나이만큼 양분 추가
            while (!deadTrees.isEmpty()) {
                Elem tree = deadTrees.poll();
                floor[tree.r][tree.c] += tree.y / 2;
            }

            // 3. 가을 : 나무 번식
            Queue<Elem> tmpTrees = new LinkedList<>();
            size = trees.size();
            for (int j = 0; j < size; j++) {
                Elem tree = trees.poll();
                if (tree.y % 5 == 0) {
                    for (int k = 0; k < 8; k++) {
                        int nx = tree.r + dx[k];
                        int ny = tree.c + dy[k];
                        if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                            tmpTrees.add(new Elem(nx, ny, 1));
                        }
                    }
                }
                trees.add(tree);
            }

            tmpTrees.addAll(trees);
            // trees 큐로 원복
            trees = tmpTrees;

            // 4. 겨울 : 양분공급
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    floor[j][k] += yangBuns[j][k];
                }
            }
        }

        return trees.size();
    }
}
