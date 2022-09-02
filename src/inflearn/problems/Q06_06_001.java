package inflearn.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q06_06_001 {

    // 인프런(inflearn) - 장난꾸러기
    // 문제 URL : https://cote.inflearn.com/contest/10/problem/06-06

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());           // N명의 학생
        st = new StringTokenizer(br.readLine());
        int[] arrA = new int[N];                            // 정렬하기전 학생 정보
        int[] arrB = new int[N];                            // 정렬한 후 학생정보
        // 정렬하기전 학생 정보 설정
        for (int i = 0; i < N; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
            arrB[i] = arrA[i];
        }

        // 학생들을 키 순으로 정렬(오름차순)
        Arrays.sort(arrB);

        // 정답 출력 배열 선언
        int[] ans = new int[2];
        for (int i = 0; i < N; i++) {
            // 철수를 판단하는 기준
            // 정렬된 후 원래위치의 값보다 작은 경우
            if (arrB[i] < arrA[i]) {
                ans[0] = i + 1; // 1번부터 시작이라 i+1 설정
            // 짝궁을 판단하는 기준
            } else if (arrB[i] > arrA[i]) {
                ans[1] = i + 1; // 1번부터 시작이라 i+1 설정
            }
        }

        System.out.println(ans[0] + " " + ans[1]);
    }

}
