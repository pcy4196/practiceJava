package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q7568_001 {

    // 백준(BOJ) SILVER5 덩치
    // 문제 URL : https://www.acmicpc.net/problem/7568

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<Pinfo> plist = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            plist.add(new Pinfo(i, weight, height));
        }

        Collections.sort(plist);

        for (Pinfo pinfo : plist) {
            System.out.println(pinfo);
        }

    }
    
    // 사람정보를 가지고 있는 class 변수
    static class Pinfo implements Comparable<Pinfo>{
        int name;
        int weight;
        int height;
        int rank;

        public Pinfo(int name, int weight, int height) {
            this.name = name;
            this.weight = weight;
            this.height = height;
        }

        @Override
        public String toString() {
            return "Pinfo{" +
                    "name=" + name +
                    ", height=" + height +
                    ", weight=" + weight +
                    ", rank=" + rank +
                    '}';
        }

        @Override
        public int compareTo(Pinfo pinfo) {
            return pinfo.weight - this.height;
        }
    }

}
