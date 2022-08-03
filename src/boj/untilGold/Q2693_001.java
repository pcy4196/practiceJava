package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q2693_001 {

    // 백준(BOJ) BRONZE1 N번째 큰 수
    // 문제 URL : https://www.acmicpc.net/problem/2693

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        // 숫자를 담아두는 2차배열 선언
        Integer[][] arr = new Integer[T][10];
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < T; i++) {
            Integer[] tmpArr = arr[i];
            Arrays.sort(tmpArr, Collections.reverseOrder());
            // 3번째 큰 숫자를 출력하기 위해서 아래와 같이 구현
            System.out.println(tmpArr[2]);
        }
    }

}
