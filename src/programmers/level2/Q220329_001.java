package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

public class Q220329_001 {

    // 프로그래머스 LEVEL2 행렬 테두리 회전하기
    // 문제 URL : https://programmers.co.kr/learn/courses/30/lessons/77485

    public int[] solution(int rows, int columns, int[][] queries) {
        // 답 배열 선언
        int[] answer = new int[queries.length];
        // 행렬에 넣을 숫자 선언
        int num = 1;
        // 행렬 선언
        int[][] matrix = new int[rows+1][columns+1];
        // 행렬에 숫자 초기화
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                matrix[i][j] = num;
                num++;
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int[] action = queries[i];  // 2,2,5,4 --> 1
            int x1 = action[0];
            int y1 = action[1];
            int x2 = action[2];
            int y2 = action[3];
            // 가로로 움직이는 길이
            int w = y2 - y1 + 1;
            // 세로로 움직이는 길이
            int h = x2 - x1 - 1;
            int tempMinNum = num;
            // 가로(행) 숫자 변형 구현
            for (int j = 0; j < w; j++) {
                if (j == 0) {
                    matrix[x1][y1] = matrix[x1][y1] + rows;
                    matrix[x2][y2] = matrix[x2][y2] - rows;
                    int minNum = Math.min(matrix[x1][y1], matrix[x2][y2]);
                    tempMinNum = Math.min(minNum, tempMinNum);
                } else {
                    matrix[x1][y1+j] = matrix[x1][y1+j] - 1;
                    matrix[x2][y2-j] = matrix[x2][y2-j] + 1;
                    int minNum = Math.min(matrix[x1][y1+j], matrix[x2][y2-j]);
                    tempMinNum = Math.min(minNum, tempMinNum);
                }
            }
            // 1보다 클경우에만 수행
            // 세로(열) 숫자 변형
            if (h > 0) {
                for (int j = 1; j <= h; j++) {
                    matrix[x1+j][y1] = matrix[x1+j][y1] + rows;
                    matrix[x2-j][y2] = matrix[x2-j][y2] - rows;
                    int minNum = Math.min(matrix[x1+j][y1], matrix[x2-j][y2]);
                    tempMinNum = Math.min(minNum, tempMinNum);
                }
            }

            answer[i] = tempMinNum;
        }

        return answer;
    }

    @Test
    public void testSolution() {
        // 6, 6, [[2,2,5,4],[3,3,6,6],[5,1,6,3]], [8, 10, 25]
        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
//        int[][] queries = {{2,2,5,4}};
        int[] answer = {8, 10, 25};
//        int[] answer = {8};
        Assertions.assertArrayEquals(answer, this.solution(6, 6, queries));
    }
}
