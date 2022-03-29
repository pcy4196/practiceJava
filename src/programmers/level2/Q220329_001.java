package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q220329_001 {

    // 프로그래머스 LEVEL2 행렬 테두리 회전하기
    // 문제 URL : https://programmers.co.kr/learn/courses/30/lessons/77485

    public int[] solution(int rows, int columns, int[][] queries) {
        // 답 배열 선언
        int[] answer = new int[queries.length];
        // 행렬에 넣을 숫자 선언
        int num = 0;
        // 행렬 선언
        int[][] matrix = new int[rows+1][columns+1];
        // 행렬에 숫자 초기화
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                matrix[i][j] = ++num;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotate(queries[i], matrix);
        }

        return answer;
    }

    // 테두리 회전 변수
    private int rotate(int[] query, int[][] matrix) {
        // 이동변수 초기화
        int x1 = query[0];
        int y1 = query[1];
        int x2 = query[2];
        int y2 = query[3];
        int temp = matrix[x1][y1];    // matrix[2][2] - 임시 저장(마지막 남는 숫자)
        int min = temp;
        // 왼쪽면
        for (int i = x1; i < x2; i++) {
            // 2,2 = 3,2
            // 3,2 = 4,2
            // 4,2 = 5,2
            matrix[i][y1] = matrix[i+1][y1];
            // 새로 할당된 숫자 최소값과 비교
            if (min > matrix[i][y1])
                min = matrix[i][y1];
        }
        // 밑면
        for (int i = y1; i < y2; i++) {
            // 5,2 = 5,3
            // 5,3 = 5,4
            matrix[x2][i] = matrix[x2][i+1];
            if (min > matrix[x2][i])
                min = matrix[x2][i];
        }
        // 오른쪽면
        for (int i = x2; i > x1; i--) {
            // 5,4 = 4,4
            // 4,4 = 3,4
            // 3,4 = 2,4
            matrix[i][y2] = matrix[i-1][y2];
            if (min > matrix[i][y2])
                min = matrix[i][y2];
        }
        // 윗면
        for (int i = y2; i > y1+1; i--) {
            // 2,4 = 2,3
            // 2,3 = 2,2 --> 해당 데이터는 temp로 처리
            matrix[x1][i] = matrix[x1][i-1];
            if (min > matrix[x1][i])
                min = matrix[x1][i];
        }
        matrix[x1][y1+1] = temp;

        return min;
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
