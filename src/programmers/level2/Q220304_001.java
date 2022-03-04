package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Q220304_001 {

    // 프로그래머스 LEVEL2 카카오 프렌즈 컬러링북 - 2
    // 문제 URL : https://programmers.co.kr/learn/courses/30/lessons/1829

    // BFS(Breadth-First Search)[너비우선탐색]로 풀이하는 문제
    int[] dx = {1,0,-1, 0};
    int[] dy = {0,1, 0,-1};     // 상하좌우로 탐색할 수 있게 설정
    boolean[][] visited = null; // 해당 영역 방문 여부 체크
    int m, n;

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;               // 영역 변수(종료)
        int maxSizeOfOneArea = 0;           // 가장 큰 영역 담는 변수
        this.visited = new boolean[m][n];   // visited 변수 초기화 선언
        this.m = m;
        this.n = n;

        // m -> 그림영역 행, n -> 그림영역 열
        // [0,0], [0,1]..... 탐색
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // picture 값이 0 이 아니면 색칠 영역
                // 해당영역 탐색하지 않을 때만 탐색
                if (picture[i][j] != 0 && !visited[i][j]) {
                    numberOfArea++; // 영역변수 + 1
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(i, j, picture));
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private int bfs(int i, int j, int[][] picture) {
        int target = picture[i][j];
        int areaSize = 1;
        this.visited[i][j] = true;
        // Queue 선언 - [Point class로 선언]
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(i, j));    // queue에 값 설정

        while (!queue.isEmpty()) {
            // Queue에 값이 없을때까지 반복문 수행
            Point point = queue.poll();

            for (int k = 0; k < 4; k++) {
                // i, j 기준점에서 상하좌우로 이동
                int dx = point.x + this.dx[k];
                int dy = point.y + this.dy[k];

                // dx, dy 가 그림영역에 포함되고 값이 같으면
                // areaSize 값을 중가
                if (dx >= 0 && dx < this.m
                 && dy >= 0 && dy < this.n
                 && target == picture[dx][dy]
                 && !this.visited[dx][dy]) {
                    this.visited[dx][dy] = true;
                    areaSize++;
                    queue.offer(new Point(dx, dy));
                }
            }
        }

        return areaSize;
    }

    @Test
    public void testSolution() {
        // 6
        // 4
        // [[1, 1, 1, 0], [1, 2, 2, 0], [1, 0, 0, 1], [0, 0, 0, 1], [0, 0, 0, 3], [0, 0, 0, 3]]
        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}
                          ,{0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int[] exAnswer = {4, 5};
        int[] answer = solution(m, n, picture);
        Assertions.assertArrayEquals(answer, exAnswer);
    }
}
