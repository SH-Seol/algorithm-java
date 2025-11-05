package bj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2240 {
    public static void main(String[] args) throws IOException {
        int n,m;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sts = br.readLine().split(" ");
        n = Integer.parseInt(sts[0]);
        m = Integer.parseInt(sts[1]);
        int[][] dp = new int[n+1][m+1];
        int num = Integer.parseInt(br.readLine());
        if(num == 1){
            dp[1][0] = 1;
        }
        if(num == 2){
            dp[1][1] = 1;
        }
        for(int i=2;i<=n;i++){
            num = Integer.parseInt(br.readLine()); // 1 or 2
            for(int j=0;(j<=m && i >= j);j++){
                if(j == 0){ // 이동한 적 없이 1에 계속 있는 경우
                    dp[i][j] = (num == 1) ? dp[i-1][j] + 1 : dp[i-1][j];
                }
                else{
                    if(j % 2 == 1){//이동 횟수 홀수 -> 현재 위치 2
                        if(num == 1){
                            dp[i][j] = dp[i-1][j];
                        }
                        else{//num == 2인 경우
                            dp[i][j] = Math.max(dp[i-1][j] + 1, dp[i-1][j-1] + 1);
                        }
                    }
                    else{//이동 횟수 짝수 -> 현재 위치 1
                        if(num == 1){
                            dp[i][j] = Math.max(dp[i-1][j] + 1, dp[i-1][j-1] + 1);
                        }
                        else{//num == 2인 경우
                            dp[i][j] = dp[i-1][j];
                        }
                    }
                }
            }
        }
        int ans = 0;
        for(int i = 0; i <= m; i++){
            ans = Math.max(ans, dp[n][i]);
        }
        System.out.println(ans);
    }
}
