package boj.untilGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q1931_001 {

    // 백준(BOJ) SILVER1 회의실 배정
    // 문제 URL : https://www.acmicpc.net/problem/1931

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());       // 회의의 수
        ArrayList<MeetInfo> list = new ArrayList<>();   // 회의실 정보를 가지는 있는 list 변수
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new MeetInfo(start, end));
        }

        // list 정렬 처리
        Collections.sort(list);
//        for (MeetInfo meetInfo : list) {
//            System.out.println(meetInfo.start + " / " + meetInfo.end);
//        }

        int answer = 0;
        int endTime = Integer.MIN_VALUE;
        for (MeetInfo meetInfo : list) {
            if (meetInfo.start >= endTime) {
                // 회의의 시작시간이 종료시간보다 클 경우
                // 회의의 수 증가(정답변수)
                answer++;
                // 회의 종료 시간 변경
                endTime = meetInfo.end;
            }
        }

        // 정답출력
        System.out.println(answer);
    }

    // 회의실 정보를 가지는 있는 Class
    static class MeetInfo implements Comparable<MeetInfo> {
        int start;
        int end;

        public MeetInfo(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(MeetInfo meetInfo) {
            if (this.end == meetInfo.end) {
                return this.start - meetInfo.start;
            } else {
                return this.end - meetInfo.end;
            }
        }
    }
}
