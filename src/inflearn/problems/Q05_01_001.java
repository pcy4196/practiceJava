package inflearn.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q05_01_001 {

    // 인프런(inflearn) - 올바른 괄호
    // 문제 URL : https://cote.inflearn.com/contest/10/problem/05-01

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = "NO";                           // 정답 출력 변수
        char[] chArs = br.readLine().toCharArray();     // 배열로 전환한 괄호 문자열
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chArs.length ; i++) {
            if (chArs[i] == '(') {
                stack.push(chArs[i]);
            } else {
                if (stack.size() == 0) {
                    stack.push(chArs[i]);
                    break;
                } else {
                    stack.pop();
                }
            }
        }

        if (stack.size() == 0) {
            answer = "YES";
        } else {
            answer = "NO";
        }

        System.out.println(answer);
    }

}
