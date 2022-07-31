package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9093_001 {

    // 백준(BOJ) BRONZE1 단어 뒤집기
    // 문제 URL : https://www.acmicpc.net/problem/6603

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        String[] arr = new String[T];
        for (int i = 0; i < T; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < T; i++) {
            String[] tmp = arr[i].split(" ");
            StringBuilder prinStr = new StringBuilder();
            for (String s : tmp) {
                StringBuilder sb = new StringBuilder();
                prinStr.append(" ").append(sb.append(s).reverse());
            }
            System.out.println(prinStr.substring(1).toString());
        }
    }

}
