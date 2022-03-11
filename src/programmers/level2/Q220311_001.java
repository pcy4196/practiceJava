package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q220311_001 {

    // 프로그래머스 LEVEL2 멀쩡한 사각형 - 2
    // 문제 URL : https://programmers.co.kr/learn/courses/30/lessons/62048

    /*
    가로 : 2, 세로 : 3
    최대공약수 : 1
    사용못하는 사각형 : ((2/1) + (3/1) - 1)  * 1 = 4
    사용가능 사각형 : 2

    가로 : 8, 세로 : 12
    최대공약수 : 4
    사용못하는 사각형 : ((8/4) + (12/4) - 1) * 4 = 16
    사용가능 사각형 : 96 - 16 = 60
    */
    public long solution(int w, int h) {
        long answer = 1;
        int gcp = gcp(Math.max(w, h), Math.min(w, h));
        // answer 값이 long 이기 때문에 long 형태로 casting 필수
        Long lGcp = Long.valueOf(gcp);
        Long lw = Long.valueOf(w);
        Long lh = Long.valueOf(h);
        answer = (lw * lh) - (((lw/lGcp) + (lh/lGcp) - 1) * lGcp);
        return answer;
    }

    // 유클리드 호제법(최대공약수 추출) --> while 문 사용
    private int gcp(int a, int b) {
        int temp;
        while (a % b != 0) {
            temp = a % b;
            a = b;
            b = temp;
        }
        return b;
    }

    @Test
    public void testSolution() {
        Assertions.assertEquals(solution(2, 3), 2);
        Assertions.assertEquals(solution(8, 12), 80);
    }
}
