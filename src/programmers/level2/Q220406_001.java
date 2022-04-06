package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Q220406_001 {

    // 프로그래머스 LEVEL2 소수 찾기 -- 2
    // 문제 URL : https://programmers.co.kr/learn/courses/30/lessons/42839

    // 백트래킹을 진행한 숫자 모음들을 담는 List변수 선언
    List<Integer> arr = null;
    // numbers의 몇 번째 인덱스에 방문했는지 여부를 체크하는 배열.
    boolean[] check = null;

    public int solution(String numbers) {
        int answer = 0;
        arr = new ArrayList<>();
        check = new boolean[numbers.length()];
        // numbers에 선언된 숫자로 모든 숫자 탐색
        for (int i = 1; i <= numbers.length() ; i++) {
            recursive(numbers, "", i);
        }

        for (Integer num : arr) {
            answer += chkPrimeNum(num);
        }

        return answer;
    }

    // 숫자가 소수인지 체크하는 함수
    private int chkPrimeNum(Integer num) {
        // 해당 조합 숫자중 0, 1은 소수가 아니므로 선처리
        if (num == 0 || num == 1) {
            return 0;
        }
        int endNum = (int) Math.sqrt(num);    // 해당 숫자 루트값 구한 뒤 진행
        for (int i = 2; i <= endNum; i++) {
            // 해당 숫자가 i 숫자의 배수중 하나이면 소수 X
            if ((num % i) == 0) {
                return 0;
            }
        }
        return 1;
    }

    // 숫자 탐색하는 함수(백트래킹)
    // 1, 17, 7 ,71
    private void recursive(String numbers, String temp, int len) {
        if(temp.length() == len) {
            // List에 이미 존재하는 값인지를 확인해 중복값 삽입을 방지.
            if(!arr.contains(Integer.parseInt(temp)))
                arr.add(Integer.parseInt(temp));
            return;
        }
        for (int i = 0; i < numbers.length(); i++) {
            // 해당 숫자를 탐색했으면 SKIP
            if (check[i]) {
                continue;
            }
            check[i] = true;
            temp += numbers.charAt(i);
            recursive(numbers, temp, len);
            check[i] = false;
            // 1 -> 7을 담기위해서 호출하기 전으로 temp 값 변경
            temp = temp.substring(0, temp.length() - 1);
        }
    }

    @Test
    public void testSolution() {
        Assertions.assertEquals(3, this.solution("17"));
    }
}
