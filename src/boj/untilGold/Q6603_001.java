package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q6603_001 {

    // 백준(BOJ) SILVER2 로또
    // 문제 URL : https://www.acmicpc.net/problem/6603

    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Integer[] arr;
        ArrayList<Integer[]> list = new ArrayList<>();
        while (true) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if (k == 0) {
                break;
            } else {
                arr = new Integer[k];
                for (int i = 0; i < k; i++) {
                    arr[i] = Integer.parseInt(st.nextToken());
                }
                list.add(arr);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            Integer[] arrVar = list.get(i);
            for (int j = 0; j < arrVar.length; j++) {
                System.out.print(arrVar[j] + " ");
            }
            System.out.println();
        }
    }

}
