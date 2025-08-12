package bj.recursive;

import java.util.Scanner;

public class BOJ2447 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0;i<n;i++) {
            for(int j = 0;j<n;j++) {
                star(n, i, j);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void star(int n, int x, int y){
        if(n == 1){
            sb.append('*');
            return;
        }
        if(x % 3 == 1 && y % 3 == 1){
            sb.append(" ");
            return;
        }
        star(n/ 3, x /3, y /3);
    }
}
