package programmers.hash.marathon;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        String answer = "";
        //완주한 인원을 먼저 hashmap에 key: 이름, value: 인원 수 의 형태로 넣어준다.
        for(String c: completion) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //참가자들을 바탕으로 돌려서 key인 이름을 바탕으로 value인 인원 수를 줄여가는 과정
        //만약 인원 수가 0인 경우 해당 인원이 완주를 하지 않은 것
        for(String p: participant) {
            int num = map.getOrDefault(p, 0);
            if(num > 0) {
                map.put(p, map.get(p) -1);
            }
            else{
                answer = p;
                break;
            }
        }
        return answer;
    }
}


