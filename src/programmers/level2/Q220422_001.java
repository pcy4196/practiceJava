package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Q220422_001 {

    // 프로그래머스 LEVEL2 다리를 지나는 트럭
    // 문제 URL : https://programmers.co.kr/learn/courses/30/lessons/42583

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        // Queue 선언 및 데이터 적립
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < truck_weights.length; i++) {
            queue.offer(truck_weights[i]);
        }
        while (!queue.isEmpty()) {

        }
        return answer;
    }


    @Test
    public void testSolution() {
//        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
//        Assertions.assertEquals(4, this.solution(5, road, 3));
    }
}
