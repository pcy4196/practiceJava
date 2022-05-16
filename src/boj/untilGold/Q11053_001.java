package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11053_001 {

    // 백준(BOJ) SILVER2 가장 긴 증가하는 부분 수열
    // 문제 URL : https://www.acmicpc.net/problem/11053

    // 증가분의 값을 가지고 있는 배열
    static int[] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 수열의 크기
        int N = Integer.parseInt(st.nextToken());
        // 수열 선언 및 값 설정
        int[] arr = new int[N];
        dy = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 입력값 확인
        // Arrays.stream(arr).forEach(s -> System.out.print(s + " "));
        System.out.println(solution(arr));
    }

    private static int solution(int[] arr) {
        int answer = 0;
        dy[0] = 1;
        if (arr.length == 1) {
            // 수열의 길이 1일 경우
            answer = dy[0];
        } else {
            for (int i = 1; i < arr.length; i++) {
                int max = 0;
                for (int j = i - 1; j >= 0 ; j--) {
                    // 기준값이 비교하는 값보다 크고 증가수열값도
                    // max 값 보다 클 경우 max 값 변경
                    if (arr[j] < arr[i] && max < dy[j]) {
                        max = dy[j];
                    }
                }
                // 증가분 나타내기 위해 최고값 +1
                dy[i] = max + 1;
                answer = Math.max(dy[i], answer);
            }
        }
        return answer;
    }
}
