package programmers.implement.sticker;

class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        if(sticker.length == 1){
            return sticker[0];
        }
        else if(sticker.length == 2){
            return Math.max(sticker[0], sticker[1]);
        }
        else if(sticker.length == 3){
            return Math.max(Math.max(sticker[0], sticker[1]), sticker[2]);
        }

        int[][] dp = new int[sticker.length][3];

        dp[0][0] = sticker[0];
        dp[1][1] = sticker[1];
        dp[2][2] = sticker[2];
        dp[2][0] = dp[0][0] + sticker[2];

        for(int i = 3; i < sticker.length; i++){
            //마지막 위치인 경우
            if(i == sticker.length - 1){
                dp[i][1] = Math.max(dp[i - 2][1], dp[i - 3][1]) + sticker[i];
                dp[i][2] = Math.max(dp[i - 2][2], dp[i - 3][2]) + sticker[i];
                answer = Math.max(answer, Math.max(dp[i][1], dp[i][2]));
            }
            //그 외
            else{
                dp[i][0] = Math.max(dp[i - 2][0], dp[i - 3][0]) + sticker[i];
                dp[i][1] = Math.max(dp[i - 2][1], dp[i - 3][1]) + sticker[i];
                dp[i][2] = Math.max(dp[i - 2][2], dp[i - 3][2]) + sticker[i];

                answer = Math.max(Math.max(answer, dp[i][0]), dp[i][1]);
                answer = Math.max(dp[i][2], answer);
            }

        }


        return answer;
    }
}
