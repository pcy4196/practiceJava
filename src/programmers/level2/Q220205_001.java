package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q220205_001 {

    // 프로그래머스 LEVEL2 문자열 압축
    // 문제 URL : https://programmers.co.kr/learn/courses/30/lessons/60057

    public int solution(String s) {
        int answer = s.length(); // 압축하기 전 문자열 길이로 초기화

        for (int i = 1; i <= s.length() / 2; i++) {
            // 압축을 판단하는 최고 길이 : s.length() / 2
            int encCnt = 1;
            String encStr = s.substring(0, i);  // a
            String comStr = ""; // 비교 문자
            StringBuffer result = new StringBuffer();
            for (int j = i; j <= s.length() ; j += i) {
                // j += i --> i 설정된 값으로 뒤 문장 짜르기
                // j <= s.length() : 문자를 모두다 가져오게 하기 위한 설정
                // j < s.length() --> 'aabbaccc' 일 경우 마지막 문자 2a2bac 값 설정
                comStr = s.substring(j, j+i > s.length() ? s.length() : j+i); // 나머지 문자 가져오게 하기 위한 설정
                if (encStr.equals(comStr)) {    // 문자 값이 같을 경우
                    encCnt++;
                } else {
                    if (encCnt > 1) {
                        result.append(encCnt + encStr);
                    } else {
                        result.append(encStr);  // 문자 값이 한번도 안 같을경우에는 encCnt 생략
                    }
                    encCnt = 1; // 초기화
                    encStr = comStr;
                }
            }
            result.append(comStr);  // 나머지 문자를 포함
            answer = Math.min(answer, result.length()); // 현재 문자열 압축된 길이와 비교
        }

        return answer;
    }

    @Test
    public void testSolution() {
        Assertions.assertEquals(7, solution("aabbaccc"));
        Assertions.assertEquals(9, solution("ababcdcdababcdcd"));
        Assertions.assertEquals(8, solution("abcabcdede"));
        Assertions.assertEquals(14, solution("abcabcabcabcdededededede"));
        Assertions.assertEquals(17, solution("xababcdcdababcdcd"));
    }
}
