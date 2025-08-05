package programmers.array.MatchingNumbers;

public class Solution {
    public String solution(String X, String Y) {
        int[] xCounts = new int[10];
        int[] yCounts = new int[10]; // 0~9까지 개수 입력해야함
        for(int i = 0; i < X.length(); i++) {
            if(Character.isDigit(X.charAt(i))) {
                xCounts[X.charAt(i) - '0']++;
            }
        }
        for(int i = 0; i < Y.length(); i++) {
            if(Character.isDigit(Y.charAt(i))) {
                yCounts[Y.charAt(i) - '0']++;
            }
        }
        StringBuilder answer = new StringBuilder();
        for(int i = 9; i >= 0; i--){
            int cnt = Math.min(xCounts[i], yCounts[i]);//0~9까지 겹치는 수를 나열함
            for(int j = 0; j < cnt; j++){
                answer.append(i);
            }
        }
        String result = answer.toString();

        //겹치는 수가 없어 결과값이 비어있는 경우
        if(result.isEmpty()) {
            return "-1";
        }

        //겹치는 수가 0밖에 없는 경우
        if(result.charAt(0) == '0') {
            return "0";
        }
        return result;
    }
}
