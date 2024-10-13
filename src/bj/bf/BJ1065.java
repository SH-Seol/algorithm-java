package bj.bf;

import java.util.Scanner;

public class BJ1065 {
    static int n;
    static int result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        solution();
        System.out.println(result);
    }

    public static void solution(){
        if(n < 100){
            result = n;
        }
        else{
            result = 99;
            for(int i = 100; i <= n; i++){
                int x = i/100;
                int y = (i/10)%10;
                int z = i%10;
                if((x-y) == (y-z)){
                    result++;
                }
            }

        }
    }
}
