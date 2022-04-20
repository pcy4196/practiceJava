package programmers.level2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Q220420_001 {

    // 프로그래머스 LEVEL2 배달
    // 문제 URL : https://programmers.co.kr/learn/courses/30/lessons/12978

    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        // 기준마을부터 떨어진 거리 저장하는 변수 선언 및 초기화
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 마을 거리정보 저장하는 변수 선언
        ArrayList<ArrayList<Node>> nodeInfo = new ArrayList<>();
        for (int i = 0; i <= N ; i++) {
            nodeInfo.add(new ArrayList<>());
        }
        // 마을 거리정보 데이터 적재
        for (int i = 0; i < road.length; i++) {
            int start = road[i][0];     // 시작
            int end = road[i][1];       // 종료
            int distance = road[i][2];  // 거리

            nodeInfo.get(start).add(new Node(end, distance));
            nodeInfo.get(end).add(new Node(start, distance));
        }

        dist = dijkstra(nodeInfo, dist, 1, N);

        return answer;
    }

    private int[] dijkstra(ArrayList<ArrayList<Node>> nodeInfo, int[] dist, int start, int N) {
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        
        while (!pq.isEmpty()) {
            Node node = pq.poll();

            // dist 변수가 작으면 nodeInfo 탐색 X
            if (dist[node.edge] < node.distance) {
                continue;
            }

            for (Node next : nodeInfo.get(node.edge)) {
                
            }
            
        }
        
        return dist;
    }

    class Node implements Comparable<Node> {
        int edge;
        int distance;

        public Node(int edge, int distance) {
            this.edge = edge;
            this.distance = distance;
        }

        // 우선순위 알고리즘을 사용하기 위해서 선언
        @Override
        public int compareTo(Node node) {
            return this.distance - node.distance;
        }
    }


    @Test
    public void testSolution() {
//        int[] priorities = {2, 1, 3, 2};
//        Assertions.assertEquals(1, this.solution(priorities, 2));
//        int[] priorities = {1, 1, 9, 1, 1, 1};
//        Assertions.assertEquals(5, this.solution(priorities, 0));
    }
}
