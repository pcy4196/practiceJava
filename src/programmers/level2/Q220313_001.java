package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Q220313_001 {

    // 프로그래머스 LEVEL2 124 나라의 숫자
    // 문제 URL : https://programmers.co.kr/learn/courses/30/lessons/12899

    public String solution(int n) {
        String answer = "";
        StringBuffer sb = new StringBuffer(); // 정답을 담는 변수
        // 1,2,4나라의 변환한 숫자를 담는 Stack 변수
        Stack<String> tempNum = new Stack<>();
        int inputNum = n;
        while (inputNum > 0) {
            // 전반적인 방법은 3진법 구하는 방법과 비슷하게 처리
            // 0이 나올 경우에만 4가 나오도록 설정
            int chkMod = inputNum % 3;
            if (chkMod == 0) {
                tempNum.add(String.valueOf(4));
                inputNum = (inputNum / 3) - 1;
                /*
                EX) 1) 숫자 3
                       3 % 3 = 0
                       3진법 : 10 -> 4
                    2) 숫자 6
                       6 % 3 = 0
                       3진법 : 20 -> 14
                    :: 10 -> 4 로 변경되기 때문에
                    :: inputNum 3으로 나눈 다음에 1 뺄셈
                 */
            } else {
                tempNum.add(String.valueOf(chkMod));
                inputNum = inputNum / 3;
            }
        }
        // stack 크기 만큼 반복문 수행
        // 저장한거와는 반대로 끝에서부터 숫자 추출
        int size = tempNum.size();
        for (int i = 0; i < size; i++) {
            sb.append(tempNum.pop());
        }
        answer = sb.toString();
        return answer;
    }

    @Test
    public void testSolution() {
        Assertions.assertEquals("14", solution(6));
        Assertions.assertEquals("11", solution(4));
    }
}
