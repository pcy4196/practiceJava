package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q220322_001 {

    // 프로그래머스 LEVEL2 타겟 넘버
    // 문제 URL : https://programmers.co.kr/learn/courses/30/lessons/43165

    public int solution(int[] numbers, int target) {
        int answer = 0;
        List<Integer> list = null;
        // stack를 이용해서 해당 알고리즘 구현
        Stack<Integer> stkv = new Stack<>();
        stkv.push(numbers[0]);
        stkv.push(-numbers[0]);

        for (int i = 1; i < numbers.length; i++) {
            // i 단계 깊이의 숫자합 구현
            list = new ArrayList<>();
            while (!stkv.isEmpty()) {
                int tempNum = stkv.pop();
                // [1] +1 +1, +1 -1 [2] -1 +1, -1 -1 ......
                // 2번째 깊이 예시
                list.add(tempNum + numbers[i]);
                list.add(tempNum - numbers[i]);
            }
            for (int j = 0; j < list.size(); j++) {
                // 1단계
                // [1] 1 [2] -1
                // 2단계
                // [1] 2, 0 [2] 0, -2
                stkv.push(list.get(j));
            }
        }
        // number 개수가 5이므로 size 32
        System.out.println("stack size : " + stkv.size());
        for (Integer stkVal : stkv) {
            if (stkVal == target) answer++;
        }

        return answer;
    }


    @Test
    public void testSolution() {
        int[] num = {1, 1, 1, 1, 1};
        int target = 3;
        Assertions.assertEquals(5, this.solution(num, target));
    }
}
