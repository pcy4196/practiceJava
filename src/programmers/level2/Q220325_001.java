package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Q220325_001 {

    // 프로그래머스 LEVEL2 가장 큰 수
    // 문제 URL : https://programmers.co.kr/learn/courses/30/lessons/42746

    public String solution(int[] numbers) {
        // 숫자 비교하기 위한 배열
        String[] arrNum = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            arrNum[i] = String.valueOf(numbers[i]);
        }

        // 내림차순 정렬
        Arrays.sort(arrNum, (a, b) -> (b + a).compareTo(a + b));
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arrNum.length; i++) {
            sb.append(arrNum[i]);
        }

        return sb.toString().startsWith("0") ? "0" : sb.toString();
    }

    @Test
    public void testSolution() {
        // [6, 10, 2] "6210"
        int[] number1 = {6, 10, 2};
        Assertions.assertEquals("6210", this.solution(number1));
        // [3, 30, 34, 5, 9] "9534330"
        int[] number2 = {3, 30, 34, 5, 9};
        Assertions.assertEquals("9534330", this.solution(number2));
        // [3, 30] "330"
        int[] number3 = {3, 30};
        Assertions.assertEquals("330", this.solution(number3));
    }
}
