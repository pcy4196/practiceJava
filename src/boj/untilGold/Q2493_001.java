package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q2493_001 {

    // 백준(BOJ) GOLD5 탑
    // 문제 URL : https://www.acmicpc.net/problem/2493

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 탑의수
        int N = Integer.parseInt(st.nextToken());
        // 탑의정보를 저장하는 stack 변수
        Stack<Top> stack = new Stack<>();
        st = new StringTokenizer(br.readLine());

        // 시간초과가 발생하지 않기 위해서 값을 받으면서 처리
        for (int i = 1; i <= N; i++) {
            int topHeight = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty()) {
                if (stack.peek().height >= topHeight) {
                    System.out.print(stack.peek().location + " ");
                    break;
                }
                stack.pop();
            }
            // stack에 값이 없다면 0 출력
            if (stack.isEmpty()) {
                System.out.print(0 + " ");
            }
            // 출력이 끝나고 나면 현재 탑정보 stack에 추가
            stack.push(new Top(i, topHeight));
        }
    }

    static class Top {
        int location;
        int height;

        public Top(int location, int height) {
            this.location = location;
            this.height = height;
        }
    }
}
