package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Q220314_001 {

    // 프로그래머스 LEVEL2 기능개발
    // 문제 URL : https://programmers.co.kr/learn/courses/30/lessons/42586

    public int[] solution(int[] progresses, int[] speeds) {
        int arrSize = progresses.length;
        // 기능별로 소요시간 담는 변수
        List<Integer> resultDay = new ArrayList<>();
        int maxDay = 0;
        int sucCnt = 0;
        for (int i = 0; i < arrSize; i++) {
            // int sucDay = (100 - progresses[i]) / speeds[i];

            // BigDecimal remain = new BigDecimal(100)
            //                      .subtract(new BigDecimal(progresses[i]))
            //                      .divide(new BigDecimal(speeds[i]));
            // int sucDay = remain.intValue();

            // progresses, speeds 의 정확한 계산을 위한 더블형으로 변환 필요
            double remain = (100.0 - (double) progresses[i]) / (double) speeds[i];
            int sucDay = (int) Math.ceil(remain);

            if (maxDay == 0) {
                maxDay = sucDay;
                sucCnt = 1;
            } else {
                if (maxDay >= sucDay) {
                    // 작업성공일시가 그 전 보다 작으면
                    // 앞에거 배포될때 같이 배포 처리
                    sucCnt++;
                } else {
                    // 작업성공일시가 그 전 보다 크면
                    // 배포처리 데이터 LIST에 추가
                    resultDay.add(sucCnt);
                    // 변수 초기화
                    maxDay = sucDay;
                    sucCnt = 1;
                }
            }
        }
        // 처리못한 sucCnt 처리하기 위해 추가 로직
        resultDay.add(sucCnt);

        // answer 변수 초기화 및 값 대입
        int[] answer = new int[resultDay.size()];
        for (int i = 0; i < resultDay.size(); i++) {
            answer[i] = resultDay.get(i);
        }

        return answer;
    }

    @Test
    public void testSolution() {
//        int[] progresses = {93, 30, 55};
//        int[] speeds = {1, 30, 5};
//        int[] expectedArr = {2, 1};
//        Assertions.assertArrayEquals(expectedArr, solution(progresses, speeds));
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        int[] expectedArr = {1, 3, 2};
        Assertions.assertArrayEquals(expectedArr, solution(progresses, speeds));
    }
}
