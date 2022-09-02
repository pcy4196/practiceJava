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

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));

    }

}
