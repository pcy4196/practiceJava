package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q220428_001 {

    // 프로그래머스 LEVEL2 다음 큰 숫자
    // 문제 URL : https://programmers.co.kr/learn/courses/30/lessons/12911

    public int solution(int n) {
        int answer = 0;
        String biStr = Integer.toBinaryString(n);      // 10진수를 2진수로 변경하는 부분
        int cntOne = countStr(biStr, "1");        // 2진수에서 '1' 개수를 구하는 로직

        while(true) {
            n++;    // 기준 숫자 증가
            if (cntOne == countStr(Integer.toBinaryString(n), "1")) {
                answer = n;
                break;
            }
        }

        return answer;
    }

    // 기준 문자열에서 해당문자 갯수를 리턴하는 메서드
    private int countStr(String biStr, String str) {
        return biStr.length() - biStr.replace(str, "").length();
    }

    @Test
    public void testSolution() {
        Assertions.assertEquals(83, this.solution(78));
    }
}
