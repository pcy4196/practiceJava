package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Q220414_001 {

    // 프로그래머스 LEVEL2 프린터(코드경량 및 개선)
    // 문제 URL : https://programmers.co.kr/learn/courses/30/lessons/42587

    public int solution(int[] priorities, int location) {
        Queue<Text> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Text(i, priorities[i]));
        }
        int order = 0;  // 인쇄순서
        // queue에 값이 없을때까지 수행
        while (!queue.isEmpty()) {
            // 문서 인쇄 스케쥴 변경 여부 확인 변수
            boolean chkAdd = false;
            Text curT = queue.poll();
            for (Text text : queue) {
                // 비교되는 우선순위 값이 크다먄 chkAdd값 true로 설정
                if (text.priority > curT.priority) {
                    chkAdd = true;
                }
            }
            if (chkAdd) {
                // 해당 문서보다 우선순위 문서가 있으면
                // 제일뒤에 해당 문서 위치
                queue.add(curT);
            } else {
                order++;
                // 찾으려는 위치가 인쇄순서가 되면 값 리턴하고 메서드 종료
                if (curT.location == location) {
                    return order;
                }
            }
        }

        return order;
    }

    // 문서정보를 담는 클래스(Text) 선언
    class Text {
        int location;   // 문서 원래 위치
        int priority;   // 문서 중요도
        public Text(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
    }


    @Test
    public void testSolution() {
//        int[] priorities = {2, 1, 3, 2};
//        Assertions.assertEquals(1, this.solution(priorities, 2));
        int[] priorities = {1, 1, 9, 1, 1, 1};
        Assertions.assertEquals(5, this.solution(priorities, 0));
    }
}
