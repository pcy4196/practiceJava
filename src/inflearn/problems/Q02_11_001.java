package inflearn.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q02_11_001 {

    // 인프런(inflearn) - 임시반장 정하기
    // 문제 URL : https://cote.inflearn.com/contest/10/problem/02-11

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n+1][6];      // 1번학생, 1학년~
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        for (int i = 1; i <= n; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }

    }

}
