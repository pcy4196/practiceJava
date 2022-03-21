package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q220321_001 {

    // 프로그래머스 LEVEL2 타겟 넘버
    // 문제 URL : https://programmers.co.kr/learn/courses/30/lessons/43165

    int[] arr;
    int answer = 0;

    public int solution(int[] numbers, int target) {
        arr = numbers;

        dfs(0, 0, target);

        return answer;
    }

    public void dfs(int sum, int i, int target) {
        if(i == arr.length) {
            if(sum == target) answer++;
            return;
        }

        dfs(sum+arr[i], i+1, target);
        dfs(sum-arr[i], i+1, target);
    }

    // [1, 1, 1, 1, 1] 3 5
    @Test
    public void testSolution() {
        int[] num = {1, 1, 1, 1, 1};
        int target = 3;
        Assertions.assertEquals(5, this.solution(num, target));
    }
}
