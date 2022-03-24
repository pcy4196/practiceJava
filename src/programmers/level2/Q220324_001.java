package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Q220324_001 {

    // 프로그래머스 LEVEL2 짝지어 제거하기
    // 문제 URL : https://programmers.co.kr/learn/courses/30/lessons/12973

    public int solution(String s) {
        // stack를 이용해서 해당 문제 해결 가능
        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            // baabaa
            // 1. b -> stack 에 push
            // 2. a -> stack 에 push
            // 3. a -> stack.peek()[a] 똑같기 때문에 stack.pop()로 a 제거
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

    @Test
    public void testSolution() {
        Assertions.assertEquals(1, this.solution("baabaa"));
        Assertions.assertEquals(0, this.solution("cdcd"));
    }
}
