package bj.dp;

import java.util.Scanner;

public class BOJ11057 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[n+1][11];
        for(int i = 0; i < 10; i++){
            dp[1][i] = 1;
        }
        dp[1][10] = 10;
        for(int i = 2; i <= n; i++){
            int sum = 0;
            dp[i][0] = dp[i-1][10];
            for(int j = 1; j < 10; j++){
                dp[i][j] = (dp[i-1][10] - dp[i-1][j-1]) % 10007;
                dp[i-1][10] -= dp[i-1][j-1];
                sum += dp[i][j];
            }
            dp[i][10] = sum + dp[i][0];
        }
        System.out.println(dp[n][10] % 10007);
    }
}
