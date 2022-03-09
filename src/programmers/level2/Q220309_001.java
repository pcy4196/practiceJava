package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Queue;

public class Q220309_001 {

    // 프로그래머스 LEVEL2 멀쩡한 사각형
    // 문제 URL : https://programmers.co.kr/learn/courses/30/lessons/62048

    /*
    가로 : 2, 세로 : 3
    최대공약수 : 1
    사용못하는 사각형 : 2 + 3 - 1 = 4
    사용가능 사각형 : 2

    가로 : 8, 세로 : 12
    최대공약수 : 4
    사용못하는 사각형 : 8 + 12 - 4 = 16
    사용가능 사각형 : 96 - 16 = 60
    */
    public long solution(int w, int h) {
        long answer = 1;
        int gcp = gcp(Math.max(w, h), Math.min(w, h));
        // answer 값이 long 이기 때문에 long type으로 casting 필수
        Long lGcp = Long.valueOf(gcp);
        Long lw = Long.valueOf(w);
        Long lh = Long.valueOf(h);
        answer = (lw * lh) - (lw + lh - lGcp - 1);
        return answer;
    }

    // 유클리드 호제법(최대공약수 추출) --> 재귀함수 사용
    private int gcp(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcp(b, a % b);
        }
    }

    @Test
    public void testSolution() {
        Assertions.assertEquals(solution(2, 3), 2);
        Assertions.assertEquals(solution(8, 12), 80);
    }
}
