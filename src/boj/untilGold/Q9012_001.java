package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q9012_001 {

    // 백준(BOJ) SILVER4 괄호
    // 문제 URL : https://www.acmicpc.net/problem/9012

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 입력 데이터의 수
        int N = Integer.parseInt(st.nextToken());
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < N; i++) {
            // 문자열 하나씩 추출
            String str = br.readLine();
            // 괄호 문자열 확인하기 위한 stack 초기화
            stack.clear();
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '(') {
                    stack.push(str.charAt(j));
                } else {
                    if (stack.isEmpty()) {
                        // 처음으로 ')' 글자가 오면 VPS 아니기 때문에 for문 종료
                        // stack이 비어있으면 VPS 이기 때문에 stack에 값 하나 설정
                        stack.add(str.charAt(j));
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if (stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
