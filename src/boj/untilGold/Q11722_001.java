package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11722_001 {

    // 백준(BOJ) SILVER2 가장 긴 감소하는 부분 수열
    // 문제 URL : https://www.acmicpc.net/problem/11722

    // 감소분의 값을 가지고 있는 배열
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

        System.out.println(solution(arr));
    }

    private static int solution(int[] arr) {
        int answer = 0;
        dy[0] = 1;
        if (arr.length == 1) {
            // 수열의 길이 1일 경우(해당 탑의 레이저 닿는 곳 존재하지 않아 값'0' 리턴)
            answer = dy[0];
        } else {
            for (int i = 1; i < arr.length; i++) {
                int max = 0;
                for (int j = i - 1; j >= 0 ; j--) {
                    // 기준값이 비교하는 값보다 작고 감소수열값이
                    // max 값 보다 클 경우 max 값 변경
                    if (arr[j] > arr[i] && max < dy[j]) {
                        max = dy[j];
                    }
                }
                // 연속되는 감소분 나타내기 위해 최고값 +1
                // EX) arr[2] = 10 은 arr[1] = 30 보다 값이 작기(감소) 때문에
                // dy[1] = 1 값에 +1을 하여 2를 대입
                dy[i] = max + 1;
                answer = Math.max(dy[i], answer);
            }
        }
        return answer;
    }
}
