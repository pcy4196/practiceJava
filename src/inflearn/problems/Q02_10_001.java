package inflearn.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q02_10_001 {

    // 인프런(inflearn) - 봉우리
    // 문제 URL : https://cote.inflearn.com/contest/10/problem/02-10

    static int[] x = {-1, 0, 1, 0};
    static int[] y = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 정답을 출력할 변수
        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int h = arr[i][j];
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int ix = i + x[k];
                    int jy = j + y[k];
                    if (ix >= 0 && ix < N
                     && jy >= 0 && jy < N
                     && arr[ix][jy] >= arr[i][j]) {
                        flag = false;   // 주변 지역의 높이가 같거나 높으면 false로 변경
                    }
                }
                // 해당 위치의 높이가 주변보다 높으면 봉우리 처리
                if (flag) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

}
