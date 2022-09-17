package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11123_001 {

    // 백준(BOJ) SILVER2 양 한마리... 양 두마리...
    // 문제 URL : https://www.acmicpc.net/problem/11123
    static char[][] sMap;               // 양의 정보를 담는 2차원 배열
    static ArrayList<char[][]> list;    // 테스트 케이스를 저장하는 리스트
    static int T;                       // 테스트 케이스 수
    static int H;                       // 높이
    static int W;                       // 넓이
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Elem {
        int h;
        int w;

        public Elem(int h, int w) {
            this.h = h;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 0. 데이터 입력
        T = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            sMap = new char[H][W];
            for (int h = 0; h < H; h++) {
                sMap[h] = br.readLine().toCharArray();
            }
            list.add(sMap);
        }

//        // 0-1. 데이터 입력 확인
//        for (char[][] chars : list) {
//            for (char[] cArr : chars) {
//                System.out.println(Arrays.toString(cArr));
//            }
//        }

        // 1. 테이스 케이스별 양의 무리를 찾는 메서드
        for (int i = 0; i < T; i++) {
            System.out.println(solve(list.get(i), list.get(i).length, list.get(i)[0].length));
        }

    }

    private static int solve(char[][] sMap, int h, int w) {
        int result = 0;
        boolean[][] visited = new boolean[h][w];
        Queue<Elem> queue = new LinkedList<>();
        // 2-1. BFS 수행
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!visited[i][j]) {
                    // 2-2. 해당 위치 방문 처리(조건 안따지고 방문처리)
                    visited[i][j] = true;
                    if (sMap[i][j] == '#') {
                        // 2-3. 양일 걍우 큐에 추가
                        queue.add(new Elem(i, j));
                        int cnt = 0;
                        while (!queue.isEmpty()) {
                            Elem elem = queue.poll();
                            cnt++;
                            // 2-4. 해당 양 위치에서 상하좌우로 이동
                            for (int k = 0; k < 4; k++) {
                                int x = elem.h + dx[k];
                                int y = elem.w + dy[k];
                                if (x >= 0 && y >= 0 && x < h && y < w && !visited[x][y]) {
                                    // 2-5 상하좌우 이동한 위치에서 양을 판단하여 큐에 추가
                                    visited[x][y] = true;
                                    if (sMap[x][y] == '#') queue.add(new Elem(x, y));
                                }
                            }
                        }
                        // 양무리일 경우 result값 증가
                        if (cnt > 0) result++;
                    }
                }
            }
        }
        return result;
    }

}
