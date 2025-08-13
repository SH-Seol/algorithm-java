package bj.recursive;

import java.util.Scanner;

public class BOJ2448 {
    static char[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        arr = new char[n][2 * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n; j++) {
                arr[i][j] = ' ';
            }
        }//빈칸 채우기

        star(n, 0, n - 1);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 2 * n; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    public static void star(int n, int x, int y){
        if(n == 3){
            arr[x][y] = '*';
            arr[x + 1][y - 1] = '*';
            arr[x + 1][y + 1] = '*';
            arr[x + 2][y - 2] = '*';
            arr[x + 2][y] = '*';
            arr[x + 2][y + 2] = '*';
            arr[x + 2][y + 1] = '*';
            arr[x + 2][y - 1] = '*';
            return;
        }

        int num = n/2;

        star(num, x, y);
        star(num, x + num, y - num);
        star(num, x + num, y + num);
    }
}
