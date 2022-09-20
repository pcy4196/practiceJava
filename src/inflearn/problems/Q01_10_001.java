package inflearn.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q01_10_001 {

    // 인프런(inflearn) - 가장 짧은 문자거리
    // 문제 URL : https://cote.inflearn.com/contest/10/problem/01-10

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 0.데이터입력
        // s = 문자열(소문자)
        String str = st.nextToken().toLowerCase();
        char[] s = str.toCharArray();
        // t = 비교하는 문자(소문자)
        String t = st.nextToken().toLowerCase();
        char ct = t.charAt(0);
        // 첫번째 매치되는 인덱스
        int fc = str.indexOf(ct);

        // 거리의 정보를 담는 배열 - 초기값 설정
        int[] answer = new int[s.length];
        Arrays.fill(answer, Integer.MAX_VALUE);

        // 1.주어진 문자열과 가장 짧은 거리를 찾는 로직 구현
        int n1 = 1;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ct) {
                // 비교하는 문자열과 같은 경우
                int n2 = 0;
                for (int j = i; j >= 0; j--) {
                    // 또다른 비교열 문자가 존재하는 경우까지 진행
                    if (answer[j] == 0) break;
                    // 문자열이 같은 경우에는 0으로 값 처리
                    if (j == i) {
                        answer[j] = 0;
                    } else {
                        answer[j] = Math.min(n2, answer[j]);
                    }
                    n2++;
                }
                n1 = 1;
            } else {
                // 비교하는 문자열과 다른 경우
                // -- 첫번째 매치 이후 인덱스부터 수행
                if (i > fc) {
                    answer[i] = n1;
                    n1++;
                }
            }
        }
        // 2.정답 출력(StringBuilder 사용)
        StringBuilder sb = new StringBuilder();
        for (int ans : answer) {
            sb.append(ans).append(" ");
        }
        System.out.println(sb.toString());
    }

}
