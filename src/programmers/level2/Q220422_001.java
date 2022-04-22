package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Q220422_001 {

    // 프로그래머스 LEVEL2 다리를 지나는 트럭
    // 문제 URL : https://programmers.co.kr/learn/courses/30/lessons/42583

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        // 다리위에 있는 트럭
        Queue<Integer> brideQ = new LinkedList<>();

        int goneTruck = 0;      // 지나간 트럭 수
        int sumWeight = 0;      // 다리에 있는 트럭 무게

        while (true) {

            if (brideQ.isEmpty()) {
                answer++;
                brideQ.offer(truck_weights[goneTruck]);
                sumWeight += truck_weights[goneTruck];
                goneTruck++;    // 대기중에서 다리로 지나간 트럭 수 증가
            } else {

                // 트럭이 다리로 다 지나갔으면 while문 종료
                if (goneTruck == truck_weights.length)
                    break;

                // 다리에 있는 트럭이 다리를 지나갈거 같으면 총무게 트럭만큼 제외
                if (brideQ.size() == bridge_length) {
                    sumWeight -= brideQ.poll();
                }

                // 다음순서의 트럭을 합쳐도 다리무게의 허용범위 일 경우
                if (sumWeight + truck_weights[goneTruck] <= weight) {
                    answer++;
                    sumWeight += truck_weights[goneTruck];
                    brideQ.offer(truck_weights[goneTruck]);
                    goneTruck++;        // 대기중에서 다리로 지나간 트럭 수 증가
                // 허용범위를 넘겼을 경우에는 트럭이 지나갈때까지 대기
                } else {
                    answer++;
                    brideQ.offer(0);
                }

            }
        }

        // 마지막 트럭이 다리에 올라간 상태에서 다리의 길이를 더해주면, 모든 트럭이 통과하는데 걸린 시간.
        return answer + bridge_length;
    }

    @Test
    public void testSolution() {
//        int[] truck_weights = {7,4,5,6};
//        Assertions.assertEquals(8, this.solution(2, 10, truck_weights));
//        int[] truck_weights = {10};
//        Assertions.assertEquals(101, this.solution(100, 100, truck_weights));
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
        Assertions.assertEquals(110, this.solution(100, 100, truck_weights));
    }
}
