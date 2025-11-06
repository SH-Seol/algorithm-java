package bj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);//3
        int m = Integer.parseInt(strs[1]);//10
        int[] coins = new int[n];//1 2 5
        int[] dp = new int[m+1];
        for(int i=0;i<n;i++){
            coins[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 1;
        for(int coin:coins){
            for(int i = coin; i <= m; i++){
                dp[i] += dp[i-coin];
            }
        }
        System.out.println(dp[m]);
    }
}
