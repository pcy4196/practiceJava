package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1541_001 {

    // 백준(BOJ) SILVER2 잃어버린 괄호
    // 문제 URL : https://www.acmicpc.net/problem/1541

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 수식문자열
        String formula = br.readLine();
        int answer = 0;
        // 최고작은 값 : 55-(50+40)
        // --> 해결방안 : '-'를 기준으로 괄호를 만들어서 계산하여 최소값 도출
        // 1) '-'를 기준으로 분리
        String[] divMinus = formula.split("-");
        for (int i = 0; i < divMinus.length; i++) {
            // 2) '+' 기준으로 분리하여 숫자만 분리 및 덧셈 처리
            if (i == 0) {
                // 최초로 for문을 시작할때는 덧셈처리
                for (String numStr : divMinus[i].split("\\+")) {
                    answer += Integer.parseInt(numStr);
                }
            } else {
                // '-' 기준으로 괄호 처리를 위한 로직
                // ex) -(50+40) -> 해당 형태로 처리하기 위해 아래와 같이 처리
                int microSum = 0;
                for (String numStr : divMinus[i].split("\\+")) {
                    microSum += Integer.parseInt(numStr);
                }
                answer += microSum * -1;
            }
        }

        // 정답 출력
        System.out.println(answer);
    }
}
