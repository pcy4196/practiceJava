package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2493_001 {

    // 백준(BOJ) GOLD5 탑
    // 문제 URL : https://www.acmicpc.net/problem/2493

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 텁의수
        int N = Integer.parseInt(st.nextToken());
        // 탑의 정보 담는 배열변수
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 레이저 신호를 수신 정보를 담는 변수
        int[] topArr = new int[N];
        // 기본값을 0으로 설정
        Arrays.fill(topArr, 0);

        // 레이저 수신정보를 잠깐 담는 변수
        int tempRzer = Integer.MAX_VALUE;
        // 우측부터 레이저 신호를 탐색하기 위해서 아래와 같이 for문 작성
        for (int i = N - 1; i > 0; i--) {
            // 탐색하는 탑의 순서가 tempRzer 보다 작을때 비교로직 수행
            if (i < tempRzer) {
                for (int j = i - 1; j >= 0; j--) {
                    if (arr[j] > arr[i]) {
                        tempRzer = j + 1;
                        topArr[i] = tempRzer;
                        break;
                    }
                }
            } else {
                topArr[i] = tempRzer;
            }
        }

        Arrays.stream(topArr).forEach(s -> System.out.print(s + " "));
    }
}
