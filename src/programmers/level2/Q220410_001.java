package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q220410_001 {

    // 프로그래머스 LEVEL2 카펫
    // 문제 URL : https://programmers.co.kr/learn/courses/30/lessons/42842

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        // 해당 조건의 사각형 넓이
        int area = brown + yellow;
        // 가로 최소 길이 -- 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
        int minWidth = (int) Math.sqrt(area);
        // 약수 구하는 방식을 이용하여 가로길이 계산가능
        // 가로의 최대값 - 넓이 / 3 --> 제한조건에서 세로 최소값이 3이기 때문에
        for (int i = 3; i <= area / 3; i++) {
            // i -> 약수이거나 루트값보다 크면 세로길이 계산 및 yellow 검증
            if (area % i == 0 && i >= minWidth) {
                int height = area / i;
                // 세로가 가로보다 크면 SKIP
                if (height > i) continue;
                // 노란색 격자 검증을 위하여 계산
                int chkVal = (i - 2) * (height - 2);
                if (chkVal == yellow) {
                    // 가로, 세로 설정 및 for문 종료
                    answer[0] = i;
                    answer[1] = height;
                    break;
                }
            }
        }

        return answer;
    }


    @Test
    public void testSolution() {
        int[] exAns1 = {4,3};
        Assertions.assertArrayEquals(exAns1, this.solution(10, 2));
        int[] exAns2 = {8,6};
        Assertions.assertArrayEquals(exAns2, this.solution(24, 24));
    }
}
