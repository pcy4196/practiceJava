package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1463_001 {

    // 백준(BOJ) SILVER3 1로 만들기
    // 문제 URL : https://www.acmicpc.net/problem/1463

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());       // 계산을 해야하는 정수(1보다 크다)
        int[] arr = new int[N+1];                       // 해당숫자를 구하기 위해 연산하는 수를 담는 배열변수

        for (int i = 2; i <= N; i++) {                  // bottom-up 방식으로 계산
            arr[i] = arr[i-1] + 1;  // 해당 숫자가 2,3의 배수가 아닌 경우 이전 숫자의 값+1
            if (i % 3 == 0) {       // 해당 숫자가 3의 배수이면 이전 숫자의 값+1, 이전 3의 배수 값+1
                arr[i] = Math.min(arr[i/3] + 1, arr[i]);
            }
            if (i % 2 == 0) {
                arr[i] = Math.min(arr[i/2] + 1, arr[i]);
            }
        }

        System.out.println(arr[N]);
    }
}
