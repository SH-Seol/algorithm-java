package bj.recursive;

import java.util.Scanner;

public class BOJ1629 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextInt();
        long target = sc.nextInt();
        long divide = sc.nextInt();

        System.out.println(calc(num, target, divide));

    }

    public static long calc(long num, long target, long divide){
        //base condition
        if(target == 1){
            return num % divide;
        }
        long res = calc(num, target/2, divide);
        res = res * res % divide;
        if(target % 2 != 0){
            return num * res % divide;
        }
        return res;
    }
}
