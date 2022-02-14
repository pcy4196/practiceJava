package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q220214_001 {

    // 프로그래머스 LEVEL2 오픈 채팅방
    // 문제 URL : https://programmers.co.kr/learn/courses/30/lessons/42888

    public String[] solution(String[] record) {
        // user 닉네임
        HashMap<String, String> userNick = new HashMap<>();
        // action 을 담는 List
        List<String> action = new ArrayList<>();
        // record 잠시 담아두는 변수(ex : "Enter uid1234 Muzi")
        String[] tempRecrd  = null;

        // record 문자열이 담긴 배열
        for (String s : record) {
            // 띄어쓰기 기준으로 문자열을 분리
            tempRecrd = s.split(" ");

            if ("Enter".equals(tempRecrd[0])) {
                // Enter action 일때
                action.add(tempRecrd[1]+"님이 들어왔습니다.");
                if (tempRecrd.length > 2) {
                    // id별 닉네임 설정(마지막으로 설정한 별명 저장하는 map)
                    userNick.put(tempRecrd[1], tempRecrd[2]);
                }
            } else if ("Leave".equals(tempRecrd[0])) {
                // Leave action 일때
                action.add(tempRecrd[1]+"님이 나갔습니다.");
            } else {
                // Change action 일때
                if (tempRecrd.length > 2) {
                    // id별 닉네임 설정(마지막으로 설정한 별명 저장하는 map)
                    userNick.put(tempRecrd[1], tempRecrd[2]);
                }
            }
        }
        String[] answer = new String[action.size()];
        String tempId = "";
        String tempStr = "";
        for (int i = 0; i < action.size(); i++) {
            // action 리스트의 한줄을 가져온다.
            tempStr = action.get(i);
            // id 값 추출(ex : uid1234)
            tempId = tempStr.substring(0, tempStr.indexOf("님"));
            // id값을 닉네임으로 변경
            answer[i] = tempStr.replace(tempId, userNick.getOrDefault(tempId, "그림자"));
        }
        return answer;
    }

    @Test
    public void testSolution() {
        String[] record = {"Enter uid1234 Muzi","Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] answer = solution(record);
        String[] expecAns = {"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."};
        for (int i = 0; i < expecAns.length; i++) {
            Assertions.assertArrayEquals(expecAns, answer);
        }

    }
}
