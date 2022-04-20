package programmers.level2;

import org.junit.jupiter.api.Assertions;
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

        for (int i = 0; i < dist.length; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }

        return answer;
    }

    private int[] dijkstra(ArrayList<ArrayList<Node>> nodeInfo, int[] dist, int start, int N) {
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        
        while (!pq.isEmpty()) {
            // 우선순위 큐에서 최고 앞에 있는 값 추출
            Node node = pq.poll();

            // dist 변수가 작으면 nodeInfo 탐색 X
            if (dist[node.edge] < node.distance) {
                continue;
            }

            for (Node next : nodeInfo.get(node.edge)) {
                // dist 변수에 저장된 기준이되는 마을까지의 거리보다
                // next + node 와의 거리를 비교하여 작다면
                // dist 변수 변경 및 우선순위큐 새로운 값 추가
                if(dist[next.edge] > node.distance + next.distance) {
                    dist[next.edge] = node.distance + next.distance;
                    // next.edge 마을까지 거리 새롭게 정의
                    pq.offer(new Node(next.edge, node.distance + next.distance));
                }
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
        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        Assertions.assertEquals(4, this.solution(5, road, 3));
//        int[] priorities = {1, 1, 9, 1, 1, 1};
//        Assertions.assertEquals(5, this.solution(priorities, 0));
    }
}
