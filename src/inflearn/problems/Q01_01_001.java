package inflearn.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q01_01_001 {

    // 인프런(inflearn) - 문자찾기
    // 문제 URL : https://cote.inflearn.com/contest/10/problem/01-01

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chArr = br.readLine().toUpperCase().toCharArray();       // 문자열 - 대문자로 변경
        char comCh = Character.toUpperCase(br.readLine().charAt(0));    // 비교할 문자 - 대문자로 변경

        int answer = 0;

        // 주어진 문자가 문자열에 몇개 있는지 판단하는 로직
        for (char c : chArr) {
            if (Character.compare(c, comCh) == 0) {
                answer++;
            }
        }

        System.out.println(answer);
    }

}
