package programmers.implement.insa;

import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        int x = scores[0][0];
        int y = scores[0][1];
        int res = x + y;
        int maxY = 0;

        Arrays.sort(scores, (a, b) -> {
            if(a[0] != b[0]){
                return Integer.compare(b[0], a[0]);
            }
            else{
                return Integer.compare(a[1], b[1]);
            }
        });

        //첫번째는 내림차순, 2번째는 오름차순
        for(int i = 0; i < scores.length; i++){
            maxY = Math.max(maxY, scores[i][1]);

            if(scores[i][1] < maxY){
                if(scores[i][0] == x && scores[i][1] == y){
                    return -1;
                }
                // 완호가 아니면 그냥 등수 계산에서 제외하고 스킵
                continue;
            }

            if(scores[i][0] + scores[i][1] > res){
                answer++;
            }
        }

        return answer + 1;
    }
}
