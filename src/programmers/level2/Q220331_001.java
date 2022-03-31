package programmers.level2;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class Q220331_001 {

    // 프로그래머스 LEVEL2 소수 찾기
    // 문제 URL : https://programmers.co.kr/learn/courses/30/lessons/42839

    // '11과 011은 같은 숫자로 취급합니다.'
    // --> 중복을 제거하면서 숫자를 저장하는 set 선언
    HashSet<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        // numbers에 선언된 숫자로 모든 숫자 탐색
        numBfs("", numbers, set);
        int answer = 0;
        return answer;
    }

    // 숫자 탐색하는 함수
    private void numBfs(String prefix, String numbers, HashSet<Integer> set) {
        int n = numbers.length();
        if (!"".equals(prefix)) {
            // 빈값이 아니면 모든 숫자를 set에 포함
            set.add(Integer.parseInt(prefix));
        }
        for (int i = 0; i < n; i++) {
//            numBfs(prefix + numbers.charAt(i), numbers.substring(0, i) + numbers.substring(), set);
        }
    }

    @Test
    public void testSolution() {
        // 6, 6, [[2,2,5,4],[3,3,6,6],[5,1,6,3]], [8, 10, 25]
//        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
//        int[][] queries = {{2,2,5,4}};
//        int[] answer = {8, 10, 25};
//        int[] answer = {8};
//        Assertions.assertArrayEquals(answer, this.solution(6, 6, queries));
    }
}
