package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

public class Q220326_001 {

    // 프로그래머스 LEVEL2 더 맵게
    // 문제 URL : https://programmers.co.kr/learn/courses/30/lessons/42626

    public int solution(int[] scoville, int K) {
        // 우선순위를 사용하여 해당문제 해결가능
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 우선순위큐에 값 설정
        for (Integer i : scoville) {
            pq.offer(i);
        }
        // 제일 작은 매운맛이 기준보다 크면 0 반환
        if (pq.peek() >= K) {
            return 0;
        }
        int minCnt = 0;     // 섞는 횟수
        while (pq.peek() < K) {
            if (pq.size() == 1) {
                return -1;
            }
            int a = pq.poll();
            int b = pq.poll();

            int result = a + (b * 2);
            minCnt++;

            pq.offer(result);
        }
        return minCnt;
    }

    @Test
    public void testSolution() {
        // [1, 2, 3, 9, 10, 12]	7 2
        int[] scoville = {1, 2, 3, 9, 10, 12};
        Assertions.assertEquals(2, this.solution(scoville, 7));
    }
}
