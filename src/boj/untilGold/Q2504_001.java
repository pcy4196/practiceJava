package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q2504_001 {

    // 백준(BOJ) SILVER1 괄호의 값
    // 문제 URL : https://www.acmicpc.net/problem/2504

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        // 해당문제는 괄호를 다풀어서 계산하는 방식으로 접근필요
        System.out.println(solveSymbol(str));
    }

    // 괄호의 값을 계산하는 메서드
    private static int solveSymbol(String str) {
        int answer  = 0;
        int mAnswer = 1;    // 괄호가 진행되는 과정중에 저장하는 변수값
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '[') {
                stack.add(str.charAt(i));
                mAnswer *= 3;
            } else if (str.charAt(i) == '(') {
                stack.add(str.charAt(i));
                mAnswer *= 2;
            } else if (str.charAt(i) == ']') {
                if (!stack.isEmpty() && stack.pop() == '[') {
                    // stack이 비어있지 않고 stack에서 꺼낸값으로 괄호가 닫히면
                    // 아래와 같이 진행
                    if (str.charAt(i - 1) == '[') {
                        // 이전값이 '[' 이면 계산하여 저장한 변수값 정답에 포함
                        answer += mAnswer;
                    }
                    // 괄호가 닫힐때마다 저장한 변수값 나눗셈
                    mAnswer /= 3;
                } else {
                    return 0;
                }
            } else if (str.charAt(i) == ')') {
                if (!stack.isEmpty() && stack.pop() == '(') {
                    // stack이 비어있지 않고 stack에서 꺼낸값으로 괄호가 닫히면
                    // 아래와 같이 진행
                    if (str.charAt(i - 1) == '(') {
                        // 이전값이 '[' 이면 계산하여 저장한 변수값 정답에 포함
                        answer += mAnswer;
                    }
                    // 괄호가 닫힐때마다 저장한 변수값 나눗셈
                    mAnswer /= 2;
                } else {
                    return 0;
                }
            }
        }
        if (stack.isEmpty()) {
            return answer;
        } else {
            return 0;
        }
    }


}
