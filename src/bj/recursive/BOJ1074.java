package bj.recursive;

import java.util.Scanner;

public class BOJ1074 {
    static int r;
    static int c;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();

        z(n, 0, 0, 0);
    }

    public static void z(int n, int x, int y, int cnt){
        if(n == 0){
            if(x == r && y == c){
                System.out.println(cnt);
            }
            return;
        }
        if(r <= x + (1<<(n-1)) && c <= y + (1<<(n-1))){
            z(n-1, x, y, cnt);
        }
        if(r <= x + (1<<(n-1)) && c >= y + (1<<(n-1))){
            z(n-1, x, y + (1<<(n-1)) , cnt + (1<<(2*n-2)));
        }
        if(r >= x + (1<<(n-1)) && c <= y + (1<<(n-1))){
            z(n-1, x + (1<<(n-1)), y, cnt + 2 * (1<<(2*n-2)));
        }
        if(r >= x + (1<<(n-1)) && c >= y + (1<<(n-1))){
            z(n-1, x + (1<<(n-1)), y +(1<<(n-1)), cnt + 3 * (1<<(2*n-2)));
        }
    }
}
