package inflearn.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q06_08_001 {

    // 인프런(inflearn) - 이분검색
    // 문제 URL : https://cote.inflearn.com/contest/10/problem/06-08

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());           // N개의 숫자
        int M = Integer.parseInt(st.nextToken());           // M - 위치를 찾는 숫자값
        st = new StringTokenizer(br.readLine());
        // N개의 숫자 배열에 대입
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 정렬(오름차순)
        Arrays.sort(arr);

        // index 0 부터이기 때문에 return 값에서 +1 출력
        System.out.println(binarySrch(M, 0, N-1, arr) + 1);
    }

    // 이분탐색 재귀메서드
    private static int binarySrch(int M, int start, int end, int[] arr) {
        int mid = (int) ((start + end) / 2.0);
        if (arr[mid] == M) {
            return mid;
        } else if (arr[mid] > M) {
            end = mid - 1;
            return binarySrch(M, start, end, arr);
        } else {
            start = mid + 1;
            return binarySrch(M, start, end, arr);
        }
    }

}
