package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5525_001 {

    // 백준(BOJ) SILVER1 IOIOI
    // 문제 URL : https://www.acmicpc.net/problem/5525

    public static void main(String[] args) throws IOException {
        // 1) 50점 방식
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(st.nextToken());
//        int len = 2*N + 1;                          // 비교하는 문자열 길이
//        st = new StringTokenizer(br.readLine());
//        int M = Integer.parseInt(st.nextToken());
//        String S = br.readLine();
//        StringBuffer chkSb = new StringBuffer();    // 비교하는 문자열 담는 변수
//        for (int i = 1; i <= len; i++) {
//            if (i % 2 != 0) {
//                chkSb.append("I");
//            } else {
//                chkSb.append("O");
//            }
//        }
//        StringBuffer sliSb = new StringBuffer();
//        sliSb.append(S.substring(0, len));          // 최초로 비교할 부분문자열
//        int answer = 0;
//        for (int i = len; i < M; i++) {
//            // 부분문자열과 체크 문자열 같은 문자인지 체크
//            if (sliSb.toString().equals(chkSb.toString())) {
//                answer++;
//            }
//            // 부분문자열 변경
//            sliSb.append(S.charAt(i));
//            sliSb.delete(0, 1);
//        }
//
//        System.out.println(answer);
        // 2) 100점 방식
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());        // Pn 문자열 크기
        int M = Integer.parseInt(br.readLine());        // 비교할 원본 문자열 크기
        char[] s = br.readLine().toCharArray();         // 원본 문자 배열
        int pCnt = 0;                                   // 'IOI' 반복 개수
        int answer = 0;                                 // Pn 문자열 반복 횟수
        for (int i = 1; i < M - 1; i++) {
            if (s[i-1] == 'I' && s[i] == 'O' && s[i+1] == 'I') {
                pCnt++;
                if (pCnt == N) {
                    answer++;
                    pCnt--;
                }
                // IOI를 체크하기 위해서 1증가가 아닌 2증가 필요
                i += 1;
            } else {
                pCnt = 0;
            }
        }
        System.out.println(answer);
    }
}
