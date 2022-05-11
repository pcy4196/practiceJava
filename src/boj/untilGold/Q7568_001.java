package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q7568_001 {

    // 백준(BOJ) SILVER5 덩치
    // 문제 URL : https://www.acmicpc.net/problem/7568

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 비교할 사람의 수
        ArrayList<Pinfo> pList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());  // 몸무게
            int height = Integer.parseInt(st.nextToken());  // 키
            pList.add(new Pinfo(weight, height));
        }

        for (int i = 0; i < N; i++) {
            int rank = 1;
            Pinfo pinfo = pList.get(i);

            for (int j = 0; j < N; j++) {
                if (i == j) continue; // 자기자신과는 비교를 할필요 없으므로 skip 처리
                Pinfo pinfo2 = pList.get(j);
                // 기준이 되는 사람이 비교되는 사람보다 덩치(키,몸무게)가 작다면
                if (pinfo.height < pinfo2.height
                 && pinfo.weight < pinfo2.weight) {
                    rank++;
                }
            }

            System.out.print(rank + " ");
        }
    }

    // 사람의 정보를 저장하는 class 변수
    static class Pinfo {
        int weight;
        int height;

        public Pinfo(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }
}
