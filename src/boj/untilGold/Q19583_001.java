package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q19583_001 {

    // 백준(BOJ) SILVER2 싸이버개강총회
    // 문제 URL : https://www.acmicpc.net/problem/19583

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String, String> map = new HashMap<>();
        String S = st.nextToken().replace(":", "");       // 개강총회를 시작한 시간 S
        String E = st.nextToken().replace(":", "");       // 개강총회를 끝낸 시간 E
        String Q = st.nextToken().replace(":", "");       // 개강총회 스트리밍을 끝낸 시간 Q

//        String line = null;
//        while ((line = br.readLine()) != null) {
//            st = new StringTokenizer(line);
//
//        }
        System.out.println(S);
        System.out.println(E);
        System.out.println(Q);
    }
}
