package inflearn.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q02_11_001 {

    // 인프런(inflearn) - 임시반장 정하기
    // 문제 URL : https://cote.inflearn.com/contest/10/problem/02-11

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());       // 총 학생수
        int[][] arr = new int[n+1][6];                  // 1번학생, 1학년~
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int samCnt = 0;             // 같은 반 했던 수
        int max = 0;                // 가장 큰 수(같은 반 했던 수)
        int answer = 1;             // 같은 사람이 없을 경우 1을 반환
        for (int i = 1; i <= n; i++) {
            samCnt = 0;
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 1; k <= 5; k++) {
                    if (arr[i][k] == arr[j][k]) {
                        samCnt++;
                        break;
                    }
                }
            }
            // (i)학생의 임시반장 선정여부 확인 로직
            if (samCnt > max) {
                max = samCnt;
                answer = i;
            }
        }

        System.out.println(answer);
    }

}
