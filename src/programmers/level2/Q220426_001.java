package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q220426_001 {

    // 프로그래머스 LEVEL2 N개의 최소공배수 -- 2 (재귀함수 이용[최대공약수])
    // 문제 URL : https://programmers.co.kr/learn/courses/30/lessons/12953

    public int solution(int[] arr) {
        int answer = 1;
        for (int i = 0; i < arr.length; i++) {
            answer = (answer * arr[i]) / this.gcd(answer, arr[i]);
        }
        return answer;
    }

    // 최대공약수 구하는 메서드
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    @Test
    public void testSolution() {
        // [2,6,8,14]	168
        int[] arr = {2,6,8,14};
        Assertions.assertEquals(168, this.solution(arr));
    }
}
