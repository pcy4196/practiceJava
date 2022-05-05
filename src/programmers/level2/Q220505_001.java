package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Q220505_001 {

    // 프로그래머스 LEVEL2 큰 수 만들기
    // 문제 URL : https://programmers.co.kr/learn/courses/30/lessons/42883

    public String solution(String number, int k) {
        StringBuffer answer = new StringBuffer();
        int idx = 0;    // 숫자 탐색 기준이 되는 변수
        int max = 0;    // 숫자를 비교하기 위해 저장하는 변수
        // number.length() - k --> k 개수를 제외한 크기까지 탐색
        for (int i = 0; i < number.length() - k; i++) {
            max = 0;
            for (int j = idx; j <= i + k; j++) {
                // i + k :: 앞으로 이어붙혀야할 문자의 길이 -1이 되는 범위까지 탐색
                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    idx = j + 1;
                }
            }
            answer.append(max);
        }

        return answer.toString();
    }

    @Test
    public void testSolution() {
        Assertions.assertEquals("94", this.solution("1924", 2));
    }
}
