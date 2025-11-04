package bj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][2];
        int[] val = new int[n + 1];
        int res = 0;
        StringTokenizer st;
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i <= n; i++) {
            int tmp = arr[i][0] + i - 1;
            val[i] = Math.max(val[i-1], val[i]);
            if(tmp <= n){//걸리는 날짜 arr[i][0], 이후 날짜 arr[i][0] + i - 1
                val[tmp] = Math.max(val[tmp], arr[i][1] + val[i-1]);
                res = Math.max(res, val[tmp]);
            }
        }
        System.out.println(res);
    }
}
