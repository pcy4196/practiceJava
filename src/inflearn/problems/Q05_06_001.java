package inflearn.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q05_06_001 {

    // 인프런(inflearn) - 공주 구하기
    // 문제 URL : https://cote.inflearn.com/contest/10/problem/05-06

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());           // N명의 왕자
        int K = Integer.parseInt(st.nextToken());           // 특정숫자 : K

        // 큐를 이용한 문제풀이
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        // 입력 값 확인
        // System.out.println(Arrays.toString(queue.toArray()));

        int cnt = 0;    // 번호를 외치는 횟수를 담는 변수 선언
        // 한명의 왕자가 남을때까지 반복문 수행
        while (queue.size() != 1) {
            cnt++;
            // 특정숫자를 외치는 경우
            if (cnt % K == 0) {
                // 특정숫자를 외치는 경우 제외 처리
                queue.poll();
            } else {
                // 특정숫자를 외치지 않으면 queue 제일 뒤에 추가
                Integer prin = queue.poll();
                queue.add(prin);
            }
        }

        System.out.println(queue.poll());
    }

}
