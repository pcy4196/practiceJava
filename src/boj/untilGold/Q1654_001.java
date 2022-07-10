package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1654_001 {

    // 백준(BOJ) SILVER2 랜선 자르기
    // 문제 URL : https://www.acmicpc.net/problem/1654

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());                   // 랜선의 개수
        int N = Integer.parseInt(st.nextToken());                   // 필요한 랜선의 개수
        long[] arr = new long[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        long start = 1;
        // 랜선길이 값 중 최대값 설정
        long end    = Arrays.stream(arr).max().getAsLong();
        long answer = 0L;
        long mid    = 0L;
        while (start <= end) {
            mid = (start + end) / 2;
            int cnt = (int)getLineCnt(mid, arr);
            // 구한 랜선개수에 따른 처리 구현
            if (cnt >= N) {
                // 랜선개수가 기준값보다 크면 시작값을 중간값보다 더 큰 값으로 세팅하여 진행
                start = mid + 1;
                answer = Math.max(answer, mid);
            } else {
                // 랜선개수가 기준값보다 작으면 종료값을 중간값보다 더 작은 값으로 세팅하여 진행
                end = mid - 1;
            }
        }

        System.out.println(answer);
    }

    // 기준이 되는 길이로 랜선 개수를 구하는 메서드
    private static long getLineCnt(long mid, long[] arr) {
        long cnt = 0L;
        for (int i = 0; i < arr.length; i++) {
            cnt += arr[i] / mid;
        }
        return cnt;
    }
}
