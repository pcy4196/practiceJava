package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q220425_001 {

    // 프로그래머스 LEVEL2 N개의 최소공배수
    // 문제 URL : https://programmers.co.kr/learn/courses/30/lessons/12953

    // [1]
    public int solutionOne(int[] arr) {
        // arr 원소값이 하나일경우
        if (arr.length == 1) {
            return arr[0];
        // arr 원소값이 두일경우
        } else if (arr.length == 2) {
            return (arr[0] * arr[1]) / this.gcd(arr[0], arr[1]);
        } else {
            // 그 외인 경우
            int lcm = (arr[0] * arr[1]) / this.gcd(arr[0], arr[1]);;    // 최소공배수
            for (int i = 2; i < arr.length; i++) {
                lcm = (lcm * arr[i]) / this.gcd(lcm, arr[i]);;
            }
            return lcm;
        }
    }

    // [2]
    public int solutionTwo(int[] arr) {
        int answer = 1;
        for (int i = 0; i < arr.length; i++) {
            answer = (answer * arr[i]) / this.gcd(answer, arr[i]);
        }
        return answer;
    }

    // 최대공약수 구하는 메서드
    // a > b
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
        Assertions.assertEquals(168, this.solutionOne(arr));
        Assertions.assertEquals(168, this.solutionTwo(arr));
    }
}
