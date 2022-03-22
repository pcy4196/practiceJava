package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q220321_001 {

    // 프로그래머스 LEVEL2 타겟 넘버
    // 문제 URL : https://programmers.co.kr/learn/courses/30/lessons/43165

    int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    private void dfs(int[] numbers, int target, int depth, int sum) {
        if (depth == numbers.length) {
            if (target == sum) {
                this.answer++;
            }
        } else {
            for (int i = 0; i < 2; i++) {
                int newSum = i == 0 ? sum + numbers[depth] : sum - numbers[depth];
                dfs(numbers, target, depth+1, newSum);
            }
        }
    }

    @Test
    public void testSolution() {
        int[] num = {1, 1, 1, 1, 1};
        int target = 3;
        Assertions.assertEquals(5, this.solution(num, target));
    }
}
