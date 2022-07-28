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
        // 여러 개의 테스트 케이스 담기 위한 리스트 변수 선언
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
            visited = new int[list.get(i).length];
            DFS(list.get(i), 0, 0);
            System.out.println();
        }
    }

    private static void DFS(Integer[] arr, int L, int S) {
        if (L == 6) {
            for (int i = 0; i < visited.length; i++) {
                if (visited[i] == 1) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
        } else {
            for (int i = S; i < arr.length; i++) {
                if (visited[i] == 0) {
                    visited[i] = 1;
                    DFS(arr, L+1, i+1);
                    visited[i] = 0;
                }
            }
        }
    }

}
