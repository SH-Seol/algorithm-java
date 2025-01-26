package bj.dp;

import java.util.Scanner;

public class BOJ9461 {
    public static final long[] arr = new long[101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;
        arr[5] = 2;

        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            System.out.println(getN(a));
        }
        sc.close();
    }
    public static long getN(int n) {
        if (arr[n] != 0)
        {
            return arr[n];
        }
        arr[n] = getN(n - 1) + getN(n - 5);
        return arr[n];
    }
}
