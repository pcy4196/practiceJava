package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q220502_001 {

    // 프로그래머스 LEVEL2 JadenCase 문자열 만들기
    // 문제 URL : https://programmers.co.kr/learn/courses/30/lessons/12951

    public String solution(String s) {
        StringBuffer sb = new StringBuffer();

        // String -> char형 배열로 초기화
        char[] ch = s.toCharArray();
        boolean prevSpace = false;  // 띄어쓰기 담는 변수

        for (int i = 0; i < ch.length; i++) {
            // 문자가 공백이면(중복공백이 나올 수가 있기때문에 아래와 같이 처리)
            if (Character.isSpaceChar(ch[i])) {
                sb.append(ch[i]);
                prevSpace = true;
            // 이전 문자가 공백이거나 처음 문자이면 대문자로 변환
            // 숫자 일 경우에도 toUpperCase 적용가능 -> 숫자로 반환
            } else if (prevSpace || i == 0) {
                sb.append(Character.toUpperCase(ch[i]));
                prevSpace = false;
            } else {
                sb.append(Character.toLowerCase(ch[i]));
                prevSpace = false;
            }
        }

        return sb.toString();
    }

    // 다른 풀이방법으로 풀이
    public String solutionOne(String s) {
        StringBuffer sb = new StringBuffer();
        // 소문자로 변환
        String lowerStr = s.toLowerCase();
        // 공백 판단 변수
        boolean flagGap = false;

        for (int i = 0; i < lowerStr.length(); i++) {
            // 문자가 첫번째이거나 이전문자가 공백일경우
            sb.append(i == 0 || flagGap ? Character.toUpperCase(lowerStr.charAt(i)) : lowerStr.charAt(i));
            flagGap = Character.isSpaceChar(lowerStr.charAt(i)) ? true : false;
        }

        return sb.toString();
    }


    @Test
    public void testSolution() {
        String strQ = "3people unFollowed me";
        String strA = "3people Unfollowed Me";
        String strQ1 = "for the last week";
        String strA1 = "For The Last Week";
        Assertions.assertEquals(strA, this.solutionOne(strQ));
        Assertions.assertEquals(strA1, this.solution(strQ1));
    }
}
