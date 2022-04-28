package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q220428_001 {

    // 프로그래머스 LEVEL2 다음 큰 숫자
    // 문제 URL : https://programmers.co.kr/learn/courses/30/lessons/12911

    // [1] - 효율성문제로 인해 다른 방식으로 해결 필요
    public int solutionOne(int n) {
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
    // [1] - 효율성문제로 인해 다른 방식으로 해결 필요

    public int solutionTwo(int n) {
        int answer = 0;
        int cntOne = Integer.bitCount(n);       // n 숫자를 binary로 변환 후 true(1) 값 반환

        while (true) {
            n++;    // 주어진 숫자를 증가
            if (cntOne == Integer.bitCount(n)) {
                // 증가한 숫자를 2진수로 변환 및 true(1)
                // 갯수 반환하여 기준 숫자의 값과 비교
                answer = n;
                break;
            }
        }

        return answer;
    }


    @Test
    public void testSolution() {
        Assertions.assertEquals(83, this.solutionOne(78));
        Assertions.assertEquals(83, this.solutionTwo(78));
    }
}
