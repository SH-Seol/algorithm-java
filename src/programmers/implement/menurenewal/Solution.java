package programmers.implement.menurenewal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    Map<String, Integer> map = new HashMap<>();
    int[] max = new int[11];
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        for(int i = 0; i < orders.length; i++) {
            char[] chars = orders[i].toCharArray();
            Arrays.sort(chars);
            StringBuilder sb = new StringBuilder();
            sol(chars, sb, 0);
        }
        for(String key : map.keySet()) {
            if(max[key.length()] == 1){
                continue;
            }
            for(int len : course){
                if(key.length() == len && map.get(key) == max[key.length()]){
                    answer.add(key);
                }
            }
        }
        String[] answerArr = new String[answer.size()];
        answerArr = answer.toArray(answerArr);
        Arrays.sort(answerArr);
        return answerArr;
    }
    //n개 맞춰서 채우면 그 값을 map에 넣으면 됨, 조합은 재귀로
    //ans는 String 배열, n은 현재 ans의 몇번째 인덱스인지, m은 현재 쌓은 값의 크기
    public void sol(char[] chars, StringBuilder sb, int idx){
        if(sb.length() >= 2){
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            max[sb.length()] = Math.max(max[sb.length()], map.get(sb.toString()));
        }
        for(int i = idx; i < chars.length; i++) {
            sb.append(chars[i]);
            sol(chars, sb, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}