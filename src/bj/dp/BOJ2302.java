package bj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2302 {
    public static void main(String[] args) throws IOException {
        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i = 4; i <= 40; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());//9
        int m = Integer.parseInt(br.readLine());//2
        int[] arr = new int[m+1];
        int start = 0;
        for(int i = 0; i < m; i++) {
            int k = Integer.parseInt(br.readLine());//4,7
            arr[i] = k - start - 1;
            start = k;
        }
        arr[m] = (start == 0) ? n : n - start;
        int res = 1;
        for(int i = 0; i <= m; i++){
            res *= dp[arr[i]];
        }
        System.out.println(res);
    }
}
