package programmers.implement.minerals;

import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int total = picks[0] + picks[1] + picks[2];
        int answer = 0;
        //0은 총 피로도, 1은 다이아, 2는 철, 3은 돌
        int[][] lst = new int[total + 1][4];
        int idx = 0;
        int sum = 0;
        int cnt = 0;
        for(int i = 0; i < minerals.length; i++){
            if(total * 5 == i){
                break;
            }
            if(minerals[i].equals("diamond")){
                sum += 25;
                lst[idx][1]++;
            }
            else if(minerals[i].equals("iron")){
                sum += 5;
                lst[idx][2]++;
            }
            else if(minerals[i].equals("stone")){
                sum += 1;
                lst[idx][3]++;
            }
            if(i % 5 == 4){
                lst[idx][0] = sum;
                sum = 0;
                idx++;
            }
        }
        if(sum != 0){
            lst[idx][0] = sum;
        }

        Arrays.sort(lst, (a,b) -> b[0] - a[0]);

        for(int i = 0; i <= idx; i++){
            //다이아 곡괭이가 존재하면
            if(picks[0] > 0){
                picks[0]--;
                //각 광물 개수 더하기
                answer += lst[i][1] + lst[i][2] + lst[i][3];
            }
            //철 곡괭이가 존재하면
            else if(picks[1] > 0){
                picks[1]--;
                answer += lst[i][1] * 5 + lst[i][2] + lst[i][3];
            }
            else{
                picks[2]--;
                answer += lst[i][0];
            }
        }

        return answer;
    }
}
