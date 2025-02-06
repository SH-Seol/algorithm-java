package bj.dp;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2565 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];

        for(int i = 0;i<n;i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int result = dp(arr);
        System.out.println(n-result);
    }

    public static int dp(int[][] arr) {
        int[] result = new int[arr.length+1];
        int[] compare = new int[arr.length+1];
        int temp = 0;
        for(int i = 1;i<arr.length+1;i++) {
            for(int j = 1;j<arr.length+1;j++) {
                if(compare[j] == 0 || arr[i-1][1] < compare[j]) {
                    compare[j] = arr[i-1][1];
                    result[i] = j;
                    temp = Math.max(temp, result[i]);
                    break;
                }
            }
        }
        return temp;
    }
}
