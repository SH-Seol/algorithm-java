package bj.stack;

import java.util.Scanner;
import java.util.Stack;

public class BOJ1874 {

    static StringBuilder sb = new StringBuilder();
    static Stack<Integer> stack = new Stack<>();
    static boolean flag = false;
    static int num = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            stacking(sc.nextInt());
            if(flag){
                System.out.println("NO");
                break;
            }
        }
        if(!flag){
            System.out.println(sb.toString());
        }
    }
    public static void stacking(int n){
        //stack이 비었을 때,
        if(stack.isEmpty()){
            while(num <= n){
                stack.push(num);
                sb.append("+\n");
                num++;
            }
            sb.append("-\n");
            stack.pop();
        }
        //stack에 내용물이 있을 때 n이 peek보다 큰 경우
        else if(!stack.isEmpty() && stack.peek() < n){
            while(num <= n){
                stack.push(num);
                sb.append("+\n");
                num++;
            }
            sb.append("-\n");
            stack.pop();
        }
        //stack에 내용물이 있는데, n이 peek인 경우
        else if(!stack.isEmpty() && stack.peek() == n){
            stack.pop();
            sb.append("-\n");
        }
        //stack에 내용물이 있는데, n이 peek보다 작은 경우
        else if(!stack.isEmpty() && stack.peek() > n){
            flag = true;
        }
    }
}
