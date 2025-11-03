package bj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr= new int[n+1][2];//2번째 값의 0번째 인덱스는 횟수, 1번째 인덱스는 앞의 값
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < n+1; i++) {
            arr[i][0] = Integer.MAX_VALUE;
        }
        arr[0][0] = arr[1][0] = 0;

        for(int i = 1; i<=n; i++){
            if(i * 3 <= n){
                if(arr[i][0] + 1 < arr[i * 3][0]){
                    arr[i * 3][0] = arr[i][0] + 1;
                    arr[i * 3][1] = i;
                }
            }
            if(i * 2 <= n){
                if(arr[i][0] + 1 < arr[i * 2][0]){
                    arr[i * 2][0] = arr[i][0] + 1;
                    arr[i * 2][1] = i;
                }
            }
            if(i + 1 <= n){
                if(arr[i][0] + 1 < arr[i + 1][0]){
                    arr[i + 1][0] = arr[i][0] + 1;
                    arr[i + 1][1] = i;
                }
            }
        }
        sb.append(arr[n][0]).append("\n").append(n).append(" ");

        while(n > 1){
            sb.append(arr[n][1]).append(" ");
            n = arr[n][1];
        }
        System.out.println(sb);
    }
}
