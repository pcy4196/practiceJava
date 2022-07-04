package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q19583_001 {

    // 백준(BOJ) SILVER2 싸이버개강총회
    // 문제 URL : https://www.acmicpc.net/problem/19583

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        HashSet<String> in = new HashSet<>();       // 입장
        HashSet<String> out = new HashSet<>();      // 퇴장
        HashSet<String> name = new HashSet<>();     // 회원아이디

        String[] fLine = sc.nextLine().split(" ");
        String S = fLine[0].replace(":", "");   // 개강총회 시작
        String E = fLine[0].replace(":", "");   // 개강총회 종료
        String Q = fLine[0].replace(":", "");   // 스트리밍 종료
        while(sc.hasNextLine()) {
            String[] input = sc.nextLine().split(" ");
            if (input.length > 1) {
                name.add(input[1]);
                String time = input[0].replace(":", "");
                if (time.compareTo(S) <= 0) {
                    in.add(input[1]);
                } else if (time.compareTo(E) >= 0
                        && time.compareTo(Q) >= 0) {
                    out.add(input[1]);
                }
            }
        }

        int answer = 0;
        for (String s : name) {
            if (in.contains(s) && out.contains(s)) {
                answer++;   // 회원아이디가 입장, 퇴장 둘다 있을 경우
            }
        }

        System.out.println(answer);
    }
}
