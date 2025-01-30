package bj.dp;

import java.util.Scanner;

public class BOJ2294 {
    private static final int[] arr = new int[10001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int min = Integer.MAX_VALUE;

        for(int i = 0;i<n;i++) {
            int k = sc.nextInt();
            min = Math.min(min,k);
            for(int j = 1; j * k <= m;j++) {
                if(arr[j*k] == 0 || arr[j*k] > j) {
                    arr[j*k] = j;
                }
            }
        }

        dp(m, min);
        System.out.println(getResult(m));
    }

    private static void dp(int num, int min){
        for(int i = min + 1; i < num+1; i++){
            int m = Integer.MAX_VALUE;
            for(int j = 1; j <= i/2; j++){
                if(arr[j] != 0 && arr[i-j] != 0){
                    m = Math.min(m,arr[j] + arr[i-j]);
                }
            }
            if(m != Integer.MAX_VALUE && arr[i] != 0){
                arr[i] = Math.min(arr[i], m);
            }
            else if(m != Integer.MAX_VALUE && arr[i] == 0){
                arr[i] = m;
            }
        }
    }

    private static int getResult(int n){
        if(arr[n] == 0){
            return -1;
        }
        return arr[n];
    }
}
