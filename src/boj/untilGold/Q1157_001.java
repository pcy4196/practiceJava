package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Q1157_001 {

    // 백준(BOJ) SILVER1 단어 공부
    // 문제 URL : https://www.acmicpc.net/problem/1157

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase();           // 대소문자로 이루어진 단어
        HashMap<Character, Integer> map = new HashMap<>();
        // 단어별로 회차의 최고값을 담는 변수
        int maxCnt = 0;
        for (int i = 0; i < str.length(); i++) {
            // HashMap에 단어별로 사용회차 저장
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
            maxCnt = Math.max(maxCnt, map.get(str.charAt(i)));
        }

        // 최대값을 저장하는 list 선언
        ArrayList<Character> list = new ArrayList<>();
        for (Character ch : map.keySet()) {
            if (map.get(ch) == maxCnt) {
                list.add(ch);
            }
        }

        // 정답(단어) 출력
        if (list.size() > 1) {
            System.out.println('?');
        } else {
            System.out.println(list.get(0));
        }

    }

}
