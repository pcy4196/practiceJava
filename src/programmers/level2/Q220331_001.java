package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;

public class Q220331_001 {

    // 프로그래머스 LEVEL2 소수 찾기
    // 문제 URL : https://programmers.co.kr/learn/courses/30/lessons/42839

    // '11과 011은 같은 숫자로 취급합니다.'
    // --> 중복을 제거하면서 숫자를 저장하는 set 선언
    HashSet<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;
        // numbers에 선언된 숫자로 모든 숫자 탐색
        numBfs("", numbers);
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            answer += chkPrimeNum(iterator.next());
        }

        return answer;
    }

    // 숫자가 소수인지 체크하는 함수
    private int chkPrimeNum(Integer num) {
        // 해당 조합 숫자중 0, 1은 소수가 아니므로 선처리
        if (num == 0 || num == 1) {
            return 0;
        }
        int endNum = Math.floorDiv(num, 2);    // 해당 숫자 나누기 2한 몫까지 처리
        for (int i = 2; i <= endNum; i++) {
            // 해당 숫자가 i 숫자의 배수중 하나이면 소수 X
            if ((num % i) == 0) {
                return 0;
            }
        }
        return 1;
    }

    // 숫자 탐색하는 함수
    // 1, 17, 7 ,71
    private void numBfs(String prefix, String numbers) {
        int n = numbers.length();
        if (!"".equals(prefix)) {
            // 빈값이 아니면 모든 숫자를 set에 포함
            set.add(Integer.parseInt(prefix));
        }
        for (int i = 0; i < n; i++) {
            numBfs(prefix + numbers.charAt(i),
                    numbers.substring(0, i) + numbers.substring(i+1, n));
        }
    }

    @Test
    public void testSolution() {
        Assertions.assertEquals(3, this.solution("17"));
    }
}
